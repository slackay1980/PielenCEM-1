package dao;

import java.util.List;
import entyties.Customer;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;






public class CustomerDAO {

	public CustomerDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public void saveCustomer(Customer customer) throws HibernateException, Exception {
		Session session = util.HibernateUtil.getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		session.save(customer);
		transaction.commit();
		session.close();
	}
	
	public List<Customer> getCustomerAccordToString(String searchString) throws HibernateException, Exception {
		
		Session session = util.HibernateUtil.getSessionFactory().openSession();
		String querry = "FROM Customer as c WHERE c.customerName LIKE : searchString";
		
		@SuppressWarnings("deprecation")
		List<Customer> customersLikeString = (List<Customer>) session.createQuery(querry, Customer.class).setString("searchString",searchString).list();

		return customersLikeString;
	}

	public List<Customer> getAllCustomers() throws HibernateException, Exception {

		Session session = util.HibernateUtil.getSessionFactory().openSession();
		String querry = "FROM Customer";

		@SuppressWarnings("deprecation")
		List<Customer> customers = (List<Customer>) session.createQuery(querry, Customer.class).list();

		return customers;
	}



}
