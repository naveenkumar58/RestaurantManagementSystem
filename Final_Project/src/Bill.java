import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Bill extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    Stage billStage = new Stage();
    billStage.initModality(Modality.APPLICATION_MODAL);
    billStage.setTitle("Restaurant Bill");
    billStage.setMinWidth(250);

    Label itemLabel = new Label("Item");
    Label priceLabel = new Label("Price");
    Label item1Label = new Label("Hamburger");
    Label item2Label = new Label("Fries");
    Label item3Label = new Label("Soda");
    Label item1Price = new Label("$5.00");
    Label item2Price = new Label("$2.50");
    Label item3Price = new Label("$1.50");
    Label totalLabel = new Label("Total");
    Label totalPrice = new Label("$9.00");

    Button closeButton = new Button("Close");
    closeButton.setOnAction(e -> billStage.close());

    GridPane billPane = new GridPane();
    billPane.setPadding(new Insets(10, 10, 10, 10));
    billPane.setVgap(8);
    billPane.setHgap(10);
    billPane.setAlignment(Pos.CENTER);
    billPane.add(itemLabel, 0, 0);
    billPane.add(priceLabel, 1, 0);
    billPane.add(item1Label, 0, 1);
    billPane.add(item2Label, 0, 2);
    billPane.add(item3Label, 0, 3);
    billPane.add(item1Price, 1, 1);
    billPane.add(item2Price, 1, 2);
    billPane.add(item3Price, 1, 3);
    billPane.add(totalLabel, 0, 4);
    billPane.add(totalPrice, 1, 4);
    billPane.add(closeButton, 1, 5);

    Scene billScene = new Scene(billPane);
    billStage.setScene(billScene);
    billStage.showAndWait();
  }
}
