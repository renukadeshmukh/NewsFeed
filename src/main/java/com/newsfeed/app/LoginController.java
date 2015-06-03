package com.newsfeed.app;

import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import com.newsfeed.dao.NewsDal;
import com.newsfeed.entities.Headline;
import com.newsfeed.entities.User;
import com.newsfeed.model.BaseHeadline;

@Controller
@SessionAttributes("sessionUser")
public class LoginController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	//@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(Locale locale, Model model, HttpSession session) {
		logger.info("Welcome home! The client locale is {}.", locale);

		return "login";
	}

	//@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(@RequestParam("username") String uname,
			@RequestParam("pwd") String pwd, Locale locale, Model model,
			HttpSession session) {
		logger.info("Welcome home! The client locale is {}.", locale);

		
		User u = new User();
		u = u.getUser(uname, pwd);
		if (u != null) {

			model.addAttribute("sessionUser", u);

			if (u.getRole() == 1) {
				return "redirect:admin";
			} else if (u.getRole() == 2)
				return "redirect:editor";
			else
				return "redirect:newsfeed";
		}
		return "login";
	}

	//@RequestMapping(value = "register", method = RequestMethod.GET)
	public String register(Locale locale, Model model, HttpSession session) {
		logger.info("Welcome home! The client locale is {}.", locale);

		return "register";
	}

	//@RequestMapping(value = "addEditor", method = RequestMethod.GET)
	public String addEditor(Locale locale, Model model, HttpSession session) {
		logger.info("Welcome home! The client locale is {}.", locale);

		return "addEditor";
	}

	//@RequestMapping(value = "registeruser", method = RequestMethod.POST)
	public String registerUser(@RequestParam("name") String name,
			@RequestParam("email") String email,
			@RequestParam("pwd") String pwd, @RequestParam("addr") String addr,
			@RequestParam("gender") int gender, Locale locale, Model model,
			HttpSession session) {
		logger.info("Welcome home! The client locale is {}.", locale);

		User u = new User(name, email, pwd, addr, gender, -1);
		u.registerUser(u, 3);
		return "redirect:login";
	}

	//@RequestMapping(value = "registereditor", method = RequestMethod.POST)
	public String registerEditor(@RequestParam("name") String name,
			@RequestParam("email") String email,
			@RequestParam("pwd") String pwd, @RequestParam("addr") String addr,
			@RequestParam("gender") int gender, @RequestParam("dept") int dept,
			Locale locale, Model model, HttpSession session) {
		logger.info("Welcome home! The client locale is {}.", locale);

		User u = new User(name, email, pwd, addr, gender, dept);
		u.registerUser(u, 2);
		return "redirect:admin";
	}

	//@RequestMapping(value = "deleteuser", method = RequestMethod.GET)
	public String deleteUser(@RequestParam("uid") int uid, Locale locale,
			Model model, HttpSession session) {
		logger.info("Welcome home! The client locale is {}.", locale);

		User u = new User();
		u.deleteUser(uid);
		return "redirect:admin";
	}

	//@RequestMapping(value = "admin")
	public String admin(Locale locale, Model model, HttpSession session) {
		logger.info("Welcome home! The client locale is {}.", locale);

		User u = new User();
		
		ArrayList<User> editors = u.getAllEditors();
		model.addAttribute("editors", editors);

		return "admin";

	}
	
	//@RequestMapping(value = "editor")
	public String editor(Locale locale, Model model, HttpSession session) {
		logger.info("Welcome home! The client locale is {}.", locale);

		User u = (User) session.getAttribute("sessionUser");
		BaseHeadline bh = new BaseHeadline();
		ArrayList<Headline> headlines = bh.getHeadlinesForEditors(u.getDept());
		model.addAttribute("headlines", headlines);
		
		User editor = (User)session.getAttribute("sessionUser");
		model.addAttribute("sessionUser", editor);
		
		if(u.getDept() == 1)
			model.addAttribute("department", "Editorial");
		else if(u.getDept() == 2)
			model.addAttribute("department", "Weather");
		else if(u.getDept() == 3)
			model.addAttribute("department", "Classifieds");
		else if(u.getDept() == 4)
			model.addAttribute("department", "Sports");
	
		
		return "editor";

	}


	//@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(Locale locale, Model model, HttpSession session) {
		logger.info("Welcome home! The client locale is {}.", locale);

		session.invalidate();
		model.asMap().clear();
		return "redirect:login";
	}

}
