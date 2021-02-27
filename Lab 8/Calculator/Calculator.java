import javafx.scene.*;
import javafx.stage.*;
import javafx.application.*;
import javafx.scene.control.*;
//import javafx.scene.layout.*;
//import javafx.scene.text.*;
//import javafx.scene.image.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.event.ActionEvent;
//import javafx.scene.layout.VBox;
import javafx.event.EventHandler;

public class Calculator extends Application {
    public static void main(String[] args) { launch(args); }

    private Label firstNumberLbl;
    private TextField firstNumberTf;
    private Label secondNumberLbl;
    private TextField secondNumberTf;
    private Label operationLbl;
    private Button addBtn;
    private Button subBtn;
    private Button mulBtn;
    private Button divBtn;
    private Label resultLbl;
    private TextField resultTf;

    @Override
    public void start(Stage stage) throws Exception {
        // 1. create the leaf nodes
        firstNumberLbl = new Label("First number:");
        firstNumberTf = new TextField();
        secondNumberLbl = new Label("Second number:");
        secondNumberTf = new TextField();
        operationLbl = new Label("Operation:");
        addBtn = new Button("+");
        subBtn = new Button("-");
        mulBtn = new Button("*");
        divBtn = new Button("/");
        resultLbl = new Label("Result:");
        resultTf = new TextField();

        //event handlers
        addBtn.setOnAction(new AddHandler());
        subBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setResult(subNumbers(getFisrtNumber(), getSecondNumber()));
            }
        });

        //addBtn.setOnAction(event -> setResult(addNumbers(getFisrtNumber(), getSecondNumber())));
        //subBtn.setOnAction(event -> setResult(subNumbers(getFisrtNumber(), getSecondNumber())));
        mulBtn.setOnAction(event -> setResult(mulNumbers(getFisrtNumber(), getSecondNumber())));
        divBtn.setOnAction(event -> setResult(divNumbers(getFisrtNumber(), getSecondNumber())));

        // 2. create the branch node
        GridPane gBox = new GridPane();
        gBox.add(firstNumberLbl, 0, 0);
        gBox.add(firstNumberTf, 1, 0);
        gBox.add(secondNumberLbl, 0, 1);
        gBox.add(secondNumberTf, 1, 1);
        gBox.add(operationLbl, 0, 2);
        
        HBox hBox = new HBox(10, addBtn, subBtn, mulBtn, divBtn);
        
        gBox.add(hBox, 1, 2);
        gBox.add(resultLbl, 0, 3);
        gBox.add(resultTf, 1, 3);

        //VBox vBox = new VBox(10);
        //vBox.getChildren().addAll(firstNumberLbl, firstNumberTf, secondNumberLbl, secondNumberTf, operationLbl, addBtn, subBtn, mulBtn, divBtn, resultLbl, resultTf);

        // 3. set the scene, show the stage
       stage.setScene(new Scene(gBox));
       stage.setTitle("Calculator");
       stage.show();

    }

    private class AddHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent t) {
            setResult(addNumbers(getFisrtNumber(), getSecondNumber()));
        }
    }

    private int getFisrtNumber() {
        return Integer.parseInt(firstNumberTf.getText());
    }

    private int getSecondNumber() {
        return Integer.parseInt(secondNumberTf.getText());
    }

    private void setResult(int result) {
        resultTf.setText(""+result);
    }

    private int addNumbers(int number1, int number2) {
        return number1 + number2;
    }

    private int subNumbers(int number1, int number2) {
        return number1 - number2;
    }

    private int mulNumbers(int number1, int number2) {
        return number1 * number2;
    }

    private int divNumbers(int number1, int number2) {
        return number1 / number2;
    }

}