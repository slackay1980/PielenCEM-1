package controller;

import entyties.AktivUser;
import entyties.User;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import service.LoginService;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static util.LogoutUtil.*;


public class LoginController extends Stage {

    private Stage primaryStage;
    private Parent root;
    private FXMLLoader loader;
    private Boolean login = false;
    private Stage  stage = this;
    private Button btnLogin;
    private Button btnCancel;
    private TextField txtLogin;
    private TextField txtPassword;
    private Label lblGreeting;
    private List<User> users;
    private LoginService loginService = new LoginService();

    public LoginController(Stage primaryStage) {
        super();
        this.primaryStage = primaryStage;

    }

    public void setHandler() {

        this.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.out.println("WIndowClosed");
                System.exit(0);
            }
        });

        setHandlerOnBtnLogin();

        setHandlerOnBtnCancel();

        setHandlerOnTxtLogin();

        setHandlerOnTxtPassword();

        lblGreeting = (Label) loader.getNamespace().get("lblGreeting");

    }

    public void initialize() {
        this.initOwner(primaryStage);
        this.initModality(Modality.APPLICATION_MODAL);

        try {
            loader = new FXMLLoader(getClass().getResource("/view/LoginView.fxml"));
            root = loader.load();
            //root = FXMLLoader.load(getClass().getResource("view/LoginView.fxml"));
        }
        catch (Exception e) {
            System.out.println("Klappt nicht");
        }


        setHandler();

        this.setScene(new Scene(root, 529, 400));

    }

    private Boolean loginUser() {

        users = loginService.getAllUsers();

        User user = loginService.getUserIfLoginOk(txtLogin.getText(),txtPassword.getText(),users);
        if (user==null) {
            return false;
        }
        else {
            loginService.setAktivUser(user);
            return true;
        }}

    private void setHandlerOnBtnLogin(){
        btnLogin = (Button) loader.getNamespace().get("btnLogin");
        btnLogin.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if ((txtPassword.getText().equals("")) ||
                        (txtLogin.getText().equals(""))) {
                    new view.AlertMessage("Info", "Eingabe ist nicht valid",
                            "Beide Eingabefelder müssen ausgefüllt sein");
                }
                else
                {
                    if (loginUser()) {
                        System.out.println(
                                ANSI_GREEN_BACKGROUND + ANSI_RED +
                                        "Login und Passwort gefunden in User Tabelle"
                                        + ANSI_RESET);

/////////// Label hallo wird nicht angezeigt(Stage .Update dauert zu lange ///////////////////
                        lblGreeting.setText("Hallo"+ AktivUser.userName);
                        stage.close();
                    }
                    lblGreeting.setStyle("-fx-text-fill: red");
                    lblGreeting.setText("Falsche Eingaben");


                }
            }

        });
    }

    private void setHandlerOnBtnCancel() {
        btnCancel = (Button) loader.getNamespace().get("btnCancel");
        btnCancel.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println(
                        ANSI_GREEN_BACKGROUND + ANSI_RED +
                                "Login ist abgebrochen"
                                + ANSI_RESET);
                System.exit(0);
            }

        });

    }

    private void setHandlerOnTxtLogin() {
        txtLogin = (TextField) loader.getNamespace().get("txtLogin");
        txtLogin.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {
                if (ke.getCode().equals(KeyCode.ENTER)) {

                    if (txtLogin.getText().equals("")) {
                        new view.AlertMessage("Info","Eingabe ist nicht valid",
                                "Eingabefeld Login kann nicht leer sein");
                        txtLogin.requestFocus();
                    }
                    else {

                        txtPassword.requestFocus();
                    }
                }
            }
        });
    }

    private void setHandlerOnTxtPassword() {
        txtPassword = (TextField) loader.getNamespace().get("txtPassword");
        txtPassword.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {
                if (ke.getCode().equals(KeyCode.ENTER)) {
                    if ((txtPassword.getText().equals(""))||
                            (txtLogin.getText().equals(""))) {
                        new view.AlertMessage("Info","Eingabe ist nicht valid",
                                "Beide Eingabefelder müssen ausgefüllt sein");
                        txtPassword.requestFocus();
                    }
                    else {
                        if (loginUser()) {
                            System.out.println(
                                    ANSI_GREEN_BACKGROUND + ANSI_RED +
                                            "Login und Passwort gefunden in User Tabelle"
                                            + ANSI_RESET);
                            lblGreeting.setStyle("-fx-text-fill: red");
                            lblGreeting.setText("Hallo , "+ AktivUser.userName);
                            stage.close();
                        }
                        lblGreeting.setStyle("-fx-text-fill: red");
                        lblGreeting.setText("Falsche Eingaben");


                    }

                }
            }
        });
    }

}
