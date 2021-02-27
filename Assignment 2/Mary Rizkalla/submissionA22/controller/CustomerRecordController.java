
package controller;

import au.edu.uts.ap.javafx.*;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.*;
import model.*;

public class CustomerRecordController extends Controller<Kiosk>{
   @FXML private Button exitBtn;
   @FXML private Button selectCustomerBtn;
   @FXML private TextField customerIDTxtFld;
   @FXML private Text customerSelectTxt;
   @FXML private TableView<Movie> rentedMoviesTv;
   @FXML private TableView<Movie> rentingHistoryTv;


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
      
      if(!(customerIDTxtFld.getText().matches("[0-9]+"))){
        customerSelectTxt.setText("Invalid input - please enter integers only.");
        return;
      }  
      
      int id = getId();
      if (getKiosk().getCustomer(id)== null){
        customerSelectTxt.setText("Customer ID does not exist.");
      }else{customerSelectTxt.setText(getKiosk().getCustomer(id).toString());}
      
       rentedMoviesTv.setItems(getKiosk().getCustomer(getId()).currentlyRented());
       rentingHistoryTv.setItems(getKiosk().getCustomer(getId()).rentingHistory());
    }

    @FXML
    public void handleClose(ActionEvent event) throws Exception{
        stage.close();
    }
}

