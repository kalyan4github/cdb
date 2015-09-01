package com.trickytechnos.cdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView addCustomer(@ModelAttribute Customer customer){
		ModelAndView modelAndView = new ModelAndView("viewAllCustomer");
		customerService.addCustomer(customer);
		String message="Customer sucessfully added";
		modelAndView.addObject("message", message);
		return modelAndView;
	}
	
	@RequestMapping(value="/list")
	public ModelAndView listOfCustomers(){
		ModelAndView modelAndView = new ModelAndView("viewAllCustomer");
		List<Customer> customers = customerService.getCustomers();
		modelAndView.addObject("customers", customers);
		return modelAndView;
	}
	@RequestMapping(value="edit/{id}", method=RequestMethod.GET)
	public ModelAndView editCustomerPage(@PathVariable Integer id){
		ModelAndView modelAndView =  new ModelAndView("editCustomer");
		Customer customer= customerService.getCustomer(id);
		modelAndView.addObject("Customer", customer);
		return modelAndView;
	}
	@RequestMapping(value="/edit/{id}",method=RequestMethod.POST)
	public ModelAndView editCustomer(@ModelAttribute Customer customer, @PathVariable Integer id){
		ModelAndView modelAndView = new ModelAndView("viewAllCustomer");
		customerService.updateCustomer(customer);
		String message = "Customer was successfully edited";
		modelAndView.addObject("message", message);
		return modelAndView;
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public ModelAndView deleteCustomer(@PathVariable Integer id){
		ModelAndView modelAndView = new ModelAndView("viewAllCustomer");
		customerService.deleteCustomer(id);
		String message="Customer was successfully deleted";
		modelAndView.addObject("message", message);
		return modelAndView;
	}
}
