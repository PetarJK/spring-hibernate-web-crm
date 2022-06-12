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

		Query<Customer> theQuery = currentSession.createQuery("FROM Customer ORDER BY last_name", Customer.class);

		List<Customer> customers = theQuery.getResultList();

		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {

		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.saveOrUpdate(theCustomer);

	}

	@Override
	public Customer getCustomer(int theId) {

		Session currentSession = sessionFactory.getCurrentSession();

		Customer theCustomer = currentSession.get(Customer.class, theId);

		return theCustomer;
	}

	@Override
	public void delete(int theId) {

		Session currentSession = sessionFactory.getCurrentSession();

		Query theQuery = currentSession.createQuery("DELETE FROM Customer WHERE id=:customerId");

		theQuery.setParameter("customerId", theId);

		theQuery.executeUpdate();
	}

	@Override
	public List<Customer> searchCustomers(String theSearchName) {

		Session currentSession = sessionFactory.getCurrentSession();

		Query theQuery = null;

		if ((theSearchName != null) && (theSearchName.trim().length() > 0)) {

			theQuery = currentSession.createQuery(
					"FROM Customer WHERE lower(firstName) LIKE :theName OR lower(lastName) LIKE :theName ORDER BY last_name",
					Customer.class);

			theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");

		} else {

			theQuery = currentSession.createQuery("FROM Customer ORDER BY last_name", Customer.class);

		}

		List<Customer> theCustomers = theQuery.getResultList();

		return theCustomers;
	}
}
