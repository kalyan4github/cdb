package com.trickytechnos.cdb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trickytechnos.cdb.dao.CustomerDAO;
import com.trickytechnos.cdb.domain.Customer;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDAO customerDAO;

	@Override
	public void addCustomer(Customer customer) {
		customerDAO.addCustomer(customer);

	}

	@Override
	public Customer getCustomer(int id) {		
		return customerDAO.getCustomer(id);
	}

	@Override
	public void updateCustomer(Customer customer) {
		customerDAO.updateCustomer(customer);
	}

	@Override
	public void deleteCustomer(int id) {
		customerDAO.deleteCustomer(id);
	}

	@Override
	public List<Customer> getCustomers() {		
		return customerDAO.getCustomers();
	}

}
