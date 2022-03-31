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

import java.util.List;

public class PoolDownDialog extends Stage {

    private int selectedItem;

    public class PoolDownList extends ListView {

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

        private void fillObservableList(List<Customer> list ) {
            for(int i=0;(i<=list.size()-1);i++) {
                items.add(list.get(i).getCustomerName()+" ,"+list.get(i).getCustomerCity());
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

    public PoolDownDialog(Stage parentStage, TextField textField, List<Customer> listCustomers) {
        initStyle(StageStyle.UNDECORATED);
        initOwner(parentStage);
        //initModality(Modality.APPLICATION_MODAL);
        setX(parentStage.getX()+textField.getLayoutX());
        setY(parentStage.getY()+textField.getLayoutY()+55);
        VBox root = new VBox();
        PoolDownList poolDownList = new PoolDownList(this,textField,listCustomers);
        root.getChildren().add(poolDownList);
        Scene scene = new Scene(root, textField.getPrefWidth(), 120);
        poolDownList.setVisible(true);
        setScene(scene);


    }

    public int showDialog() {
        showAndWait();
        return selectedItem;
    }


}
