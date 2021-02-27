
package controller;

import au.edu.uts.ap.javafx.*;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.*;
import model.*;

public class AddMovieController extends Controller<Kiosk>  {
    @FXML private TextField titleTxtFld;
    @FXML private TextField yearTxtFld;
    @FXML private TextField genreTxtFld;
    @FXML private TextField priceTxtFld;
    @FXML private Text movieAddedTxt;
    @FXML private Button addMovBtn;
    @FXML private Button closeBtn;

    private final String getTitle() { return  titleTxtFld.getText();}
    private final int getYear() { return  Integer.parseInt(yearTxtFld.getText());}
    private final String getGenre() { return genreTxtFld.getText(); }
    private final int getPrice() { return Integer.parseInt(priceTxtFld.getText()); }
    public final Kiosk getKiosk() { return model; }
    
    
    @FXML
    public void initialize() {
        movieAddedTxt.setText("");
    }

    @FXML
    public void handleAddMovToList(ActionEvent event) throws Exception{
        
        if(titleTxtFld.getText().isEmpty() ||
            yearTxtFld.getText().isEmpty() || 
            genreTxtFld.getText().isEmpty() ||
            priceTxtFld.getText().isEmpty()){
            movieAddedTxt.setText("Please fill all fields");
            return;
        }
        
        if(!(yearTxtFld.getText().matches("[0-9]+") && priceTxtFld.getText().matches("[0-9]+"))){
            movieAddedTxt.setText("Invalid input - please enter integers only for Year and Price");
            return;
        } 
        
        String title = getTitle();
        int year = getYear();
        String genre = getGenre();
        int price = getPrice();
        
        if (getKiosk().getCatalogue().hasMovie(title, year)){
            movieAddedTxt.setText("Movie exists in Catalogue");
        }else{
            getKiosk().getCatalogue().addMovie(title, year, genre, price);
            movieAddedTxt.setText("Movie added to Catalogue");
        }
    }
  
    public void handleClose(ActionEvent event) throws Exception{
        stage.close();
    }
    
}
