package com.petarjk.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.petarjk.spring.entity.Customer;
import com.petarjk.spring.entity.SalesRepresentative;

@Repository
public class SalesRepDAOImpl implements SalesRepDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private int tempSalesRepId;

	@Override
	public List<SalesRepresentative> getSalesRepresentatives() {

		Session currentSession = sessionFactory.getCurrentSession();

		Query<SalesRepresentative> theQuery = currentSession.createQuery("FROM SalesRepresentative ORDER BY last_name",
				SalesRepresentative.class);

		List<SalesRepresentative> salesRepresentatives = theQuery.getResultList();

		return salesRepresentatives;
	}

	@Override
	public void saveSalesRep(SalesRepresentative theSalesRepresentative) {

		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.saveOrUpdate(theSalesRepresentative);
	}

	@Override
	public SalesRepresentative getSalesRepresentative(int theId) {

		Session currentSession = sessionFactory.getCurrentSession();

		SalesRepresentative theSalesRepresentative = currentSession.get(SalesRepresentative.class, theId);

		return theSalesRepresentative;
	}

	@Override
	public void delete(int theId) {

		Session currentSession = sessionFactory.getCurrentSession();

		Query theQuery = currentSession.createQuery("DELETE FROM SalesRepresentative WHERE id=:salesRepId");

		theQuery.setParameter("salesRepId", theId);

		theQuery.executeUpdate();

	}

	@Override
	public List<SalesRepresentative> searchSalesRep(String theSearchName) {

		Session currentSession = sessionFactory.getCurrentSession();

		Query theQuery = null;

		if ((theSearchName != null) && (theSearchName.trim().length() > 0)) {

			theQuery = currentSession.createQuery(
					"FROM SalesRepresentative WHERE lower(firstName) LIKE :theName OR lower(lastName) LIKE :theName ORDER BY last_name",
					SalesRepresentative.class);

			theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");

		} else {

			theQuery = currentSession.createQuery("FROM SalesRepresentative ORDER BY last_name",
					SalesRepresentative.class);

		}

		List<SalesRepresentative> theSalesRepresentatives = theQuery.getResultList();

		return theSalesRepresentatives;
	}

	@Override
	public List<Customer> listAssignedCustomers(int theSalesRepId) {

		setTempSalesRepId(theSalesRepId);

		Session currentSession = sessionFactory.getCurrentSession();

		SalesRepresentative theSalesRepresentative = currentSession.get(SalesRepresentative.class, theSalesRepId);

		List<Customer> theCustomers = theSalesRepresentative.getCustomers();

		System.out.println(theCustomers);

		return theCustomers;
	}

	@Override
	public void assignCustomer(int theCustomerId) {

		int id = getTempSalesRepId();

		Session currentSession = sessionFactory.getCurrentSession();

		Customer tempCustomer = currentSession.get(Customer.class, theCustomerId);

		SalesRepresentative tempSalesRepresentative = currentSession.get(SalesRepresentative.class, id);

		tempSalesRepresentative.addCustomer(tempCustomer);

		currentSession.saveOrUpdate(tempSalesRepresentative);

	}

	public int getTempSalesRepId() {
		return tempSalesRepId;
	}

	public void setTempSalesRepId(int tempSalesRepId) {
		this.tempSalesRepId = tempSalesRepId;
	}

}
