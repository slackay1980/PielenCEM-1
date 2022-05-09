package dao;

import java.util.List;

import entyties.Producer;
import entyties.ProducerStation;
import entyties.Region;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class ProducerStationsDAO {

	public ProducerStationsDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public void saveNewStation(ProducerStation producerStation) throws HibernateException, Exception {
		Session session = util.HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(producerStation);
		transaction.commit();
		session.close();
	}

	public void updateStation(ProducerStation producerStation) throws HibernateException, Exception {
		Session session = util.HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.update(producerStation);
		transaction.commit();
		session.close();
	}
	
	
	@SuppressWarnings("deprecation")
	
		public List<ProducerStation> getProducentStationAccordToString(String searchString) throws HibernateException, Exception {
		

		Session session = util.HibernateUtil.getSessionFactory().openSession();
		String querry = "FROM ProducerStation as cs WHERE cs.stationName LIKE : searchString";
		
		List<ProducerStation> producenttationsLikeString = (List<ProducerStation>) session.createQuery(querry, ProducerStation.class).setString("searchString",searchString).list();
		
		return producenttationsLikeString;
	}

	public List<ProducerStation> getAllProducerStationsForCertainProducer(int producerID) throws HibernateException, Exception {

		Session session = util.HibernateUtil.getSessionFactory().openSession();

		String querry = "FROM ProducerStation as ps WHERE ps.producer.id = :producerID";

		@SuppressWarnings({ "rawtypes" })
		Query query = session.createQuery(querry, ProducerStation.class);
		query.setInteger("producerID", producerID);
		@SuppressWarnings("unchecked")
		List<ProducerStation> producerStationsLikeString = (List<ProducerStation>) query.list();
		session.close();
		return producerStationsLikeString;
	}

	public List<Region> getAllRegions() throws HibernateException, Exception{

		Session session = util.HibernateUtil.getSessionFactory().openSession();

		String querry = "FROM Region";
		Query query = session.createQuery(querry, Region.class);
		List<Region> regions = (List<Region>) query.list();

		return regions;
	}
	

}
