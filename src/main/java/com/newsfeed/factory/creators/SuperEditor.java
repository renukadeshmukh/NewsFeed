package com.newsfeed.factory.creators;

import com.newsfeed.entities.Headline;
import com.newsfeed.factory.products.SuperHeadline;

public abstract class SuperEditor {
	
	public abstract SuperHeadline createHeadline(String headline);
}
