package com.newsfeed.factory.creators;

import com.newsfeed.factory.products.SportsHeadline;
import com.newsfeed.factory.products.SuperHeadline;
import com.newsfeed.factory.products.WeatherHeadline;

public class WeatherEditor extends SuperEditor {

	@Override
	public SuperHeadline createHeadline(String headline) {
		SuperHeadline head = new WeatherHeadline(headline);
		return head;
	}

}
