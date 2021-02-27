package controller;
import au.edu.uts.ap.javafx.*;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.*;
import model.*;

public class KioskController extends Controller<Kiosk> {
    @FXML private Button quitBtn;
   
    @FXML
    public void initialize() {
    }
  
    @FXML public void handleAdmin(ActionEvent event) throws Exception{
        ViewLoader.showStage(model,"/view/Admin.fxml", "Administration Menu", new Stage());
    }
    @FXML public void handleExploreCat(ActionEvent event)throws Exception{
        ViewLoader.showStage(model,"/view/Catalogue.fxml", "Catalogue", new Stage());
    }
    @FXML  public void handleCustomerRec(ActionEvent event)throws Exception{
        ViewLoader.showStage(model,"/view/CustomerRecord.fxml", "Patron Record", new Stage());
    }
    @FXML public void handleTopup(ActionEvent event)throws Exception{
        ViewLoader.showStage(model,"/view/TopUpAccount.fxml", "Account Top-up", new Stage());
    }
    @FXML public void handleFavMovies(ActionEvent event)throws Exception{
        ViewLoader.showStage(model,"/view/FavouriteMovies.fxml", "Favourites", new Stage());
    }
    public void handleQuit(ActionEvent event){
        stage.close();
    }
    public final Kiosk getKiosk() {
        return model;
    }
}
