package com.newsfeed.decorators;

import java.util.ArrayList;

import com.newsfeed.entities.Headline;
import com.newsfeed.model.IHeadline;

public abstract class HeadlineDecorator implements IHeadline {
	IHeadline headline;
	
	public HeadlineDecorator(IHeadline headline) {
		this.headline = headline;
	}
	
	@Override
	public ArrayList<Headline> getHeadlines() {
		return headline.getHeadlines();
	}

}
