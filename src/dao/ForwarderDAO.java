package dao;

import entyties.Forwarder;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ForwarderDAO {

    public ForwarderDAO() {
        // TODO Auto-generated constructor stub
    }

    public void saveNewForwarder(Forwarder forwarder) throws HibernateException, Exception {
        Session session = util.HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        session.save(forwarder);
        transaction.commit();
        session.close();
    }
}
