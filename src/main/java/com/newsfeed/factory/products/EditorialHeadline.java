package com.newsfeed.factory.products;

import com.newsfeed.entities.Headline;

public class EditorialHeadline extends SuperHeadline {
	
	public EditorialHeadline(String headline){
		this.headline = new Headline(headline,4);
		
	}
	

}
