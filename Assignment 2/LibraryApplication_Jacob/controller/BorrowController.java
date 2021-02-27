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

public class BorrowController extends Controller<Library> {
    @FXML private TextField patronIDTxtFld;
    @FXML private Button selectPatronBtn;
    @FXML private ListView<Book> avalableBooksLv;
    @FXML private Button borrowBookBtn;

    private final int getID() {
        return Integer.parseInt(patronIDTxtFld.getText());
    }

    private final Patron getPatron() {
        return getLibrary().getPatron(getID());
    }

    private Book getSelectedBook() {
        return avalableBooksLv.getSelectionModel().getSelectedItem();
    }

    public final Library getLibrary() { return model; }
    
    @FXML public void initialize() {
        selectPatronBtn.setDisable(true);

        avalableBooksLv.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldBook, newBook) -> borrowBookBtn.setDisable(getSelectedBook()==null)
        );
    }

    @FXML public void handleSelectPatron(ActionEvent action) throws Exception {
        avalableBooksLv.setItems(getLibrary().getCatalogue().getBorrowableBooks(getPatron()));
    }

    @FXML public void handleBorrowBook(ActionEvent action) throws Exception {
        getLibrary().getCatalogue().loanBookToPatron(getSelectedBook(), getPatron());
        avalableBooksLv.setItems(getLibrary().getCatalogue().getBorrowableBooks(getPatron()));
    }

    @FXML public void keyReleasedProperty() {
        boolean isDisabled = (patronIDTxtFld.getText().isEmpty());
        selectPatronBtn.setDisable(isDisabled);
    }

    public void handleClose(ActionEvent event) throws Exception{
        stage.close();
    }
}