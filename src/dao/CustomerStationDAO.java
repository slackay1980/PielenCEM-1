package dao;

import java.util.List;

import entyties.Customer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import entyties.CustomerStation;

public class CustomerStationDAO {

	public CustomerStationDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public void saveNewStation(CustomerStation customerStation) throws HibernateException, Exception {
		Session session = util.HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(customerStation);
		transaction.commit();
		session.close();
	}
	
	public List<CustomerStation> getCustomerStationAccordToString(String searchString) throws HibernateException, Exception {
		
		Session session = util.HibernateUtil.getSessionFactory().openSession();
		String querry = "FROM CustomerStation as cs WHERE cs.stationName LIKE : searchString";
		
		@SuppressWarnings("deprecation")
		List<CustomerStation> customerStationsLikeString = (List<CustomerStation>) session.createQuery(querry, CustomerStation.class).setString("searchString",searchString).list();

		return customerStationsLikeString;
	}
	
	
	@SuppressWarnings("deprecation")
	public List<CustomerStation> getCustomerStationAccordToStringForCertainCustomer(String searchString, int customerId) throws HibernateException, Exception {
		
		Session session = util.HibernateUtil.getSessionFactory().openSession();
	
		String querry = "FROM CustomerStation as cs WHERE cs.customer.id = :customerId and  cs.stationName LIKE : searchString";
	
		@SuppressWarnings({ "rawtypes" })
		Query query = session.createQuery(querry, CustomerStation.class);
		query.setInteger("customerId", customerId);
		query.setString("searchString",searchString);
		@SuppressWarnings("unchecked")
		List<CustomerStation> customerStationsLikeString = (List<CustomerStation>) query.list();
		
	return customerStationsLikeString;
	}

	public CustomerStation getStationById(int customerStationId) throws HibernateException, Exception{

		Session session = util.HibernateUtil.getSessionFactory().openSession();

		CustomerStation customerStation = (CustomerStation) session.get(CustomerStation.class, customerStationId);

		return customerStation;
	}

	public List<CustomerStation> getAllCustomerStationsForCertainCustomer(int customerId) throws HibernateException, Exception {

		Session session = util.HibernateUtil.getSessionFactory().openSession();

		String querry = "FROM CustomerStation as cs WHERE cs.customer.id = :customerId";

		@SuppressWarnings({ "rawtypes" })
		Query query = session.createQuery(querry, CustomerStation.class);
		query.setInteger("customerId", customerId);
		@SuppressWarnings("unchecked")
		List<CustomerStation> customerStationsLikeString = (List<CustomerStation>) query.list();

		return customerStationsLikeString;
	}
	

}
