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

public class PlaceHoldController extends Controller<Library> {
    @FXML private TextField patronIDTxtFld;
    @FXML private Button selectPatronBtn;
    @FXML private ListView<Book> allBooksLv;
    @FXML private Text holdTxt;
    @FXML private Button holdBookBtn;

    private final int getID() {
        return Integer.parseInt(patronIDTxtFld.getText());
    }

    private final Patron getPatron() {
        return getLibrary().getPatron(getID());
    }

    private Book getSelectedBook() {
        return allBooksLv.getSelectionModel().getSelectedItem();
    }

    public final Library getLibrary() { return model; }
    
    @FXML public void initialize() {
        selectPatronBtn.setDisable(true);

        allBooksLv.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldBook, newBook) -> holdBookBtn.setDisable(getSelectedBook()==null)
        );
    }

    @FXML public void handleSelectPatron(ActionEvent action) throws Exception {
        if (getPatron()==null) {
            holdTxt.setText("No Patron selected");
        }
        else {
            allBooksLv.setItems(getLibrary().getCatalogue().getAllBooks());
        }
    }

    @FXML public void handleHoldBook(ActionEvent action) throws Exception {
        Book book = getSelectedBook();
        if (book.patronWithFirstHold() == null) {
            book.addHold(getPatron());
            holdTxt.setText("Hold placed on "+book.getTitle()+" for "+getPatron().getName());
        }
        else {
            holdTxt.setText(book.patronWithFirstHold().getName()+" has already placed a hold on book "+book.getTitle());
        }
    }

    @FXML public void keyReleasedProperty() {
        boolean isDisabled = (patronIDTxtFld.getText().isEmpty());
        selectPatronBtn.setDisable(isDisabled);
    }

    public void handleClose(ActionEvent event) throws Exception{
        stage.close();
    }
}