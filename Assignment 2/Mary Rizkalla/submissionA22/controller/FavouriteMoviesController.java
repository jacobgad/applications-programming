
package controller;

import au.edu.uts.ap.javafx.*;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.*;
import model.*;

public class FavouriteMoviesController extends Controller<Kiosk> {
   @FXML private Button exitBtn;
   @FXML private Button selectCustomerBtn;
   @FXML private TextField customerIDTxtFld;
   @FXML private Text customerSelectTxt;
   @FXML private TableView<Movie> favMoviesTv;


    private final int getId() { return Integer.parseInt(customerIDTxtFld.getText());}
    public final Kiosk getKiosk() { return model; }

         
    @FXML
    public void initialize() {
        customerSelectTxt.setText("");
    }

    @FXML
    public void handleCustomerSelect(ActionEvent event) throws Exception{
        
      if(customerIDTxtFld.getText().isEmpty()){
        customerSelectTxt.setText("Please enter a customer ID");
        return;
      }  
      
      int id = getId();
      if (!(customerIDTxtFld.getText().matches("[0-9]+")) || (getKiosk().getCustomer(id)== null)){
        customerSelectTxt.setText("Customer ID does not exist.");
      }else{
        customerSelectTxt.setText("");
      }
      
      favMoviesTv.setItems(getKiosk().getCustomer(getId()).favouriteMovies());
    }
    
  @FXML
    public void handleClose(ActionEvent event) throws Exception{
    stage.close();
    }
}
