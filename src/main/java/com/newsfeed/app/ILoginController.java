package com.newsfeed.app;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

public interface ILoginController {

	public String login(Locale locale, Model model, HttpSession session);
	
	public String login(String uname, String pwd, Locale locale, Model model, HttpSession session);
	
	public String register(Locale locale, Model model, HttpSession session);
	
	public String addEditor(Locale locale, Model model, HttpSession session);
	
	public String registerUser(String name, String email,String pwd,String addr, int gender, Locale locale, Model model,
			HttpSession session);
	
	public String registerEditor(String name, String email, String pwd, String addr, int gender, int dept, 
			Locale locale, Model model, HttpSession session);
	
	public String deleteUser( int uid, Locale locale, Model model, HttpSession session);
	
	public String admin(Locale locale, Model model, HttpSession session);
	
	public String editor(Locale locale, Model model, HttpSession session);
	
	public String logout(Locale locale, Model model, HttpSession session);
}
