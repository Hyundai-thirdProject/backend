package com.hd.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.connection.User;
import com.hd.domain.MemberVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {


	@PostMapping(value="android")
	@ResponseBody
	public String androidResponse(@RequestBody User user) {

		System.out.println("Connection from Android");
		System.out.println("id: " + user.getid() + ", pw: " + user.getpassword());
		
		return "1";
	}
	
	@PostMapping("mem/join")
	@ResponseBody
	public String memberResponse(@RequestBody MemberVO member) {
		System.out.println("id: " + member.getMid() + ", pw: " + member.getPassword());
		return "success";
	}
	
}
