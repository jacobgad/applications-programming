package controller;

import au.edu.uts.ap.javafx.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.stage.*;
import model.*;

public class AdminController extends Controller<Kiosk>{
    @FXML private Button viewAllCusBtn;
    @FXML private Button viewAllMovBtn;
    @FXML private Button addCusBtn;
    @FXML private Button addMovBtn;
    @FXML private Button removeCusBtn;
    @FXML private Button removeMovBtn;
    @FXML private Button exitBtn;

    @FXML
    public void initialize() {
    }
    
    @FXML 
    public void handleViewAllCus(ActionEvent event) throws Exception{
        ViewLoader.showStage(model,"/view/ShowAllCustomers.fxml", "Show All Customers", new Stage());
    }
    
    @FXML
    public void handleViewAllMov(ActionEvent event) throws Exception{
        ViewLoader.showStage(model,"/view/ShowAllMovies.fxml", "Show All Movies",  new Stage());
    }
    
    @FXML 
    public void handleAddCus(ActionEvent event) throws Exception{
        ViewLoader.showStage(model,"/view/AddCustomer.fxml", "Add Customer", new Stage());
    }
    
    @FXML 
    public void handleAddMov(ActionEvent event) throws Exception{
        ViewLoader.showStage(model,"/view/AddMovie.fxml", "Add Movie", new Stage());
    }
    
    @FXML 
    public void handleRemoveCus(ActionEvent event) throws Exception{
        ViewLoader.showStage(model,"/view/RemoveCustomer.fxml", "Remove Customer", new Stage());
    }
    
    @FXML 
    public void handleRemoveMov(ActionEvent event) throws Exception{
        ViewLoader.showStage(model,"/view/RemoveMovie.fxml", "Remove Movie", new Stage());
    }
    
    public void handleExit(ActionEvent event) throws Exception{
        stage.close();
    }

}
