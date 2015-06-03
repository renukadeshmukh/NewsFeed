package com.newsfeed.app;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class NewsController implements INewsController {
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	//@RequestMapping(value = "newsfeed", method = RequestMethod.GET)
	public String viewNewsFeeds(Locale locale, Model model, HttpSession session) {

		IHeadline headline = new NewsDecorator(new BaseHeadline(HeadlineType.NewsFeed));
		ArrayList<Headline> headlines = headline.getHeadlines();
		model.addAttribute("newsfeeds", headlines);
		User editor = (User)session.getAttribute("sessionUser");
		model.addAttribute("sessionUser", editor);
		
		return "newsfeed";
	}
	
	//@RequestMapping(value = "internetfeed", method = RequestMethod.GET)
	public String viewInternetFeeds(Locale locale, Model model, HttpSession session) {
		
		IHeadline headline = new InternetDecorator(new BaseHeadline(HeadlineType.InternetFeed));
		ArrayList<Headline> headlines = headline.getHeadlines();
		model.addAttribute("internetfeeds", headlines);
		User editor = (User)session.getAttribute("sessionUser");
		model.addAttribute("sessionUser", editor);
		
		return "internetfeed";
	}
	
	//@RequestMapping(value = "twitterfeed", method = RequestMethod.GET)
	public String viewTwitterFeeds(Locale locale, Model model, HttpSession session) {

		IHeadline headline = new TwitterDecorator(new BaseHeadline(HeadlineType.TwitterFeed));
		ArrayList<Headline> headlines = headline.getHeadlines();
		model.addAttribute("twitterfeeds", headlines);
		User editor = (User)session.getAttribute("sessionUser");
		model.addAttribute("sessionUser", editor);
		
		return "twitterfeed";
	}
	
	//@RequestMapping(value = "deletefeed", method = RequestMethod.GET)
	public String deleteHeadline(@RequestParam("fid") int fid, Locale locale,
			Model model, HttpSession session) {
		
		BaseHeadline bh = new BaseHeadline();
		try {
			bh.deleteHeadline(fid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "redirect:editor";
	}
	
	//@RequestMapping(value = "addHeadline", method = RequestMethod.POST)
	public String addHeadline(@RequestParam("headline") String headline, Locale locale, Model model, HttpSession session) {
		
		User editor = (User)session.getAttribute("sessionUser");
		BaseHeadline bh = new BaseHeadline();
		bh.addHeadline(headline, editor.getDept());
		return "redirect:editor";
	}

}
