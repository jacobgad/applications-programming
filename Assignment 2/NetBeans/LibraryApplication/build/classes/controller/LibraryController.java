package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import model.Library;

public class LibraryController extends Controller<Library> {

    @FXML
    public void initialize() {}

    @FXML public void handleExploreCat(ActionEvent event)throws Exception{
        ViewLoader.showStage(model,"/view/catalogue.fxml", "Catalogue", new Stage());
    }

    @FXML public void handleRecord(ActionEvent event)throws Exception{
        ViewLoader.showStage(model,"/view/record.fxml", "Patron Record", new Stage());
    }

    @FXML public void handleFavourites(ActionEvent event)throws Exception{
        ViewLoader.showStage(model,"/view/favourites.fxml", "Favourites", new Stage());
    }

    @FXML public void handleAdmin(ActionEvent event) throws Exception{
        ViewLoader.showStage(model,"/view/admin.fxml", "Administration Menu", new Stage());
    }

    public final Library getLibrary() {
        return model;
    }
    
    public void handleExit(ActionEvent event){
        stage.close();
    }

}
