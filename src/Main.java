import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.hibernate.Session;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("view/MainWindow.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 1200, 775));

        LoginDialog login = new LoginDialog(primaryStage);
        login.initialize();
        login.showAndWait();
        primaryStage.show();

        Session session = util.HibernateUtil.getSessionFactory().openSession();

    }


    public static void main(String[] args) {
        launch(args);

    }
}
