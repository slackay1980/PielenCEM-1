package dao;

import java.util.List;

import entyties.Relation;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


public class RelationDAO {


    public RelationDAO() {
        // TODO Auto-generated constructor stub
    }

    public Boolean getRelationIfExist(int producerStationId, int customerStationId) throws Exception {

        Session session = util.HibernateUtil.getSessionFactory().openSession();
        String SQLString = "FROM Relation as r WHERE r.customerStation = :customerStationId AND r.producerStation =  : producerStationId";

        Query query = session.createQuery(SQLString,Relation.class);
        query.setInteger("customerStationId",new Integer(customerStationId));
        query.setInteger("producerStationId",new Integer(producerStationId));


        @SuppressWarnings("deprecation")
        List<Relation> relations = (List<Relation>) query.list();
        if (relations.size()==0)
            return false;
        else
            return true;
    }

    public Relation getRelation(int producerStationId, int customerStationId) throws Exception {

        Session session = util.HibernateUtil.getSessionFactory().openSession();
        String SQLString = "FROM Relation as r WHERE r.customerStation = :customerStationId AND r.producerStation =  : producerStationId";

        Query query = session.createQuery(SQLString,Relation.class);
        query.setInteger("customerStationId",new Integer(customerStationId));
        query.setInteger("producerStationId",new Integer(producerStationId));


        @SuppressWarnings("deprecation")
        List<Relation> relations = (List<Relation>) query.list();
        return relations.get(0);
    }
}
