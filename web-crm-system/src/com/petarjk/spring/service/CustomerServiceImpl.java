package com.petarjk.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.petarjk.spring.dao.CustomerDAO;
import com.petarjk.spring.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;

	@Override
	@Transactional
	public List<Customer> getCustomers() {

		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {

		customerDAO.saveCustomer(theCustomer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int theId) {

		return customerDAO.getCustomer(theId);
	}

	@Override
	@Transactional
	public void delete(int theId) {

		customerDAO.delete(theId);
	}

	@Override
	@Transactional
	public List<Customer> searchCustomers(String theSearchName) {

		List<Customer> theCustomers = customerDAO.searchCustomers(theSearchName);

		return theCustomers;
	}
}
