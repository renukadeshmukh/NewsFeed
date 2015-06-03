package com.newsfeed.factory.creators;

import com.newsfeed.factory.products.ClassifiedsHeadline;
import com.newsfeed.factory.products.SuperHeadline;

public class ClassifiedsEditor extends SuperEditor{

	@Override
	public SuperHeadline createHeadline(String headline) {
		SuperHeadline head = new ClassifiedsHeadline(headline);
		return head;
	}

}
