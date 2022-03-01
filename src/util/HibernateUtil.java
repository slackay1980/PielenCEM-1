package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil   {
	
	private static final SessionFactory sessionFactory = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory() {
		
		try {
        	System.out.println("Mache neue SessionFactory...");
            Configuration config = new Configuration().addAnnotatedClass(Entyties.Customer.class);
           /* config.addAnnotatedClass(Entyties.CustomerStation.class);
            config.addAnnotatedClass(Entyties.OrderCiment.class);
            config.addAnnotatedClass(Entyties.Producent.class);
            config.addAnnotatedClass(Entyties.ProducentStation.class);
            config.addAnnotatedClass(Entyties.Product.class);
            config.addAnnotatedClass(Entyties.User.class);

           */
            return config.configure().buildSessionFactory();
        } catch (Throwable e) 
			
        
        {
            throw new ExceptionInInitializerError(e);
    	}
		finally { 
			
		}
	}
	
	public static SessionFactory getSessionFactory() throws Exception {
		System.out.println("Geting session backd");
		return sessionFactory;
	}
	
	public static void sutDown() throws Exception {
		getSessionFactory().close();
	}
	
	public static boolean isFactoryBuild() {
		if (sessionFactory == null) return false;
		else return true;
	}

}
