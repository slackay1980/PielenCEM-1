package view;

import entyties.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.ArrayList;
import java.util.List;

public class PoolDownDialog extends Stage {

    private int selectedItem;

    public class PoolDownList extends ListView{

        private ListView listView = this;
        private ObservableList<String> items= FXCollections.observableArrayList();
        private Stage myStage;


        public PoolDownList(Stage myStage, TextField txtField, List<Customer> listCustomer) {
            super();
            this.myStage = myStage;
            setLayoutX(txtField.getLayoutX());
            setLayoutY(txtField.getLayoutY()+30);
            setPrefWidth(txtField.getPrefWidth());
            setPrefHeight(120);
            fillObservableList(listCustomer);
            initListView();
            addListener();
            this.requestFocus();


        }

        private void initListView() {
            this.setItems(items);
        }

        // filling observable List from customer List in order to show it in ListWiew
        private void fillObservableList(List<Customer> listCustomer ) {
            for(int i=0;(i<=listCustomer.size()-1);i++) {

                        items.add(listCustomer.get(i).getCustomerName() + " ," + listCustomer.get(i).getCustomerCity());

            }
        }

        private void closeList() {

            this.setVisible(false);
        }

        private void addListener() {
            this.addEventFilter( KeyEvent.KEY_PRESSED, keyEvent -> {
                if( keyEvent.getCode() == KeyCode.ESCAPE)
                {
                    // closeList();
                    myStage.close();
                }


                if( keyEvent.getCode() == KeyCode.ENTER)
                {
                    selectedItem = listView.getSelectionModel().getSelectedIndex();
                    myStage.close();

                }
            });

        }

        public int showAndGetItem() {
            // setVisible(true);
            return selectedItem;

        }



    }

    public PoolDownDialog(Stage parentStage, TextField textField, List<Customer> listCustomer) {

        // decorate PullDown List
        initStyle(StageStyle.UNDECORATED);
        initOwner(parentStage);

        // set position of pulldownDialog relative to TextField
        setX(parentStage.getX()+textField.getLayoutX());
        setY(parentStage.getY()+textField.getLayoutY()+55);

        // initialise and show PollDownList
        VBox root = new VBox();
        PoolDownList poolDownList = new PoolDownList(this,textField,listCustomer);
        root.getChildren().add(poolDownList);
        Scene scene = new Scene(root, textField.getPrefWidth(), 120);
        poolDownList.setVisible(true);
        setScene(scene);


    }

    // showing PoolDownDialog and waiting on select of customer
    public int showDialog() {
        showAndWait();
        return selectedItem;
    }


}
