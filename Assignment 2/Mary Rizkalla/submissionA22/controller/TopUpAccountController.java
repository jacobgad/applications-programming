package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.Kiosk;

public class TopUpAccountController  extends Controller<Kiosk>{
    @FXML private TextField idTxtFld;
    @FXML private TextField TopUpAmountTxtFld;
    @FXML private Text topUpAccountTxt;
    @FXML private Button TopUpAccountBtn;
    @FXML private Button closeBtn;
    
    private final int getId() { return Integer.parseInt(idTxtFld.getText()); }
    private final int getTopUpAmount() { return Integer.parseInt(TopUpAmountTxtFld.getText()); }
    public final Kiosk getKiosk() { return model; }

    @FXML
    public void initialize() {
        topUpAccountTxt.setText("");
    }

    public void handleAccountTopUp(ActionEvent event) throws Exception{
        
        if(idTxtFld.getText().isEmpty() ||
            TopUpAmountTxtFld.getText().isEmpty()){
            topUpAccountTxt.setText("Please fill all fields");
            return;
        }
        
        if(!(idTxtFld.getText().matches("[0-9]+") && TopUpAmountTxtFld.getText().matches("[0-9]+"))){
            topUpAccountTxt.setText("Invalid input - please enter integers only for ID and Top-up Amount.");
            return;
        }
        
        int id = getId();
        int topUpAmount = getTopUpAmount();
        
        if (getKiosk().getCustomer(id)== null){
            topUpAccountTxt.setText("Customer ID does not exist in Kiosk");
        }else{     
            getKiosk().topUpAccount(getKiosk().getCustomer(id), topUpAmount);
            topUpAccountTxt.setText("Transaction Complete");
        }
    }
    
    @FXML
    public void handleClose(ActionEvent event) throws Exception{
        stage.close();
    }
}
