package controller;

import au.edu.uts.ap.javafx.*;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.*;

public class ShowAvailableMoviesController extends Controller<Kiosk>{
    @FXML private Button exitBtn;
    @FXML private TableView<Movie> moviesTv;

    public final Kiosk getKiosk() { return model; }
    
    @FXML
    public void initialize() {
    }

    @FXML
    public void handleExit(ActionEvent event) throws Exception{
        stage.close();
    }
}
