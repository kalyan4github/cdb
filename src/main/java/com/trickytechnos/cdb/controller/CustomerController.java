package com.trickytechnos.cdb.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.trickytechnos.cdb.domain.Customer;
import com.trickytechnos.cdb.service.CustomerService;

@Controller
@RequestMapping(value="/customer")
public class CustomerController {
	static Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerService customerService;	
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addCustomerPage(Model model){
		
		logger.info("IN: Customer/add-GET");
		
		if(! model.containsAttribute("customer")) {
            logger.info("Adding Customer object to model");
            Customer customer = new Customer();
            model.addAttribute("customer", customer);
        }
		return "newCustomer";
		
	}
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addCustomer(@Valid @ModelAttribute Customer customer, BindingResult result, 
			Model model,RedirectAttributes redirectAttrs){
		
		logger.info("IN: Customer/add-POST");
		//logger.info("mobileno: "+customer.getMobileNo());
		
		if(result.hasErrors()){
			logger.info("Stragies-add error: "+result.toString());
			redirectAttrs.addFlashAttribute("org.springframework.validation.BindingResult.customer", result);
			redirectAttrs.addAttribute("customer", customer);
			return "redirect:/customer/add";
		} else{
			customerService.addCustomer(customer);
			String message="Customer " +customer.getId() +" sucessfully added";
			redirectAttrs.addAttribute("message", message);
			model.addAttribute("message", message);
			return "redirect:/customer/add";
		}		
	}
	
	/*@RequestMapping(value="/list")
	public ModelAndView listOfCustomers(){
		ModelAndView modelAndView = new ModelAndView("viewAllCustomer");
		List<Customer> customers = customerService.getCustomers();
		modelAndView.addObject("customers", customers);
		return modelAndView;
	}*/
	/*@RequestMapping(value="edit/{id}", method=RequestMethod.GET)
	public ModelAndView editCustomerPage(@PathVariable Integer id){
		ModelAndView modelAndView =  new ModelAndView("editCustomer");
		Customer customer= customerService.getCustomer(id);
		modelAndView.addObject("Customer", customer);
		return modelAndView;
	}*/
	/*@RequestMapping(value="/edit/{id}",method=RequestMethod.POST)
	public ModelAndView editCustomer(@ModelAttribute Customer customer, @PathVariable Integer id){
		ModelAndView modelAndView = new ModelAndView("viewAllCustomer");
		customerService.updateCustomer(customer);
		String message = "Customer was successfully edited";
		modelAndView.addObject("message", message);
		return modelAndView;
	}
	*/
	/*@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public ModelAndView deleteCustomer(@PathVariable Integer id){
		ModelAndView modelAndView = new ModelAndView("viewAllCustomer");
		customerService.deleteCustomer(id);
		String message="Customer was successfully deleted";
		modelAndView.addObject("message", message);
		return modelAndView;
	}*/
}
