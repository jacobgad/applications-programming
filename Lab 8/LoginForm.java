import javafx.scene.*;
import javafx.stage.*;
import javafx.application.*;
import javafx.scene.control.*;
//import javafx.scene.layout.*;
import javafx.scene.text.*;
//import javafx.scene.image.*;
import javafx.scene.layout.GridPane;
//import javafx.scene.layout.HBox;
//import javafx.event.ActionEvent;
//import javafx.scene.layout.VBox;
//import javafx.event.EventHandler;

public class LoginForm extends Application {
    public static void main(String[] args) { launch(args); }

    private Label usernameLbl;
    private TextField usernameTf;
    private Label passwordLbl;
    private PasswordField passwordPf;
    private Button loginBtn;
    private Text loginResultTxt;

    @Override
    public void start(Stage stage) throws Exception {
        //leaf nodes
        usernameLbl = new Label("Username:");
        usernameTf = new TextField();
        passwordLbl = new Label("Password:");
        passwordPf = new PasswordField();
        loginBtn = new Button("Login");
        loginResultTxt = new Text("");

        //event handlers
        loginBtn.setOnAction(event -> {
            if (getUsername().equals("sam") && getPassword().equals("mypassword")) {
                loginResultTxt.setText("Password correct!");
            }
            else {
                loginResultTxt.setText("Password incorrect!");
            }
        });

        //branch node
        GridPane gBox = new GridPane();
        gBox.add(usernameLbl, 0, 0);
        gBox.add(usernameTf, 1, 0);
        gBox.add(passwordLbl, 0, 1);
        gBox.add(passwordPf, 1, 1);
        gBox.add(loginBtn, 1, 2);
        gBox.add(loginResultTxt, 1, 3);

        //Stage 
        stage.setScene(new Scene(gBox));
        stage.setTitle("Login");
        stage.show();
    }

    private String getUsername() {
        return usernameTf.getText();
    }

    private String getPassword() {
        return passwordPf.getText();
    }

}