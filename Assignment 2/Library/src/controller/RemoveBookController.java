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

public class RemoveBookController extends Controller<Library> {
    @FXML private Button removeBookBtn;
    @FXML private ListView<Book> booksLv;

    private Book getSelectedBook(){
        return booksLv.getSelectionModel().getSelectedItem();
    }
    public final Library getLibrary() { return model; }
    
    @FXML public void initialize() {}

    @FXML public void handleremoveBookFromList(ActionEvent event) throws Exception{
        Book book = getSelectedBook();
        if (book != null) {
            getLibrary().getCatalogue().removeBook(book);
        }
    }

    public void handleClose(ActionEvent event) throws Exception{
        stage.close();
    }
    
}
