import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Cart extends Application {
    Stage cartPage;
    Scene CartPageScene;

    @Override
    public void start(Stage primaryStage) throws Exception {
        cartPage = primaryStage;
        

        Separator separator = new Separator(Orientation.VERTICAL);
        separator.setMinHeight(600);

        Text cartLabel = new Text("CART");
        cartLabel.setFont(Font.font("Helvetica", FontWeight.BOLD, 30));
        cartLabel.setFill(Color.ORANGERED);

        // HOME BUTTON
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
        Button logOutButton = new Button();
        logOutButton.setGraphic(imageView2);
        logOutButton.setStyle("-fx-background-color: transparent;");
        logOutButton.setCursor(Cursor.HAND);

        // CLEAR ALL BUTTON
        Button clearAllBut = new Button("Clear All");
        clearAllBut.setStyle("-fx-background-radius: 20; -fx-background-color: RED;");
        clearAllBut.setFont(Font.font(null, FontWeight.BOLD, 14));
        clearAllBut.setTextFill(Color.WHITE);
        clearAllBut.setPrefWidth(80);
        clearAllBut.setOnMouseEntered(e -> clearAllBut.setEffect(new DropShadow()));
        clearAllBut.setOnMouseExited(e -> clearAllBut.setEffect(null));

        VBox root = new VBox();
        root.setPadding(new Insets(10));
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(clearAllBut);

        // CLEAR BUTTON
        Button clearBut = new Button("Clear");
        clearBut.setStyle("-fx-background-radius: 20; -fx-background-color: BLUE;");
        clearBut.setFont(Font.font(null, FontWeight.BOLD, 14));
        clearBut.setTextFill(Color.WHITE);
        clearBut.setPrefWidth(80);
        clearBut.setOnMouseEntered(e -> clearBut.setEffect(new DropShadow()));
        clearBut.setOnMouseExited(e -> clearBut.setEffect(null));

        VBox root2 = new VBox();
        root2.setPadding(new Insets(10));
        root2.setSpacing(10);
        root2.setAlignment(Pos.CENTER);
        root2.getChildren().addAll(clearBut,cartLabel);

        // PLACE ORDER BUTTON
        Button placeOrderButton = new Button("Place Order");
        placeOrderButton.setStyle("-fx-background-radius: 20; -fx-background-color: GREEN;");
        placeOrderButton.setFont(Font.font(null, FontWeight.BOLD, 14));
        placeOrderButton.setTextFill(Color.WHITE);
        placeOrderButton.setPrefWidth(80);
        placeOrderButton.setOnMouseEntered(e -> placeOrderButton.setEffect(new DropShadow()));
        placeOrderButton.setOnMouseExited(e -> placeOrderButton.setEffect(null));

        VBox root3 = new VBox();
        root3.setPadding(new Insets(10));
        root3.setSpacing(10);
        root3.setAlignment(Pos.CENTER);
        root3.getChildren().addAll(placeOrderButton);

        // TOTAL LABEL
        Label paymentLabel = new Label("GRAND TOTAL");
        paymentLabel.setFont(Font.font(null, FontWeight.BOLD, 16));

        TableView cartTable = new TableView<>();
        // cartTable.setEditable(true);
        // TableView<String> itemNameColumn = new TableView<>();
        // cartTable.getColumns().add(itemNameColumn);
        // TableView<String> costColumn = new TableView<>();
        // TableView<String> quantityColumn = new TableView<>();
        // TableView addColumn = new TableView<>();
        // TableView substractColumn = new TableView<>();
        // TableColumn<String> itemNameColumn = new TableColumn("Item Name");
        // itemNameColumn.setCellValueFactory(new PropertyValueFactory<>("itemname"));
        // TableColumn<String> costColumn = new TableColumn("Cost");
        // costColumn.setCellValueFactory(new PropertyValueFactory<>("cost"));
        // TableColumn< String> quantityColumn = new TableColumn("Quantity");
        // quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        // TableColumn<String> addColumn = new TableColumn("");
        // addColumn.setCellValueFactory(new PropertyValueFactory<>(""));
        // TableColumn<String> substractColumn = new TableColumn("");
        // substractColumn.setCellValueFactory(new PropertyValueFactory<>(""));
        // cartTable.getColumns().addAll(itemNameColumn,costColumn,quantityColumn,addColumn,substractColumn);

        GridPane homeGrid = new GridPane();
        ScrollPane scroll = new ScrollPane();
        // Pane sidePane = new Pane();
        // sidePane.setPrefSize(200, 600);
        AnchorPane a1 = new AnchorPane(separator, menuButton, cartButton, homeButton, logOutButton, tableResButton,
                cartTable, clearAllBut, clearBut, placeOrderButton, paymentLabel,cartLabel);

        // AnchorPane.setRightAnchor(sidePane, 400.0);
        // sidePane.setBackground(new Background(new BackgroundFill(Color.RED,
        // CornerRadii.EMPTY, Insets.EMPTY)));

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

        AnchorPane.setLeftAnchor(logOutButton, 30.0);
        AnchorPane.setBottomAnchor(logOutButton, 5.0);

        AnchorPane.setLeftAnchor(tableResButton, 0.0);
        AnchorPane.setRightAnchor(tableResButton, 630.0);
        AnchorPane.setTopAnchor(tableResButton, 200.0);

        AnchorPane.setLeftAnchor(cartTable, 200.0);
        AnchorPane.setRightAnchor(cartTable, 0.0);
        AnchorPane.setTopAnchor(cartTable, 80.0);
        AnchorPane.setBottomAnchor(cartTable, 150.0);

        AnchorPane.setLeftAnchor(clearAllBut, 220.0);
        // AnchorPane.setRightAnchor(clearAllBut, 500.0);
        AnchorPane.setTopAnchor(clearAllBut, 460.0);
        // AnchorPane.setBottomAnchor(clearAllBut, 110.0);

        AnchorPane.setLeftAnchor(clearBut, 320.0);
        AnchorPane.setRightAnchor(clearBut, 400.0);
        AnchorPane.setTopAnchor(clearBut, 460.0);
        AnchorPane.setBottomAnchor(clearBut, 110.0);

        
        AnchorPane.setLeftAnchor(cartLabel, 450.0);
        AnchorPane.setRightAnchor(cartLabel, 400.0);
        AnchorPane.setTopAnchor(cartLabel, 20.0);
        AnchorPane.setBottomAnchor(cartLabel, 110.0);

        AnchorPane.setLeftAnchor(placeOrderButton, 600.0);
        AnchorPane.setRightAnchor(placeOrderButton, 30.0);
        AnchorPane.setTopAnchor(placeOrderButton, 460.0);
        // AnchorPane.setBottomAnchor(placeOrderButton, 110.0);

        AnchorPane.setLeftAnchor(paymentLabel, 610.0);
        // AnchorPane.setRightAnchor(paymentLabel, 30.0);
        AnchorPane.setTopAnchor(paymentLabel, 500.0);
        AnchorPane.setBottomAnchor(paymentLabel, 70.0);

        scroll.vbarPolicyProperty().setValue(ScrollPane.ScrollBarPolicy.ALWAYS);

        logOutButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Login login = new Login();

                try {
                    login.start(cartPage);
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
                    menu.start(cartPage);
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
                    cart.start(cartPage);
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
                    home.start(cartPage);
                } catch (Exception e) {
                    
                    e.printStackTrace();
                }
                
            }
            
        });
        // naveen learning branch created
        CartPageScene = new Scene(a1, 800, 600);
        cartPage.setResizable(false);
        cartPage.setScene(CartPageScene);
        cartPage.show();

    }
}
