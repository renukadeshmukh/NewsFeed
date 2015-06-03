package com.newsfeed.factory.products;

import java.sql.SQLException;

import com.newsfeed.dao.NewsDal;
import com.newsfeed.entities.Headline;

public class SportsHeadline extends SuperHeadline {

	public SportsHeadline(String headline){
		this.headline = new Headline(headline,4);
		
	}
	
	

}
