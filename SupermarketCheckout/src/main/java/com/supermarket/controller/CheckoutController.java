package com.supermarket.controller;

import java.math.BigDecimal;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.supermarket.collections.CartItems;
import com.supermarket.collections.CheckoutCart;
import com.supermarket.collections.Items;
import com.supermarket.config.NextSequenceId;
import com.supermarket.repository.ItemsRepository;
import com.supermarket.service.CheckoutCartService;

/**
* The CheckoutController implements REST call URL's
* associated with cart collection.
* Each item added to cart is saved in session and retrieved while processing checkout of all items. 
*
* @author  Sudheer Kosuru
* @version 1.0
* @since   2018-01-07 
*/

@RestController
@RequestMapping("supermarket/api")
public class CheckoutController {
	
	@Autowired
	private CheckoutCartService checkoutCartService;
	@Autowired
	private ItemsRepository itemsrepo;
	@Autowired
	private NextSequenceId seqid;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * This @url /addtocart/items  Adds an item to cart with request parameters. 
	 * @RequestParam itemId
	 * @RequestParam quantity
	 * While adding an item to session cart,goods are priced individually. 
	 * In addition, some items are multipriced as buy 'n' of them, and they’ll cost 'y' cents
	 */
	@PostMapping("/addtocart/items")
	public ResponseEntity<CartItems> addtocartItems(HttpSession httpSession,@RequestParam Integer itemId,@RequestParam  Integer quantity){
		
		HttpHeaders httpHeaders = new HttpHeaders();
		
		CartItems cartItems = new CartItems(itemId, quantity);
		log.info("Adding item to cart");
		cartItems.setId(seqid.getNextSequence("customSequences"));
		Items items=itemsrepo.findOne(itemId);
		BigDecimal amount = new BigDecimal(123);
		log.info("Verifying if item has special price");
		if(items.getSpecialPrice()==null)
		 {
			log.info(" item has no special price");			 
			 amount= BigDecimal.valueOf(items.getUnitPrice()*cartItems.getQuantity());
		 }
		 else
		 {
			 log.info(" item has special price");		
			 int orderedqty=cartItems.getQuantity();
			 int offerqty=items.getSpecialPrice().getQuantity();
			 if(orderedqty >=offerqty)
			 {
				 int specialpriceorders=orderedqty/offerqty;
				 int regularpriceorders=orderedqty%offerqty;
				 BigDecimal amountSpecialprice=BigDecimal.valueOf(specialpriceorders*items.getSpecialPrice().getSpecialPrice());
				 BigDecimal amountregularprice=BigDecimal.valueOf(regularpriceorders*items.getUnitPrice());
				 amount=amountSpecialprice.add(amountregularprice);
							 
			 }
			 else{
				 amount= BigDecimal.valueOf(items.getUnitPrice()*cartItems.getQuantity());
			 }
			 
		 }
		
		cartItems.setAmount(amount);
		log.info(" adding item to cart");	
		checkoutCartService.insert(cartItems);
		return new ResponseEntity<>(cartItems, httpHeaders, HttpStatus.OK);
	}
	
	/**
	 * This @url /checkoutcart  fetches all added items from cart 
	 * Items are fetched from session 
	 * 
	 */
	
	@GetMapping("/checkoutcart")
	public ResponseEntity<CheckoutCart> getcheckoutCart(){
		HttpHeaders httpHeaders = new HttpHeaders();
		log.info("Fetching all items in cart");
		CheckoutCart checkoutCart = checkoutCartService.getCheckoutCartSession();
		return new ResponseEntity<CheckoutCart>(checkoutCart, httpHeaders, HttpStatus.OK);
	}

}
