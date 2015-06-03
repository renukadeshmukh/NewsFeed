package com.newsfeed.factory.products;

import com.newsfeed.entities.Headline;

public class ClassifiedsHeadline extends SuperHeadline
{
	public ClassifiedsHeadline(String headline){
		this.headline = new Headline(headline,4);
		
	}
	

}
