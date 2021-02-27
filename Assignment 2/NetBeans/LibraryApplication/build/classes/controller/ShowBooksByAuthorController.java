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

public class ShowBooksByAuthorController extends Controller<Library> {
    @FXML private Button displayBtn;
    @FXML private ListView<Author> authorsLv;
    @FXML private ListView<Book> booksLv;

    private Author getSelectedAuthor(){
        return authorsLv.getSelectionModel().getSelectedItem();
    }
    public final Library getLibrary() { return model; }
    
    @FXML public void initialize() {}

    @FXML private void handleDisplayBooks(ActionEvent event) {
        Author author = getSelectedAuthor();
        booksLv.setItems(getLibrary().getCatalogue().getBooksByAuthor(author));
    }

    public void handleClose(ActionEvent event) throws Exception{
        stage.close();
    }
    
}

