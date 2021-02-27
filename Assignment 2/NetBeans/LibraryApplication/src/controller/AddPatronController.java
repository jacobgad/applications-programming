package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import model.Library;
import javafx.scene.control.*;
import javafx.scene.text.*;

public class AddPatronController extends Controller<Library> {
    @FXML private TextField idTxtFld;
    @FXML private TextField nameTxtFld;
    @FXML private Text patronAddedTxt;
    @FXML private Button addPatronBtn;
    @FXML private Button closeBtn;
    
    private final int getId() {
        return Integer.parseInt(idTxtFld.getText());
    }

    private final String getName() {
        return nameTxtFld.getText();
    }

    public final Library getLibrary() { 
        return model; 
    }

    @FXML
    public void initialize() {
    }

    public void handleAddPatronToList (ActionEvent event) throws Exception {
        int id = getId();
        String name = getName();

        if (getLibrary().getPatron(id) == null) {
            getLibrary().addPatron(id, name);
            patronAddedTxt.setText("Patron added to Library");
        }
        else {
            patronAddedTxt.setText("Patron ID exists in Library");
        }
    }

    public void handleClose(ActionEvent event) throws Exception{
        stage.close();
    }

}
