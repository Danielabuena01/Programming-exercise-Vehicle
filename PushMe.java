import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class PushMe extends Application {
   @Override
    public void start(Stage stage) {
        TextField pushMeTextField = new TextField();
        pushMeTextField.setMaxWidth(250);

        Label pushMeLabel = new Label();
        pushMeLabel.setTextFill(Color.RED);
        pushMeLabel.setFont(Font.font("Arial", 20));

        Button displayButton = new Button();
        displayButton.setText("Display Text");
        displayButton.setOnAction(e -> pushMeLabel.setText("You entered: " + pushMeTextField.getText()));

        Button displayButton2 = new Button();
        displayButton2.setText("Convert to Upper Case");
        displayButton2.setOnAction(e -> pushMeLabel.setText("You entered: " + pushMeTextField.getText().toUpperCase()));

        Button displayButton3 = new Button();
        displayButton3.setText("Convert to Lower Case");
        displayButton3.setOnAction(e -> pushMeLabel.setText("You entered: " + pushMeTextField.getText().toLowerCase()));

        VBox root = new VBox();
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);

        root.getChildren().addAll(pushMeTextField, displayButton, displayButton2, displayButton3, pushMeLabel);

        Scene scene = new Scene(root, 350, 250);

        stage.setScene(scene);
        stage.setTitle("Daniela Nina P. Buena ");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
