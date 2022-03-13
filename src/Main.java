import controller.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import controller.LoginController;

public class Main extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception{

        //MainTest mainTest = new MainTest();
        //HibernateUtil.getSessionFactory();

        Parent root = FXMLLoader.load(getClass().getResource("view/MainWindow.fxml"));
        primaryStage.setTitle("PielenCEM");
        primaryStage.setScene(new Scene(root, 1200, 775));

        LoginController loginController = new LoginController(primaryStage);
        loginController.initialize();
        loginController.showAndWait();

        primaryStage.show();

       // Session session = util.HibernateUtil.getSessionFactory().openSession();

    }



    public static void main(String[] args) {
            launch(args);

    }
}
