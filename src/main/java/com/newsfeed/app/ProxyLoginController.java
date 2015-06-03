package com.newsfeed.app;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.newsfeed.entities.User;

@Controller
@SessionAttributes("sessionUser")

public class ProxyLoginController implements ILoginController {

	LoginController lc = new LoginController();

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(Locale locale, Model model, HttpSession session) {
		return lc.login(locale, model, session);
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(@RequestParam("username") String uname,
			@RequestParam("pwd") String pwd, Locale locale, Model model,
			HttpSession session) {
		return lc.login(uname, pwd, locale, model, session);
	}

	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String register(Locale locale, Model model, HttpSession session) {
		return lc.register(locale, model, session);
	}

	@RequestMapping(value = "addEditor", method = RequestMethod.GET)
	public String addEditor(Locale locale, Model model, HttpSession session) {
		User u = (User) session.getAttribute("sessionUser");
		if (u != null && u.getRole() == 1)
			return lc.addEditor(locale, model, session);
					
		return "redirect:login";
	}
	
	@RequestMapping(value = "registeruser", method = RequestMethod.POST)
	public String registerUser(@RequestParam("name") String name,
			@RequestParam("email") String email,
			@RequestParam("pwd") String pwd, @RequestParam("addr") String addr,
			@RequestParam("gender") int gender, Locale locale, Model model,
			HttpSession session) {
		return lc.registerUser(name, email, pwd, addr, gender, locale, model, session);
		}

	@RequestMapping(value = "registereditor", method = RequestMethod.POST)
	public String registerEditor(@RequestParam("name") String name,
			@RequestParam("email") String email,
			@RequestParam("pwd") String pwd, @RequestParam("addr") String addr,
			@RequestParam("gender") int gender, @RequestParam("dept") int dept,
			Locale locale, Model model, HttpSession session) {

		User u = (User) session.getAttribute("sessionUser");
		if (u != null && u.getRole() == 1)
			return lc.registerEditor(name, email, pwd, addr, gender, dept,
					locale, model, session);
		return "redirect:login";
	}

	@RequestMapping(value = "deleteuser", method = RequestMethod.GET)
	public String deleteUser(@RequestParam("uid") int uid, Locale locale,
			Model model, HttpSession session) {

		User u = (User) session.getAttribute("sessionUser");
		if (u != null && u.getRole() == 1)
			return lc.deleteUser(uid, locale, model, session);
		return "redirect:login";
	}

	@RequestMapping(value = "admin")
	public String admin(Locale locale, Model model, HttpSession session) {

		User u = (User) session.getAttribute("sessionUser");
		if (u != null && u.getRole() == 1)
			return lc.admin(locale, model, session);
		return "redirect:login";

	}

	@RequestMapping(value = "editor")
	public String editor(Locale locale, Model model, HttpSession session) {

		User u = (User) session.getAttribute("sessionUser");
		if (u != null && u.getRole() == 2)
			return lc.editor(locale, model, session);
		return "redirect:login";
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(Locale locale, Model model, HttpSession session) {
		return lc.logout(locale, model, session);
	}

}
