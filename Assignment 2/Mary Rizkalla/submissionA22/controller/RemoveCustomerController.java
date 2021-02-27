package controller;

import au.edu.uts.ap.javafx.*;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.*;

public class RemoveCustomerController extends Controller<Kiosk> {
    @FXML private Button removeCusBtn;
    @FXML private TableView<Customer> customersTv;
        
    private Customer getSelectedCustomer(){
        return customersTv.getSelectionModel().getSelectedItem();
    }
    public final Kiosk getKiosk() { return model; }
        
    @FXML
    public void initialize() {
    }

    @FXML
    public void handleremoveCusFromList(ActionEvent event) throws Exception{
        Customer customer = getSelectedCustomer();
        getKiosk().removeCustomer(customer);    
    }
    public void handleExit(ActionEvent event) throws Exception{
      stage.close();
    }
}
