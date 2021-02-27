package controller;

import au.edu.uts.ap.javafx.*;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.*;

public class RemoveMovieController extends Controller<Kiosk>{
    @FXML private Button removeMovBtn;
    @FXML private TableView<Movie> moviesTv;
        
    private Movie getSelectedMovie(){
        return moviesTv.getSelectionModel().getSelectedItem();
    }
    public final Kiosk getKiosk() { return model; }
    
    @FXML
    public void initialize() {
    }

    @FXML
    public void handleremoveMovFromList(ActionEvent event) throws Exception{
        Movie movie = getSelectedMovie();
        getKiosk().getCatalogue().removeMovie(movie);
    }
  
    public void handleExit(ActionEvent event) throws Exception{
      stage.close();
    }
}
