package com.newsfeed.factory.products;

import com.newsfeed.entities.Headline;

public class WeatherHeadline extends SuperHeadline {

	public WeatherHeadline(String headline){
		this.headline = new Headline(headline,2);
		
	}

}
