import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.control.Button;


public class LoginDialog extends Stage {

    private Stage primaryStage;
    private Parent root;
    FXMLLoader loader;
    private Boolean login = false;
    private Stage  stage = this;



    public LoginDialog(Stage primaryStage) {
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

        Button btnLogin = (Button) loader.getNamespace().get("btnLogin");
        btnLogin.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("MouseClicked");
                stage.close();
            }

        });

        Button btnCancel = (Button) loader.getNamespace().get("btnCancel");
        btnCancel.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("MouseClicked");
                System.exit(0);
            }

        });

        TextField txtPassword = (TextField) loader.getNamespace().get("txtPassword");
        txtPassword.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {
                if (ke.getCode().equals(KeyCode.ENTER)) {
                    System.out.println("Enter pressed");
                    stage.close();
                }
            }
        });

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





}
