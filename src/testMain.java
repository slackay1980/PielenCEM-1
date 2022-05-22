import entyties.CustomerStation;
import entyties.ProducerStation;
import entyties.Relation;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class testMain {

    public static void main(String[] args) throws Exception {

        Session session = util.HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();

        CustomerStation customerStation = (CustomerStation) session.get(CustomerStation.class, 1);
        ProducerStation producerStation = (ProducerStation) session.get(ProducerStation.class, 1);


        String SQLString = "FROM Relation as r WHERE r.customerStation = :customerStationId AND r.producerStation =  : producerStationId";

        Query query = session.createQuery(SQLString,Relation.class);
        query.setInteger("customerStationId",new Integer(1));
        query.setInteger("producerStationId",new Integer(1));


        @SuppressWarnings("deprecation")
        List<Relation> relations = (List<Relation>) query.list();
        Relation relation = relations.get(0);

        relation.setDistance(6780);


        session.update(relation);
        transaction.commit();
        session.close();
    }
}
