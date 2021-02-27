package controller;

import java.util.Observable;
import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import model.Library;
import javafx.scene.control.*;
import javafx.scene.text.*;
import model.*;

public class ReturnController extends Controller<Library> {
    @FXML private TextField patronIDTxtFld;
    @FXML private Button selectPatronBtn;
    @FXML private ListView<Book> borrowedBooksLv;
    @FXML private Button returnBookBtn;

    private final int getID() {
        return Integer.parseInt(patronIDTxtFld.getText());
    }

    private final Patron getPatron() {
        return getLibrary().getPatron(getID());
    }

    private Book getSelectedBook() {
        return borrowedBooksLv.getSelectionModel().getSelectedItem();
    }

    public final Library getLibrary() { return model; }
    
    @FXML public void initialize() {
        selectPatronBtn.setDisable(true);

        borrowedBooksLv.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldBook, newBook) -> returnBookBtn.setDisable(getSelectedBook()==null)
        );
    }

    @FXML public void handleSelectPatron(ActionEvent action) throws Exception {
        borrowedBooksLv.setItems(getLibrary().getPatron(getID()).currentlyBorrowed());
    }

    @FXML public void handleReturnBook(ActionEvent action) throws Exception {
        getLibrary().getCatalogue().returnBookFromPatron(getSelectedBook(), getPatron());
        borrowedBooksLv.setItems(getLibrary().getPatron(getID()).currentlyBorrowed());
    }

    @FXML public void keyReleasedProperty() {
        boolean isDisabled = (patronIDTxtFld.getText().isEmpty());
        selectPatronBtn.setDisable(isDisabled);
    }

    public void handleClose(ActionEvent event) throws Exception{
        stage.close();
    }
}