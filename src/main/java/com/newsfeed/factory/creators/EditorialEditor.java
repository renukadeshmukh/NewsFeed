package com.newsfeed.factory.creators;

import com.newsfeed.factory.products.ClassifiedsHeadline;
import com.newsfeed.factory.products.EditorialHeadline;
import com.newsfeed.factory.products.SuperHeadline;

public class EditorialEditor extends SuperEditor {
	
	@Override
	public SuperHeadline createHeadline(String headline) {
		SuperHeadline head = new EditorialHeadline(headline);
		return head;
	}

}
