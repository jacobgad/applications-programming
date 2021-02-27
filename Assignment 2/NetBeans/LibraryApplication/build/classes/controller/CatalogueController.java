package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import model.Library;


public class CatalogueController extends Controller<Library> {
    
    @FXML public void initialize() {}

    @FXML public void handleAllBooks(ActionEvent event) throws Exception{
        ViewLoader.showStage(model,"/view/showAllBooks.fxml", "Complete Catalogue", new Stage());
    }

    @FXML public void handleAvailableBooks(ActionEvent event) throws Exception{
        ViewLoader.showStage(model,"/view/showAvailableBooks.fxml", "Available Books", new Stage());
    }

    @FXML public void handleBooksByGenre(ActionEvent event) throws Exception{
        ViewLoader.showStage(model,"/view/showBooksByGenre.fxml", "Browse by Genre", new Stage());
    }

    @FXML public void handleBooksByAuthor(ActionEvent event) throws Exception{
        ViewLoader.showStage(model,"/view/showBooksByAuthor.fxml", "Browse by Author", new Stage());
    }

    @FXML public void handleBorrowBooks(ActionEvent event) throws Exception{
        ViewLoader.showStage(model,"/view/borrow.fxml", "Borrow a Book", new Stage());
    }

    @FXML public void handleReturnBooks(ActionEvent event) throws Exception{
        ViewLoader.showStage(model,"/view/return.fxml", "Return a Book", new Stage());
    }

    @FXML public void handlePlaceHold(ActionEvent event) throws Exception{
        ViewLoader.showStage(model,"/view/placeHold.fxml", "Place a Hold", new Stage());
    }

    public void handleExit(ActionEvent event) throws Exception{
        stage.close();
    }
}
