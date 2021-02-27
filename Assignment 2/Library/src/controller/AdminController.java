package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import model.Library;


public class AdminController extends Controller<Library> {
    
    @FXML public void initialize() {}

    @FXML public void handleAddPatron(ActionEvent event) throws Exception{
        ViewLoader.showStage(model,"/view/addPatron.fxml", "Add Patron", new Stage());
    }

    @FXML public void handleRemovePatron(ActionEvent event) throws Exception{
        ViewLoader.showStage(model,"/view/removePatron.fxml", "Remove Patron", new Stage());
    }

    @FXML public void handleAddBook(ActionEvent event) throws Exception{
        ViewLoader.showStage(model,"/view/addBook.fxml", "Add Book", new Stage());
    }

    @FXML public void handleRemoveBook(ActionEvent event) throws Exception{
        ViewLoader.showStage(model,"/view/removeBook.fxml", "Remove Book", new Stage());
    }

    public void handleExit(ActionEvent event) throws Exception{
        stage.close();
    }
}
