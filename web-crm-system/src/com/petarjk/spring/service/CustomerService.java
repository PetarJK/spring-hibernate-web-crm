package com.petarjk.spring.service;

import java.util.List;

import com.petarjk.spring.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void delete(int theId);
}