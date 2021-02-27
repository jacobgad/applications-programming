
package controller;

import au.edu.uts.ap.javafx.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.stage.*;
import model.*;

public class CatalogueController extends Controller<Kiosk>{
    @FXML private Button exitBtn;
    @FXML private Button allMoviesBtn;
    @FXML private Button availableMoviesBtn;
    @FXML private Button moviesByGenreBtn;
    @FXML private Button moviesByYearBtn;
    @FXML private Button rentMovieBtn;
    @FXML private Button returnMovieBtn;

    @FXML
    public void initialize() {
    }
    
    @FXML public void handleAllMovies(ActionEvent event) throws Exception{
        ViewLoader.showStage(model,"/view/ShowAllMovies.fxml", "All Movies", new Stage());
    }
  
    @FXML public void handleAvailableMovies(ActionEvent event) throws Exception{
        ViewLoader.showStage(model,"/view/ShowAvailableMovies.fxml", "Available Movies", new Stage());
    } 
  
    @FXML public void handleMoviesByGenre(ActionEvent event) throws Exception{
        ViewLoader.showStage(model,"/view/ShowMoviesByGenre.fxml", "Movies By Genre", new Stage());
    }
  
    @FXML public void handleMoviesByYear(ActionEvent event) throws Exception{
        ViewLoader.showStage(model,"/view/ShowMoviesByYear.fxml", "Movies By Year", new Stage());
    }
  
    @FXML public void handleRentMovie(ActionEvent event) throws Exception{
        ViewLoader.showStage(model,"/view/RentMovie.fxml", "Rent a Movie", new Stage());
    }
 
    @FXML public void handleReturnMovie(ActionEvent event) throws Exception{
        ViewLoader.showStage(model,"/view/ReturnMovie.fxml", "Return a Movie", new Stage());
    }
    
    public void handleExit(ActionEvent event) throws Exception{
        stage.close();        
    }
}
