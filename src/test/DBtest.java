package test;

import org.hibernate.Session;
import entyties.*;
import util.*;

import static util.LogoutUtil.*;


public class DBtest {


    private Session session;

    public DBtest() {
        initialize();
        fillDB();
    }

    private void initialize() {

        try{
             session = util.HibernateUtil.getSessionFactory().openSession();

        }
        catch (Exception e) {

            e.printStackTrace();
        }
    }

    private void fillDB() {
        int i;

        for (i=0;i<=10;i++) {
            Seller seller = new Seller();
            seller.setSellerName("Name--"+i);
            seller.setSellerShortName("SEL--"+i);
            session.save(seller);
        }


        System.out.println(LogoutUtil.ANSI_GREEN_BACKGROUND + LogoutUtil.ANSI_RED + "Die Seller Tabelle ist angelegt" + ANSI_RESET);

        for (i=0;i<=10;i++) {

            Customer customer = new Customer();
            customer.setCustomerName("Customer--"+i);
            customer.setCustomerStreet("Street--"+i);
            customer.setCustomerLandPostCode("F-5678"+i);
            customer.setCustomerCity("City--"+i);
            customer.setCustomerEmploee("Jan Jack Russo--"+i);
            customer.setCustomerTelefone1("06543 0976579-"+i);
            customer.setCustomerTelefone2("06543 097657912-"+i);
            customer.setCustomerTelefone3("06543 097657914-"+i);
            customer.setCustomerEmail("email@email-"+i+".de");
            customer.setCustomerLogicId("76787567"+i);
            session.save(customer);
        }

        System.out.println(ANSI_GREEN_BACKGROUND + ANSI_RED + "Die Customer Tabelle ist angelegt" + ANSI_RESET);




        for (i=0;i<=10;i++) {

            CustomerStation customerStation = new CustomerStation();
            customerStation.setStationName("Customer--"+i);
            customerStation.setStationStreet("Street--"+i);
            customerStation.setStationLandPostCode("F-5678"+i);
            customerStation.setStationCity("City--"+i);
            customerStation.setStationEmploee("Jan Jack Russo--"+i);
            customerStation.setStationTelefone1("06543 0976579-"+i);
            customerStation.setStationTelefone2("06543 097657912-"+i);

            customerStation.setStationEmail("email@email-"+i+".de");
            session.save(customerStation);
        }

        System.out.println(ANSI_GREEN_BACKGROUND + ANSI_RED + "Die CustomerStation Tabelle ist angelegt" + ANSI_RESET);

        for (i=0;i<=10;i++) {

            Producent producent = new Producent();
            producent.setProducentName("Customer--"+i);
            producent.setProducentStreet("Street--"+i);
            producent.setProducentLandPostCode("F-5678"+i);
            producent.setProducentCity("City--"+i);
            producent.setProducentEmploee("Jan Jack Russo--"+i);
            producent.setProducentTelefone1("06543 0976579-"+i);
            producent.setProducentTelefone2("06543 097657912-"+i);
            producent.setProducentEmail("email@email-"+i+".de");
            session.save(producent);
        }

        System.out.println(ANSI_GREEN_BACKGROUND + ANSI_RED + "Die Producent Tabelle ist angelegt" + ANSI_RESET);

        for (i=0;i<=10;i++) {

            ProducentStation producentStation = new ProducentStation();
            producentStation.setStationName("Customer--"+i);
            producentStation.setStationStreet("Street--"+i);
            producentStation.setStationLandPostCode("F-5678"+i);
            producentStation.setStationCity("City--"+i);
            producentStation.setStationEmploee("Jan Jack Russo--"+i);
            producentStation.setStationTelefone1("06543 0976579-"+i);
            producentStation.setStationTelefone2("06543 097657912-"+i);
            producentStation.setStationEmail("email@email-"+i+".de");
            session.save(producentStation);
        }

        System.out.println(ANSI_GREEN_BACKGROUND + ANSI_RED + "Die ProducentStstion Tabelle ist angelegt" + ANSI_RESET);

        for (i=0;i<=10;i++) {

            User user = new User();
            user.setName("User-"+i);
            user.setSurname("UserSurname-"+i);
            user.setShortName("U"+i);
            user.setLogin("us"+i);
            user.setPassword("usr"+i);
            session.save(user);
        }

        System.out.println(ANSI_GREEN_BACKGROUND + ANSI_RED + "Die User Tabelle ist angelegt" + ANSI_RESET);
    }

}
