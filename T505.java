import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class T505 extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Simple Calculator");

        // Create text fields for input
        TextField num1Field = new TextField();
        TextField num2Field = new TextField();

        // Create labels and result field
        Label resultLabel = new Label("Result:");
        TextField resultField = new TextField();
        resultField.setEditable(false);  // Result field is not editable

        // Create buttons for arithmetic operations
        Button addButton = new Button("+");
        addButton.setOnAction(e -> {
            calculateResult(num1Field, num2Field, resultField, '+');
        });

        Button subtractButton = new Button("-");
        subtractButton.setOnAction(e -> {
            calculateResult(num1Field, num2Field, resultField, '-');
        });

        Button multiplyButton = new Button("x");
        multiplyButton.setOnAction(e -> {
            calculateResult(num1Field, num2Field, resultField, '*');
        });

        Button divideButton = new Button("/");
        divideButton.setOnAction(e -> {
            calculateResult(num1Field, num2Field, resultField, '/');
        });

        // Create a layout grid
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(5));
        grid.setHgap(15);
        grid.setVgap(10);

        // Add components to the grid
        grid.add(new Label("Number 1:"), 0, 0);
        grid.add(num1Field, 1, 0);
        grid.add(new Label("Number 2:"), 0, 1);
        grid.add(num2Field, 1, 1);
        grid.add(addButton, 0, 2);
        grid.add(subtractButton, 1, 2);
        grid.add(multiplyButton, 0, 3);
        grid.add(divideButton, 1, 3);
        grid.add(resultLabel, 0, 4);
        grid.add(resultField, 1, 4);

        // Create scene and set it on the stage
        Scene scene = new Scene(grid, 250, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void calculateResult(TextField num1Field, TextField num2Field, TextField resultField, char operator) {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double result = 0;

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        resultField.setText("Error: Division by zero");
                        return;
                    }
                    break;
            }

            resultField.setText(Double.toString(result));
        } catch (NumberFormatException e) {
            resultField.setText("Error: Invalid input");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
