package com.trickytechnos.cdb.dao;

import java.util.List;

import com.trickytechnos.cdb.domain.Customer;

public interface CustomerDAO {
	
	public void addCustomer(Customer customer);
	public Customer getCustomer(int id);
	public void updateCustomer(Customer customer);
	public void deleteCustomer(int id);
	public List<Customer> getCustomers();

}
