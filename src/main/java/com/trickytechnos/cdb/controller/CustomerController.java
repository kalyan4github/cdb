package com.trickytechnos.cdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.trickytechnos.cdb.domain.Customer;
import com.trickytechnos.cdb.service.CustomerService;

@Controller
@RequestMapping(value="/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public ModelAndView addCustomerPage(){
		ModelAndView modelAndView = new ModelAndView("newCustomer");
		modelAndView.addObject("customer", new Customer());
		return modelAndView;
	}
}
