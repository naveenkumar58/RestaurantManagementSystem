import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.effect.Shadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
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
        AnchorPane a1 = new AnchorPane(separator,homeButton,menuButton,cartButton,logOutButton,tableResButton);

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
        
        homePageScene = new Scene(a1,600,600);
        homePage.setResizable(false);
        homePage.setScene(homePageScene);
        homePage.show();

    }

}
