package com.newsfeed.decorators;

import java.util.ArrayList;

import com.newsfeed.entities.Headline;
import com.newsfeed.model.IHeadline;

public class InternetDecorator extends HeadlineDecorator{

	public InternetDecorator(IHeadline headline) {
		super(headline);
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Headline> getHeadlines() {
		return decorateHeadline(headline.getHeadlines());
	}
	
	public ArrayList<Headline> decorateHeadline(ArrayList<Headline> headlines){
		int i = 1;
		for (Headline headline : headlines) {
			headline.setName("InternetFeed" + i);
			i++;
		}
		return headlines;
	}
}
