package controller;

import au.edu.uts.ap.javafx.*;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.*;

public class ShowMoviesByYearController extends Controller<Kiosk>  {
    @FXML private Button exitBtn;
    @FXML private Button displayMoviesBtn;
    @FXML private Label yearsLbl;
    @FXML private TableView<Movie> moviesTv;
    @FXML private ListView<Integer> yearsLv;
     
    private Integer getSelectedYear(){
        return yearsLv.getSelectionModel().getSelectedItem();
    }
    public final Kiosk getKiosk() { return model; }

    @FXML
    public void initialize() {
    }
    
    @FXML private void handleDisplayMovies(ActionEvent event) {
        Integer year = getSelectedYear();
        moviesTv.setItems(getKiosk().getCatalogue().getMoviesByYear(year));
    }
    
    @FXML public void handleExit(ActionEvent event) throws Exception{
        stage.close();
    }
}
