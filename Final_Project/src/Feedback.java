import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.effect.Shadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.effect.DropShadow;
import javafx.stage.Stage;

public class Feedback extends Application {

    Stage homePage;
    Scene feedBackScene;

    @Override
    public void start(Stage primaryStage) throws Exception {

        homePage = primaryStage;

        Text feedbackLabel = new Text("CONTACT US");
        feedbackLabel.setFont(Font.font("Helvetica", FontWeight.BOLD, 24));
        feedbackLabel.setFill(Color.ORANGERED);

        Text description = new Text("Have any feedback? Let us know!");
        description.setFont(Font.font("Helvetica", FontWeight.NORMAL, 18));
        description.setFill(Color.BLACK);

        TextArea feedbackText = new TextArea();
        feedbackText.setPromptText("Write your feedback here!");
        feedbackText.setStyle("-fx-focus-color: #FF6347;");
        feedbackText.setStyle("-fx-border-color: red;");
        feedbackText.setPrefRowCount(8);
        feedbackText.setPrefColumnCount(10);
        feedbackText.setMaxWidth(300);
        feedbackText.setWrapText(true);

        Button submitButton = new Button("Submit");
        submitButton.setStyle("-fx-background-radius: 20; -fx-background-color: BLUE;");
        submitButton.setFont(Font.font(null, FontWeight.BOLD, 16));
        submitButton.setTextFill(Color.WHITE);
        submitButton.setPrefWidth(200);
        submitButton.setOnMouseEntered(e -> submitButton.setEffect(new DropShadow()));
        submitButton.setOnMouseExited(e -> submitButton.setEffect(null));

        VBox root = new VBox();
        root.setPadding(new Insets(10));
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(feedbackLabel, description, feedbackText, submitButton);

        Separator separator = new Separator(Orientation.VERTICAL);
        separator.setMinHeight(600);

        Button homeButton = new Button("Home");
        Button menuButton = new Button("Menu");
        Button cartButton = new Button("Cart");
        Button logOutButton = new Button("Log Out");
        Button tableResButton = new Button("Table\nReservation");
        tableResButton.setTextAlignment(TextAlignment.CENTER);
        AnchorPane a1 = new AnchorPane(separator, homeButton, menuButton, cartButton, logOutButton, tableResButton,
                root);

        AnchorPane.setLeftAnchor(separator, 200.0);
        AnchorPane.setRightAnchor(separator, 500.0);

        AnchorPane.setTopAnchor(homeButton, 20.0);
        AnchorPane.setLeftAnchor(homeButton, 30.0);
        AnchorPane.setRightAnchor(homeButton, 480.0);

        AnchorPane.setLeftAnchor(menuButton, 30.0);
        AnchorPane.setRightAnchor(menuButton, 480.0);
        AnchorPane.setTopAnchor(menuButton, 60.0);

        AnchorPane.setLeftAnchor(cartButton, 30.0);
        AnchorPane.setRightAnchor(cartButton, 480.0);
        AnchorPane.setTopAnchor(cartButton, 100.0);

        AnchorPane.setLeftAnchor(logOutButton, 30.0);
        AnchorPane.setRightAnchor(logOutButton, 480.0);
        AnchorPane.setBottomAnchor(logOutButton, 20.0);

        AnchorPane.setLeftAnchor(tableResButton, 30.0);
        AnchorPane.setRightAnchor(tableResButton, 480.0);
        AnchorPane.setTopAnchor(tableResButton, 140.0);
        AnchorPane.setBottomAnchor(tableResButton, 400.0);

        AnchorPane.setLeftAnchor(root, 50.0);
        AnchorPane.setRightAnchor(root, 30.0);
        AnchorPane.setTopAnchor(root, 20.0);

        logOutButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Login login = new Login();

                try {
                    login.start(homePage);
                } catch (Exception e) {

                    e.printStackTrace();
                }

            }

        });
        // naveen learning branch created
        feedBackScene = new Scene(a1, 600, 600);
        homePage.setResizable(false);
        homePage.setTitle("FeedBack");
        homePage.setScene(feedBackScene);
        homePage.show();

    }

}
