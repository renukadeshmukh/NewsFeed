package com.newsfeed.model;

import java.sql.SQLException;
import java.util.ArrayList;

import com.newsfeed.dao.NewsDal;
import com.newsfeed.entities.Headline;
import com.newsfeed.entities.HeadlineType;
import com.newsfeed.factory.creators.ClassifiedsEditor;
import com.newsfeed.factory.creators.EditorialEditor;
import com.newsfeed.factory.creators.SportsEditor;
import com.newsfeed.factory.creators.SuperEditor;
import com.newsfeed.factory.creators.WeatherEditor;
import com.newsfeed.factory.products.SuperHeadline;

public class BaseHeadline implements IHeadline {

	HeadlineType type;

	public BaseHeadline(HeadlineType type) {
		this.type = type;
	}

	public BaseHeadline() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Headline> getHeadlines() {
		// TODO Auto-generated method stub
		NewsDal ndal = new NewsDal();
		ArrayList<Headline> headlines = new ArrayList<Headline>();
		try {
			switch (type) {
			case NewsFeed:
				headlines = ndal.getNewsFeeds();

				break;

			case InternetFeed:
				headlines = ndal.getInternetFeeds();
				break;

			case TwitterFeed:
				headlines = ndal.getTwitterFeeds();
				break;

			default:
				break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return headlines;
	}

	public ArrayList<Headline> getHeadlinesForEditors(int deptId) {
		// TODO Auto-generated method stub
		NewsDal ndal = new NewsDal();
		ArrayList<Headline> headlines = new ArrayList<Headline>();
		try {
			headlines = ndal.getNewsFeedsForEditor(deptId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return headlines;
	}

	public void deleteHeadline(int headlineId) throws SQLException {
		NewsDal ndal = new NewsDal();
		ndal.deleteHeadline(headlineId);
	}

	public void addHeadline(String headline, int dept) {
		SuperEditor editor = null;
		
		switch (dept) {
		case 1:
			editor = new EditorialEditor();
			break;

		case 2:
			editor = new WeatherEditor();
			break;
			
		case 3:
			editor = new ClassifiedsEditor();
			break;
			
		case 4:
			editor = new SportsEditor();
			break;

		default:
			break;
		}
		
		SuperHeadline shl = editor.createHeadline(headline);
		shl.addHeadline(headline);
		
	}

}
