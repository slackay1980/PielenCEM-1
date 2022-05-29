package dao;

import entyties.Freight;
import entyties.Relation;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;


public class FreightDAO {


    public FreightDAO() {
        // TODO Auto-generated constructor stub
    }

    public void saveFreight(Freight freight) throws HibernateException, Exception {
        Session session = util.HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        session.save(freight);
        transaction.commit();
        session.close();
    }

    public Boolean getFreightIfExist(int relationId, int forwarderId) throws HibernateException,Exception {

        Session session = util.HibernateUtil.getSessionFactory().openSession();
        String SQLString = "FROM Freight as f WHERE f.relation = :relationId AND f.forwarder =  : forwarderId";

        Query query = session.createQuery(SQLString,Freight.class);
        query.setInteger("relationId",new Integer(relationId));
        query.setInteger("forwarderId",new Integer(forwarderId));


        @SuppressWarnings("deprecation")
        List<Freight> freights = (List<Freight>) query.list();
        session.close();
        if (freights.size()==0)
            return false;
        else
            return true;
    }

    public void updateFreight(Freight freight) throws HibernateException, Exception {
        Session session = util.HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        session.update(freight);
        transaction.commit();
        session.close();
    }

    public Freight getFreight(int relationId, int forwarderId) throws Exception {

        Session session = util.HibernateUtil.getSessionFactory().openSession();
        String SQLString = "FROM Freight as f WHERE f.relation = :relationId AND f.forwarder =  : forwarderId";

        Query query = session.createQuery(SQLString,Freight.class);
        query.setInteger("relationId",new Integer(relationId));
        query.setInteger("forwarderId",new Integer(forwarderId));


        @SuppressWarnings("deprecation")
        List<Freight> freights = (List<Freight>) query.list();
        session.close();
        return freights.get(0);
    }


/*








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

*/

}
