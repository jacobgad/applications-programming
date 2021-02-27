package controller;

import au.edu.uts.ap.javafx.*;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.*;

public class ShowMoviesByGenreController extends Controller<Kiosk>{
    @FXML private Button exitBtn;
    @FXML private Button displayMoviesBtn;
    @FXML private Label genreLbl;
    @FXML private Label moviesLbl;
    @FXML private ListView<Genre> genresLv;
    @FXML private TableView<Movie> moviesTv;

    private Genre getSelectedGenre(){
        return genresLv.getSelectionModel().getSelectedItem();
    }
    public final Kiosk getKiosk() { return model; }

    @FXML
    public void initialize() {
    }
    
    @FXML private void handleDisplayMovies(ActionEvent event) {
        Genre genre = getSelectedGenre();
        moviesTv.setItems(getKiosk().getCatalogue().getMoviesInGenre(genre));
    }
    
    @FXML public void handleExit(ActionEvent event) throws Exception{
        stage.close();
    }
}
