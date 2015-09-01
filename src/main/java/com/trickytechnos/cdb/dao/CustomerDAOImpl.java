package com.trickytechnos.cdb.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.trickytechnos.cdb.domain.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addCustomer(Customer customer) {
		getCurrentSession().save(customer);
	}

	@Override
	public Customer getCustomer(int id) {
		Customer customer = (Customer) getCurrentSession().get(Customer.class,id);
		return customer;
	}

	@Override
	public void updateCustomer(Customer customer) {
		Customer customerToUpdate = getCustomer(customer.getId());
		customerToUpdate.setFirstName(customer.getFirstName());
		customerToUpdate.setLastName(customer.getLastName());
		customerToUpdate.setMobileNo(customer.getMobileNo());
		customerToUpdate.setAddress(customer.getAddress());
		getCurrentSession().update(customerToUpdate);

	}

	@Override
	public void deleteCustomer(int id) {
		Customer customer = getCustomer(id);
		if(customer!= null)
			getCurrentSession().delete(customer);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getCustomers() {		
		return getCurrentSession().createQuery("from Customer").list();
	}

}
