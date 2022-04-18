import controller.LoginController;
import controller.MainWindowController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;
import test.MainTest;
import util.HibernateUtil;

public class Main extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception{

        Session session = util.HibernateUtil.getSessionFactory().openSession();
        MainTest mainTest = new MainTest();


        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/MainWindow.fxml"));

        Parent root = loader.load();
        primaryStage.setTitle("PielenCEM");
        primaryStage.setScene(new Scene(root, 1200, 775));

        MainWindowController controller = (MainWindowController)loader.getController();
        controller.setStage(primaryStage);

        LoginController loginController = new LoginController(primaryStage);
        loginController.initialize();
        loginController.showAndWait();

        primaryStage.show();



    }



    public static void main(String[] args) {
            launch(args);

    }
}
