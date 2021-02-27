package controller;

import au.edu.uts.ap.javafx.*;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.*;
import model.*;

public class ReturnMovieController  extends Controller<Kiosk>{
   @FXML private Button exitBtn;
   @FXML private Button selectCustomerBtn;
   @FXML private Button returnMovieBtn;
   @FXML private TextField customerIDTxtFld;
   @FXML private Text customerSelectTxt;
   @FXML private Text ReturnMovieTxt;
   @FXML private TableView<Movie> rentedMoviesTv;

    private final int getId() { return Integer.parseInt(customerIDTxtFld.getText());}
    public final Kiosk getKiosk() { return model; }
    private Movie getSelectedMovie(){
        return rentedMoviesTv.getSelectionModel().getSelectedItem();
    }
         
    @FXML
    public void initialize() {
        ReturnMovieTxt.setText("");
        customerIDTxtFld.textProperty().addListener((o, oldText, newText) ->
             selectCustomerBtn.setDisable(customerIDTxtFld.getText().isEmpty()));
        
        rentedMoviesTv.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldMovie, newMovie) -> 
                returnMovieBtn.setDisable(getSelectedMovie() == null));
    }

    @FXML
    public void handleCustomerSelect(ActionEvent event) throws Exception{
        
        if(!(customerIDTxtFld.getText().matches("[0-9]+")) || (getKiosk().getCustomer(getId())== null)){
            ReturnMovieTxt.setText("Customer ID does not exist");
            rentedMoviesTv.setItems(null);
        }else{
            rentedMoviesTv.setItems(getKiosk().getCustomer(getId()).currentlyRented());
            ReturnMovieTxt.setText("");
        }
    }
    
    public void handleReturnMovie(ActionEvent event) throws Exception{
        getKiosk().getCatalogue().returnMovieFromCustomer(getSelectedMovie(),getKiosk().getCustomer(getId()));
        ReturnMovieTxt.setText("Movie returned");
    }
    
    @FXML
    public void handleClose(ActionEvent event) throws Exception{
        stage.close();
    }
}
