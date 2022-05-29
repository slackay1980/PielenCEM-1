package view;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

public class AlertYesNo {

    private ButtonType okButton;
    private ButtonType noButton;
    private ButtonType cancelButton;
    private Alert alert;
    private Boolean returnVal;

    public AlertYesNo(String title,String message) {
        alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        okButton = new ButtonType("Yes", ButtonBar.ButtonData.YES);
        noButton = new ButtonType("Yes", ButtonBar.ButtonData.NO);
        cancelButton = new ButtonType("Yes", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(okButton, noButton, cancelButton);
    }

    public Boolean show() {



        alert.showAndWait().ifPresent(type -> {
            if (type == ButtonType.OK) {
                returnVal = true;
            } else if (type == ButtonType.NO) {
                returnVal = false;
              } else {
                returnVal = false;
            }
        });

        return returnVal;
    }
}
