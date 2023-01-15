import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.effect.Shadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class HomePage extends Application {

    Stage homePage;
    Scene homePageScene;

    @Override
    public void start(Stage primaryStage) throws Exception {
        homePage = primaryStage;
        
        Separator separator = new Separator(Orientation.VERTICAL);
        separator.setMinHeight(600);
        
        Button homeButton = new Button("Home");
        Button menuButton = new Button("Menu");
        Button cartButton = new Button("Cart");
        Button logOutButton = new Button("Log Out");
        Button tableResButton = new Button("Table\nReservation");
        tableResButton.setTextAlignment(TextAlignment.CENTER);
        GridPane homeGrid = new GridPane();
        ScrollPane scroll = new ScrollPane();
        // Pane sidePane = new Pane();
        // sidePane.setPrefSize(200, 600);
        AnchorPane a1 = new AnchorPane(separator,menuButton,cartButton,homeButton,logOutButton,tableResButton);

        // AnchorPane.setRightAnchor(sidePane, 400.0);
        // sidePane.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));

        AnchorPane.setLeftAnchor(separator, 200.0);
        AnchorPane.setRightAnchor(separator, 600.0);

        AnchorPane.setTopAnchor(homeButton, 20.0);
        AnchorPane.setLeftAnchor(homeButton, 30.0);
        AnchorPane.setRightAnchor(homeButton, 630.0);

        AnchorPane.setLeftAnchor(menuButton, 30.0);
        AnchorPane.setRightAnchor(menuButton, 630.0);
        AnchorPane.setTopAnchor(menuButton, 60.0);

        AnchorPane.setLeftAnchor(cartButton, 30.0);
        AnchorPane.setRightAnchor(cartButton, 630.0);
        AnchorPane.setTopAnchor(cartButton, 100.0);

        AnchorPane.setLeftAnchor(logOutButton, 30.0);
        AnchorPane.setRightAnchor(logOutButton, 630.0);
        AnchorPane.setBottomAnchor(logOutButton, 20.0);

        AnchorPane.setLeftAnchor(tableResButton, 30.0);
        AnchorPane.setRightAnchor(tableResButton, 630.0);
        AnchorPane.setTopAnchor(tableResButton, 140.0);
        AnchorPane.setBottomAnchor(tableResButton, 400.0);

        // AnchorPane.setLeftAnchor(homeGrid, 200.0);
        // AnchorPane.setRightAnchor(homeGrid, 0.0);

        // AnchorPane.setLeftAnchor(scroll, 149.0);
        // AnchorPane.setRightAnchor(scroll, 0.0);
        // AnchorPane.setBottomAnchor(scroll, 0.0);
        // AnchorPane.setTopAnchor(scroll, 0.0);

        scroll.vbarPolicyProperty().setValue(ScrollPane.ScrollBarPolicy.ALWAYS);

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

        cartButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Cart cart = new Cart();
                try {
                    cart.start(homePage);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                
            }
            
        });
        // naveen learning branch created
        homePageScene = new Scene(a1,800,600);
        homePage.setResizable(false);
        homePage.setScene(homePageScene);
        homePage.show();

    }

}
