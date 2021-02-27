package controller;

import au.edu.uts.ap.javafx.*;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.*;
import model.*;

public class RentMovieController extends Controller<Kiosk>{
   @FXML private Button exitBtn;
   @FXML private Button selectCustomerBtn;   
   @FXML private Button rentMovieBtn;
   @FXML private TextField customerIDTxtFld;
   @FXML private Text customerSelectTxt;
   @FXML private Text RentMovieTxt;
   @FXML private TableView<Movie> availableMoviesTv;

    private final int getId() { return Integer.parseInt(customerIDTxtFld.getText());}
    public final Kiosk getKiosk() { return model; }
    private Movie getSelectedMovie(){
        return availableMoviesTv.getSelectionModel().getSelectedItem();
    }

    @FXML
    public void initialize() {
        RentMovieTxt.setText("");
        customerIDTxtFld.textProperty().addListener((o, oldText, newText) ->
             selectCustomerBtn.setDisable(customerIDTxtFld.getText().isEmpty()));
        
        availableMoviesTv.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldMovie, newMovie) -> 
                rentMovieBtn.setDisable(getSelectedMovie() == null));
    }
    
    @FXML
    public void handleCustomerSelect(ActionEvent event) throws Exception{
        if(!(customerIDTxtFld.getText().matches("[0-9]+")) || (getKiosk().getCustomer(getId())== null)){
            RentMovieTxt.setText("Customer ID does not exist");
            availableMoviesTv.setItems(null);
        }else{
            availableMoviesTv.setItems(getKiosk().getCatalogue().getAvailableMovies());
            RentMovieTxt.setText("");
        }
    }
    
    @FXML
    public void handleMovieRent(ActionEvent event) throws Exception{
        //check if balance is high enough to rent movie 
        if((getKiosk().getCatalogue().rentMovieToCustomer
          (getSelectedMovie(),getKiosk().getCustomer(getId()))))
        {
           RentMovieTxt.setText("Movie rented");
        }else{
            RentMovieTxt.setText("Not enough funds");
        }
    }
    
    @FXML  
    public void handleClose(ActionEvent event) throws Exception{
        stage.close();
    }
}
