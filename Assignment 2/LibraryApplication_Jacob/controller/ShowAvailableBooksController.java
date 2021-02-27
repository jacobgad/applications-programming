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

public class ShowAvailableBooksController extends Controller<Library> {
    @FXML private TableView<Book> booksTv;

    public final Library getLibrary() { return model; }
    
    @FXML public void initialize() {}

    public void handleClose(ActionEvent event) throws Exception{
        stage.close();
    }
}
