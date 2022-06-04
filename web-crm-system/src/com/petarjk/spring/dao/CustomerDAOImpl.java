package com.petarjk.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.petarjk.spring.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {

		Session currentSession = sessionFactory.getCurrentSession();

		Query<Customer> theQuery = currentSession.createQuery("from Customer", Customer.class);

		List<Customer> customers = theQuery.getResultList();

		return customers;
	}

}
