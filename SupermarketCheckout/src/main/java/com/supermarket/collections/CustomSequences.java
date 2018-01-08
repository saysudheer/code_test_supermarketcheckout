package com.supermarket.collections;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 * Provides the collection to generate sequence id for items id attribute
 *
 */
@Document(collection = "customSequences")
	public class CustomSequences {
	    @Id
	    private String id;
	    public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public int getSeq() {
			return seq;
		}
		public void setSeq(int seq) {
			this.seq = seq;
		}
		private int seq;

	
	}

