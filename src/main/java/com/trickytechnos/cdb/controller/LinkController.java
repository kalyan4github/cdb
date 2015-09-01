package com.trickytechnos.cdb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LinkController {
	
	@RequestMapping(value="/")
	public ModelAndView mainPage(){
		return new ModelAndView("index");
	}
	
	@RequestMapping(value="/newCustomer")
	public ModelAndView indexPage(){
		return new ModelAndView("pages/forms/newCustomer");
	}
		
}
