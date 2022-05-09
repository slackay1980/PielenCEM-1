package dao;

import java.util.List;

import entyties.Producer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProducerDAO {

	public ProducerDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public void saveProducent(Producer producer) throws HibernateException, Exception {
		Session session = util.HibernateUtil.getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		session.save(producer);
		transaction.commit();
		session.close();
	}
	
	public List<Producer> getProducentAccordToString(String searchString) throws HibernateException, Exception {
		
		Session session = util.HibernateUtil.getSessionFactory().openSession();
		String querry = "FROM Producer as p WHERE p.producerName LIKE : searchString";
		
		@SuppressWarnings("deprecation")
		List<Producer> producentsLikeString = (List<Producer>) session.createQuery(querry, Producer.class).setString("searchString",searchString).list();
		System.out.println(producentsLikeString);
		return producentsLikeString;
	}  

}
