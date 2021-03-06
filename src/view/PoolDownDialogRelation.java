package view;

import com.sun.org.apache.xpath.internal.operations.Bool;
import entyties.Producer;
import entyties.Relation;
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

import javax.xml.soap.Text;
import java.util.List;

public class PoolDownDialogRelation extends Stage {

    private int selectedItem;
    private TextField textField;

    public class PoolDownList extends ListView{

        private ListView listView = this;
        private ObservableList<String> items= FXCollections.observableArrayList();
        private Stage myStage;
        private TextField textField;


        public PoolDownList(Stage myStage, TextField txtField, List<Relation> relations) {
            super();
            this.myStage = myStage;
            this.textField = textField;
            setLayoutX(txtField.getLayoutX());
            setLayoutY(txtField.getLayoutY()+30);
            setPrefWidth(txtField.getPrefWidth());
            setPrefHeight(120);
            fillObservableList(relations);
            initListView();
            addListener();
            this.requestFocus();


        }

        private void initListView() {
            this.setItems(items);
        }

        // filling observable List from customer List in order to show it in ListWiew
        private void fillObservableList(List<Relation> relations ) {
            for(int i=0;(i<=relations.size()-1);i++) {

                        items.add(relations.get(i).getRelationName());

            }
        }

        private void closeList() {

            this.setVisible(false);
        }

        private void addListener() {
            this.addEventFilter( KeyEvent.KEY_PRESSED, (keyEvent) -> {
                if( keyEvent.getCode() == KeyCode.ESCAPE)
                {
                    // closeList();
                    selectedItem = -1;
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

    public PoolDownDialogRelation(Stage parentStage, TextField textField, List<Relation> relations) {

        this.textField=textField;
        // decorate PullDown List
        initStyle(StageStyle.UNDECORATED);
        initOwner(parentStage);

        // set position of pulldownDialog relative to TextField
        setX(parentStage.getX()+textField.getLayoutX());
        setY(parentStage.getY()+textField.getLayoutY()+55);

        // initialise and show PollDownList
        VBox root = new VBox();
        PoolDownList poolDownList = new PoolDownList(this,this.textField,relations);
        root.getChildren().add(poolDownList);
        Scene scene = new Scene(root, textField.getPrefWidth(), 120);
        poolDownList.setVisible(true);
        setScene(scene);


    }

    public void setTextField(Boolean state){
        this.textField.setEditable(state);
    }

    // showing PoolDownDialogCustomer and give back a selcted Item Number,
    public int showDialog() {
        showAndWait();
        return selectedItem;
    }


}
