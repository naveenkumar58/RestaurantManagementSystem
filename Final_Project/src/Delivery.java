import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Delivery extends Application {

    Stage stage;
    Scene scene;
    String file = "Delivery.txt";
    Filing fl;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        Label addLabel = new Label("Address");
        TextArea address = new TextArea();

        Button orderButton = new Button("Place Order");
        orderButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                fl = new Filing();
                if (addLabel.getText().equals("")) {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setContentText("Please fill the fields");
                    alert.show();
                } else {
                    fl.writeData(address.getText(), file);
                    stage.close();
                }

            }

        });

        GridPane g = new GridPane();
        g.setHgap(20);
        g.setVgap(10);
        g.setAlignment(Pos.CENTER);
        g.add(addLabel, 1, 1);
        g.add(address, 1, 2);
        g.add(orderButton, 1, 3);

        scene = new Scene(g, 600, 600);
        stage.setScene(scene);
        stage.show();
    }

}