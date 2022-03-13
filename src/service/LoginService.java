package service;

import dao.UserDAO;
import entyties.User;
import org.hibernate.HibernateException;

import javax.swing.*;
import java.util.List;

public class LoginService {

    public LoginService() {

    }

    public List<User> getAllUsers() {

       List<User> users = null;



        try {
            UserDAO userDAO = new UserDAO();
            users = userDAO.getAllUsers();
            // aktivUser.setText(Entyties.AktivUser.userName + " " + Entyties.AktivUser.userSurName);

        } catch (ExceptionInInitializerError e) {
            System.out.println("Fehler der Inicialisation");
        } catch (
                HibernateException e) {
            System.out.println("Fehler bei verbindinz zu DB");
        } catch (Exception e) {
            System.out.println("Algemeiner fehler");
        }
        finally {
            return users;
        }



    }

    public User getUserIfLoginOk(String login, String password, List<User> users ) {
        User user = null;
        int i = 0;
        while (i < users.size())
        {
            System.out.println(users.get(i).getLogin());
            System.out.println(users.get(i).getPassword());
            if ((login.equals(users.get(i).getLogin())) && (password.equals(users.get(i).getPassword())))
            {
                user = new User();
                user.setId(users.get(i).getId());
                user.setName(users.get(i).getName());
                user.setSurname(users.get(i).getSurname());
                user.setLogin(users.get(i).getLogin());
                user.setPassword(users.get(i).getPassword());
                user.setShortName(users.get(i).getShortName());
                i=users.size();
            }
            i++;

        }
        return user;
    }

    public void setAktivUser(User user) {


    entyties.AktivUser.userId = user.getId();
    entyties.AktivUser.userLogin = user.getLogin();
    entyties.AktivUser.userName = user.getName();
    entyties.AktivUser.userPassword = user.getPassword();
    entyties.AktivUser.userShortName = user.getShortName();
    entyties.AktivUser.userSurName = user.getSurname();

    }


}
