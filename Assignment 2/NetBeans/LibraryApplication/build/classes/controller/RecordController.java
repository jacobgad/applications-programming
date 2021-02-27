package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import model.Library;
import javafx.scene.control.*;
import javafx.scene.text.*;
import model.*;

public class RecordController extends Controller<Library> {
    @FXML private Button showRecordBtn;
    @FXML private TextField patronIDTxtFld;
    @FXML private Text patronSelectTxt;
    @FXML private ListView<Book> currentlyBorrowedLv;
    @FXML private ListView<Book> borrowingHistoryLv;

    private final int getID() {
        return Integer.parseInt(patronIDTxtFld.getText());
    }

    public final Library getLibrary() { return model; }
    
    @FXML public void initialize() {
        showRecordBtn.setDisable(true);
    }

    @FXML public void handleShowRecord(ActionEvent event) throws Exception {
        if (patronIDTxtFld.getText().isEmpty()) {
            patronSelectTxt.setText("No Patron Selected");
            return;
        }

        int id = getID();
        if (getLibrary().getPatron(id) == null) {
            patronSelectTxt.setText("Patron does not exist");
        }
        else {
            patronSelectTxt.setText(getLibrary().getPatron(id).toString());
            currentlyBorrowedLv.setItems(getLibrary().getPatron(id).currentlyBorrowed());
            currentlyBorrowedLv.setItems(getLibrary().getPatron(id).borrowingHistory());
        }
    }

    @FXML public void keyReleasedProperty() {
        boolean isDisabled = (patronIDTxtFld.getText().isEmpty());
        showRecordBtn.setDisable(isDisabled);
    }

    public void handleClose(ActionEvent event) throws Exception{
        stage.close();
    }
}