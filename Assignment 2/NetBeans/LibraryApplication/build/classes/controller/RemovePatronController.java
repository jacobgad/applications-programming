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

public class RemovePatronController extends Controller<Library> {
    @FXML private Button removePatronBtn;
    @FXML private ListView<Patron> patronLv;

    private Patron getSelectedPatron(){
        return patronLv.getSelectionModel().getSelectedItem();
    }
    public final Library getLibrary() { return model; }
    
    @FXML public void initialize() {}

    @FXML public void handleremovePatronFromList(ActionEvent event) throws Exception{
        Patron patron = getSelectedPatron();
        getLibrary().removePatron(patron);
    }

    public void handleClose(ActionEvent event) throws Exception{
        stage.close();
    }
    
}
