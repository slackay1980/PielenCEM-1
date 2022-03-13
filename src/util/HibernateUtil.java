package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import static util.LogoutUtil.*;


public class HibernateUtil   {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try{

		System.out.println(ANSI_GREEN_BACKGROUND + ANSI_RED +
				"Die Customer Tabelle ist angelegt" + ANSI_RESET);
		Configuration config = new Configuration().addAnnotatedClass(entyties.Seller.class);
		config.addAnnotatedClass(entyties.Customer.class);
		config.addAnnotatedClass(entyties.Region.class);
		config.addAnnotatedClass(entyties.CustomerStation.class);
		config.addAnnotatedClass(entyties.Region.class);

		config.addAnnotatedClass(entyties.Producent.class);
		config.addAnnotatedClass(entyties.ProducentStation.class);
		config.addAnnotatedClass(entyties.Product.class);
		config.addAnnotatedClass(entyties.Relation.class);
		config.addAnnotatedClass(entyties.Forwarder.class);

		config.addAnnotatedClass(entyties.TransportOrder.class);
		config.addAnnotatedClass(entyties.Freight.class);
		config.addAnnotatedClass(entyties.User.class);
		config.addAnnotatedClass(entyties.OrderCiment.class);

		return config.configure().buildSessionFactory();
		} catch (Throwable e)


		{
			throw new ExceptionInInitializerError(e);
		}
		finally {

		}
	}

	public static SessionFactory getSessionFactory() throws Exception {
		System.out.println(ANSI_GREEN_BACKGROUND + ANSI_RED +
				"Session ist schon generiert. Gebe den Pointer zurück" + ANSI_RESET);
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




