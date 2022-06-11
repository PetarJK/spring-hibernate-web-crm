package com.petarjk.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.petarjk.spring.dao.SalesRepDAO;
import com.petarjk.spring.entity.Customer;
import com.petarjk.spring.entity.SalesRepresentative;

@Service
public class SalesRepServiceImpl implements SalesRepService {

	@Autowired
	private SalesRepDAO salesRepDAO;

	@Override
	@Transactional
	public List<SalesRepresentative> getSalesRepresentatives() {

		return salesRepDAO.getSalesRepresentatives();
	}

	@Override
	@Transactional
	public void saveSalesRep(SalesRepresentative theSalesRepresentative) {

		salesRepDAO.saveSalesRep(theSalesRepresentative);
	}

	@Override
	@Transactional
	public SalesRepresentative getSalesRepresentative(int theId) {

		return salesRepDAO.getSalesRepresentative(theId);
	}

	@Override
	@Transactional
	public void delete(int theId) {

		salesRepDAO.delete(theId);
	}

	@Override
	@Transactional
	public List<SalesRepresentative> searchSalesRep(String theSearchName) {

		return salesRepDAO.searchSalesRep(theSearchName);
	}

	@Override
	@Transactional
	public List<Customer> listAssignedCustomers(int theSalesRepId) {

		return salesRepDAO.listAssignedCustomers(theSalesRepId);
	}

	@Override
	@Transactional
	public void assignCustomer(int theCustomerId) {

		salesRepDAO.assignCustomer(theCustomerId);

	}

}
