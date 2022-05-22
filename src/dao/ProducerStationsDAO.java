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
		String querry = "FROM ProducerStation as ps WHERE ps.stationName LIKE : searchString OR ps.stationCity LIKE : searchString";
		
		List<ProducerStation> producentStationsLikeString = (List<ProducerStation>) session.createQuery(querry, ProducerStation.class).setString("searchString",searchString).list();
		
		return producentStationsLikeString;
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

	public ProducerStation getStationById(int producerStationId) throws HibernateException, Exception{

		Session session = util.HibernateUtil.getSessionFactory().openSession();

		ProducerStation producerStation = (ProducerStation) session.get(ProducerStation.class, producerStationId);
		session.close();
		return producerStation;
	}

	public List<Region> getAllRegions() throws HibernateException, Exception{

		Session session = util.HibernateUtil.getSessionFactory().openSession();

		String querry = "FROM Region";
		Query query = session.createQuery(querry, Region.class);
		List<Region> regions = (List<Region>) query.list();

		return regions;
	}
	

}
