package dao;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import entyties.User;

public class UserDAO {

	public UserDAO() {
		
		
		// TODO Auto-generated constructor stub
	}
	
	public List<User> getAllUsers() throws HibernateException, Exception {
		
		Session session = util.HibernateUtil.getSessionFactory().openSession();
		List<User> users = session.createQuery("from User", User.class).getResultList();

				
		return users;
	}

}
