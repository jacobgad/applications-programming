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

public class ShowBooksByGenreController extends Controller<Library> {
    @FXML private Button displayBtn;
    @FXML private ListView<Genre> genreLv;
    @FXML private ListView<Book> booksLv;

    private Genre getSelectedGenre(){
        return genreLv.getSelectionModel().getSelectedItem();
    }
    public final Library getLibrary() { return model; }
    
    @FXML public void initialize() {}

    @FXML private void handleDisplayBooks(ActionEvent event) {
        Genre genre = getSelectedGenre();
        booksLv.setItems(getLibrary().getCatalogue().getBooksInGenre(genre));
    }

    public void handleClose(ActionEvent event) throws Exception{
        stage.close();
    }
    
}

