
package controller;

import au.edu.uts.ap.javafx.*;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.*;
import model.*;

public class AddCustomerController extends Controller<Kiosk>{
    @FXML private TextField idTxtFld;
    @FXML private TextField nameTxtFld;
    @FXML private TextField balanceTxtFld;
    @FXML private Text customerAddedTxt;
    @FXML private Button addCusBtn;
    @FXML private Button closeBtn;

    private final int getId() { return Integer.parseInt(idTxtFld.getText()); }
    private final String getName() { return nameTxtFld.getText(); }
    private final int getBalance() { return Integer.parseInt(balanceTxtFld.getText()); }
    public final Kiosk getKiosk() { return model; }
     
     
    @FXML
    public void initialize() {
        customerAddedTxt.setText("");
    }

    @FXML
    public void handleAddCusToList(ActionEvent event) throws Exception{
   
        if(idTxtFld.getText().isEmpty() ||
            nameTxtFld.getText().isEmpty() || 
            balanceTxtFld.getText().isEmpty()){
            customerAddedTxt.setText("Please fill all fields");
            return;
        }
        if(!(idTxtFld.getText().matches("[0-9]+") && balanceTxtFld.getText().matches("[0-9]+"))){
            customerAddedTxt.setText("Invalid input - please enter integers only for ID and Balance");
            return;
        }  

        int id = getId();
        String name = getName();
        int balance = getBalance();

        if (getKiosk().getCustomer(id)== null){
            getKiosk().addCustomer(id,name,balance);
            customerAddedTxt.setText("Customer added to kiosk");
        }else{customerAddedTxt.setText("Customer ID exists in Kiosk");}
    }
    
    public void handleClose(ActionEvent event) throws Exception{
        stage.close();
    }
    
}