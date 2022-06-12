package com.petarjk.spring.service;

import java.util.List;

import com.petarjk.spring.entity.Customer;
import com.petarjk.spring.entity.SalesRepresentative;

public interface SalesRepService {

	public List<SalesRepresentative> getSalesRepresentatives();

	public void saveSalesRep(SalesRepresentative theSalesRepresentative);

	public SalesRepresentative getSalesRepresentative(int theId);

	public void delete(int theId);

	public List<SalesRepresentative> searchSalesRep(String theSearchName);

	public List<Customer> listAssignedCustomers(int theSalesRepId);

	public void assignCustomer(int theCustomerId);

	public void unassignCustomer(int theCustomerId);
}
