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

    public void saveRelation(Relation relation) throws HibernateException, Exception {
        Session session = util.HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        session.save(relation);
        transaction.commit();
        session.close();
    }

    public void updateRelation(Relation relation) throws HibernateException, Exception {
        Session session = util.HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        session.update(relation);
        transaction.commit();
        session.close();
    }

    public Boolean getRelationIfExist(int producerStationId, int customerStationId) throws Exception {

        Session session = util.HibernateUtil.getSessionFactory().openSession();
        String SQLString = "FROM Relation as r WHERE r.customerStation = :customerStationId AND r.producerStation =  : producerStationId";

        Query query = session.createQuery(SQLString,Relation.class);
        query.setInteger("customerStationId",new Integer(customerStationId));
        query.setInteger("producerStationId",new Integer(producerStationId));


        @SuppressWarnings("deprecation")
        List<Relation> relations = (List<Relation>) query.list();
        session.close();
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
        session.close();
        return relations.get(0);
    }

    public List<Relation> getRelationLikeString(String relationString) throws Exception {

        Session session = util.HibernateUtil.getSessionFactory().openSession();
        String SQLString = "FROM Relation as r WHERE r.relationName LIKE :relationString ";

        Query query = session.createQuery(SQLString,Relation.class);
        query.setString("relationString",relationString);

        @SuppressWarnings("deprecation")
        List<Relation> relations = (List<Relation>) query.list();
        session.close();
        return relations;
    }
}
