package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import model.Library;
import javafx.scene.control.*;
import javafx.scene.text.*;

public class AddBookController extends Controller<Library> {
    @FXML private TextField titleTxtFld;
    @FXML private TextField authorTxtFld;
    @FXML private TextField genreTxtFld;
    @FXML private Text bookAddedTxt;
    @FXML private Button addBookBtn;
    @FXML private Button closeBtn;

    public final Library getLibrary() { return model; }
    private final String getTitle() { return titleTxtFld.getText();}
    private final String getAuthor() { return authorTxtFld.getText();}
    private final String getGenre() { return genreTxtFld.getText(); }
    
    @FXML public void initialize() {}

    @FXML public void handleAddBookToList(ActionEvent event) throws Exception{
        
        if(titleTxtFld.getText().isEmpty() || authorTxtFld.getText().isEmpty() || genreTxtFld.getText().isEmpty()) {
            bookAddedTxt.setText("Please fill all fields");
            return;
        } 
        
        String title = getTitle();
        String author = getAuthor();
        String genre = getGenre();
        
        if (getLibrary().getCatalogue().hasBook(title, author)){
            bookAddedTxt.setText("Book exists in Catalogue");
        }else{
            getLibrary().getCatalogue().addBook(title, author, genre);
            bookAddedTxt.setText("Book added to Catalogue");
        }
    }

    public void handleClose(ActionEvent event) throws Exception{
        stage.close();
    }
}
