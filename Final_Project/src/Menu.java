import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Shadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Menu extends Application {


    Stage homePage;
    Scene homePageScene;

    @Override
    public void start(Stage primaryStage) throws Exception {
        homePage = primaryStage;
        
        Separator separator = new Separator(Orientation.VERTICAL);
        separator.setMinHeight(600);

        Text label = new Text("MENU");
        label.setFont(Font.font("Helvetica", FontWeight.BOLD, 30));
        label.setFill(Color.ORANGERED);
        
        
        Image home = new Image("images/home.png");
        ImageView homeImage = new ImageView(home);
        homeImage.setFitWidth(50);
        homeImage.setPreserveRatio(true);
        Button homeButton = new Button();
        homeButton.setText("Home");
        homeButton.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
        homeButton.setGraphic(homeImage);
        homeButton.setStyle("-fx-background-color: transparent;");
        homeButton.setCursor(Cursor.HAND);
        

        // Menu Button 
        Image menuViewImage = new Image("images/menu.png");
        ImageView menuImage = new ImageView(menuViewImage);
        menuImage.setFitWidth(40);
        menuImage.setPreserveRatio(true);
        Button menuButton = new Button();
        menuButton.setGraphic(menuImage);
        menuButton.setStyle("-fx-background-color: transparent;");
        menuButton.setText("Menu");
        menuButton.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
        menuButton.setCursor(Cursor.HAND);

        // Cart button
        Image cartViewImage = new Image("images/cart.png");
        ImageView cartImage = new ImageView(cartViewImage);
        cartImage.setFitWidth(50);
        cartImage.setPreserveRatio(true);
        Button cartButton = new Button();
        cartButton.setGraphic(cartImage);
        cartButton.setText("Cart");
        cartButton.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
        cartButton.setStyle("-fx-background-color: transparent;");
        cartButton.setCursor(Cursor.HAND);
        
        // TABLE RESERVATION
        Image tabkeViewImage = new Image("images/table.png");
        ImageView tableView = new ImageView(tabkeViewImage);
        tableView.setFitWidth(50);
        tableView.setPreserveRatio(true);
        Button tableResButton = new Button();
        tableResButton.setGraphic(tableView);
        tableResButton.setText("Table\nReservation");
        tableResButton.setFont(Font.font("Helvetica", FontWeight.BOLD, 15));
        tableResButton.setStyle("-fx-background-color: transparent;");
        tableResButton.setCursor(Cursor.HAND);
        tableResButton.setTextAlignment(TextAlignment.CENTER);

        // LOGOUT BUTTON
        Image image2 = new Image("images/logout.png");
        ImageView imageView2 = new ImageView(image2);
        imageView2.setFitWidth(150);
        imageView2.setPreserveRatio(true);
        Button logoutButton = new Button();
        logoutButton.setGraphic(imageView2);
        logoutButton.setStyle("-fx-background-color: transparent;");
        logoutButton.setCursor(Cursor.HAND);

        AnchorPane a1 = new AnchorPane(separator,homeButton,menuButton,cartButton,logoutButton,tableResButton,label);

        AnchorPane.setLeftAnchor(separator, 200.0);
        AnchorPane.setRightAnchor(separator, 600.0);

        AnchorPane.setTopAnchor(homeButton, 20.0);
        AnchorPane.setLeftAnchor(homeButton, 0.0);
        AnchorPane.setRightAnchor(homeButton, 630.0);

        AnchorPane.setLeftAnchor(menuButton, 0.0);
        AnchorPane.setRightAnchor(menuButton, 630.0);
        AnchorPane.setTopAnchor(menuButton, 80.0);

        AnchorPane.setLeftAnchor(cartButton, 15.0);
        // AnchorPane.setRightAnchor(cartButton, 630.0);
        AnchorPane.setTopAnchor(cartButton, 130.0);

        AnchorPane.setLeftAnchor(logoutButton, 30.0);
        AnchorPane.setBottomAnchor(logoutButton, 5.0);


        AnchorPane.setLeftAnchor(tableResButton, 0.0);
        AnchorPane.setRightAnchor(tableResButton, 630.0);
        AnchorPane.setTopAnchor(tableResButton, 200.0);
        // AnchorPane.setBottomAnchor(tableResButton, 30.0);

        
        AnchorPane.setLeftAnchor(label, 430.0);
        AnchorPane.setTopAnchor(label, 20.0);
        AnchorPane.setBottomAnchor(label, 400.0);

        logoutButton.setOnAction(new EventHandler<ActionEvent>() {

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

        menuButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Menu menu = new Menu();

                try {
                    menu.start(homePage);
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
                    
                    e.printStackTrace();
                }
                
            }
            
        });

        
        homeButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                HomePage home = new HomePage();

                try {
                    home.start(homePage);
                } catch (Exception e) {
                    
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
