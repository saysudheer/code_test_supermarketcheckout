package com.supermarket.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.supermarket.collections.Items;
import com.supermarket.service.ItemsService;


/**
* The ItemsController implements REST call URL's
* associated with Items collection.
*
* @author  Sudheer Kosuru
* @version 1.0
* @since   2018-01-07 
*/


@RestController
@RequestMapping("supermarket/api")
public class ItemsController {
	
	 // Define the logger object for this class
	  private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ItemsService itemsservice;

	/**
	 * The Items api getItems returns information about the products.
	 * @return List<Items>
	 */
   
    @GetMapping("/getitems")
    public  ResponseEntity<List<Items>> getItems() {
    	HttpHeaders httpHeaders = new HttpHeaders();
    	log.info("--Fetching items from ItemService");
    	List<Items> items=itemsservice.findAll();
        return new ResponseEntity<List<Items>>(items, httpHeaders, HttpStatus.OK);
        		
    }
}
