package com.newsfeed.factory.products;

import java.sql.SQLException;

import com.newsfeed.dao.NewsDal;
import com.newsfeed.entities.Headline;

public abstract class SuperHeadline {
	Headline headline;
	
	public void addHeadline(String headline) {
		// TODO Auto-generated method stub
		NewsDal ndal = new NewsDal();
		try {
			ndal.insertFeed(this.headline);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
