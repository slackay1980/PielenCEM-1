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
        okButton = new ButtonType("Ja", ButtonBar.ButtonData.YES);
        noButton = new ButtonType("Nein", ButtonBar.ButtonData.NO);
        alert.getButtonTypes().setAll(noButton,okButton);
    }

    public Boolean show() {
        alert.showAndWait().ifPresent(type -> {
            if (type == okButton) {
                returnVal = true;
            } else if (type == noButton) {
                returnVal = false;
              } else {
                returnVal = false;
            }
        });

        return returnVal;
    }
}
