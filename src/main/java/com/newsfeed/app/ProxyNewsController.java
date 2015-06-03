package com.newsfeed.app;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.newsfeed.decorators.InternetDecorator;
import com.newsfeed.decorators.NewsDecorator;
import com.newsfeed.decorators.TwitterDecorator;
import com.newsfeed.entities.Headline;
import com.newsfeed.entities.HeadlineType;
import com.newsfeed.entities.User;
import com.newsfeed.model.BaseHeadline;
import com.newsfeed.model.IHeadline;

@Controller
@SessionAttributes("sessionUser")

public class ProxyNewsController implements INewsController {
	
	NewsController nc = new NewsController();
	
	@RequestMapping(value = "newsfeed", method = RequestMethod.GET)
	public String viewNewsFeeds(Locale locale, Model model, HttpSession session) {

		User u = (User) session.getAttribute("sessionUser");
		if(u!=null && u.getRole()==3)
			return nc.viewNewsFeeds(locale, model, session);
		return "redirect:login";
	}
	
	@RequestMapping(value = "internetfeed", method = RequestMethod.GET)
	public String viewInternetFeeds(Locale locale, Model model, HttpSession session) {
		
		User u = (User) session.getAttribute("sessionUser");
		if(u!=null && u.getRole()==3)
			return nc.viewInternetFeeds(locale, model, session);
		return "redirect:login";
	}
	
	@RequestMapping(value = "twitterfeed", method = RequestMethod.GET)
	public String viewTwitterFeeds(Locale locale, Model model, HttpSession session) {

		User u = (User) session.getAttribute("sessionUser");
		if(u!=null && u.getRole()==3)
			return nc.viewTwitterFeeds(locale, model, session);
		return "redirect:login";
	}
	
	@RequestMapping(value = "deletefeed", method = RequestMethod.GET)
	public String deleteHeadline(@RequestParam("fid") int fid, Locale locale,
			Model model, HttpSession session) {
		
		User u = (User) session.getAttribute("sessionUser");
		if(u!=null && u.getRole()==2)
			return nc.deleteHeadline(fid, locale, model, session);
		return "redirect:login";
	}
	
	@RequestMapping(value = "addHeadline", method = RequestMethod.POST)
	public String addHeadline(@RequestParam("headline") String headline, Locale locale, Model model, HttpSession session) {
		
		User u = (User) session.getAttribute("sessionUser");
		if(u!=null && u.getRole()==2)
			return nc.addHeadline(headline, locale, model, session);
		return "redirect:login";
	}

}
