package com.newsfeed.app;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

public interface INewsController {
	
	public String viewNewsFeeds(Locale locale, Model model, HttpSession session);
	
	public String viewInternetFeeds(Locale locale, Model model, HttpSession session);
	
	public String viewTwitterFeeds(Locale locale, Model model, HttpSession session);
	
	public String deleteHeadline(int fid, Locale locale, Model model, HttpSession session);
	
	public String addHeadline(String headline, Locale locale, Model model, HttpSession session);

}
