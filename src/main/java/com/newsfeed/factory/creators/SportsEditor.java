package com.newsfeed.factory.creators;

import com.newsfeed.entities.Headline;
import com.newsfeed.factory.products.SportsHeadline;
import com.newsfeed.factory.products.SuperHeadline;

public class SportsEditor extends SuperEditor {

	@Override
	public SuperHeadline createHeadline(String headline) {

		SuperHeadline head = new SportsHeadline(headline);
		return head;
	}

}
