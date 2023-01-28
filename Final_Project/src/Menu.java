import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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

    Stage menuPage;
    Scene menuPagScene;
    String productsFile = "Products.txt";
    ObservableList<Products> itemsList;
    TableView<Products> itemTable;
    static ObservableList<String> cartItems;
    String cartFile = "Cart.txt";

    public void items() {
        itemTable = new TableView<>();
        // adding items to table view
        TableColumn<Products, String> itemNameColumn = new TableColumn<>("Product Name");
        itemNameColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));

        TableColumn<Products, String> itemPriceColumn = new TableColumn<>("Product price");
        itemPriceColumn.setCellValueFactory(new PropertyValueFactory<>("productPrice"));

        itemsList = FXCollections.observableArrayList();

        try {
            BufferedReader reader;
            reader = new BufferedReader(new FileReader(productsFile));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                itemsList.add(new Products(parts[0], parts[1],1));
            }

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        itemTable.setItems(itemsList);
        itemTable.getColumns().addAll(itemNameColumn, itemPriceColumn);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        menuPage = primaryStage;

        Separator separator = new Separator(Orientation.VERTICAL);
        separator.setMinHeight(600);

        Text label = new Text("Menu");
        label.setFont(Font.font("Helvetica", FontWeight.BOLD, 30));
        label.setFill(Color.web("#686BFF", 1));

        // HOME BUTTON
        Image home = new Image("images/home.png");
        ImageView homeImage = new ImageView(home);
        homeImage.setFitWidth(40);
        homeImage.setPreserveRatio(true);
        Button homeButton = new Button();
        homeButton.setText("Home");
        homeButton.setFont(Font.font("Helvetica", FontWeight.BOLD, 18));
        homeButton.setGraphic(homeImage);
        homeButton.setStyle("-fx-background-color: transparent;");
        homeButton.setTextFill(Color.WHITE);
        homeButton.setCursor(Cursor.HAND);

        // Menu Button
        Image menuViewImage = new Image("images/menu.png");
        ImageView menuImage = new ImageView(menuViewImage);
        menuImage.setFitWidth(40);
        menuImage.setPreserveRatio(true);
        Button menuButton = new Button();
        menuButton.setGraphic(menuImage);
        menuButton.setStyle("-fx-background-color: transparent;");
        menuButton.setText(" Menu");
        menuButton.setFont(Font.font("Helvetica", FontWeight.BOLD, 18));
        menuButton.setTextFill(Color.WHITE);
        menuButton.setCursor(Cursor.HAND);

        // Cart button
        Image cartViewImage = new Image("images/cart.png");
        ImageView cartImage = new ImageView(cartViewImage);
        cartImage.setFitWidth(40);
        cartImage.setPreserveRatio(true);
        Button cartButton = new Button();
        cartButton.setGraphic(cartImage);
        cartButton.setText(" Cart");
        cartButton.setFont(Font.font("Helvetica", FontWeight.BOLD, 18));
        cartButton.setStyle("-fx-background-color: transparent;");
        cartButton.setTextFill(Color.WHITE);
        cartButton.setCursor(Cursor.HAND);
        cartButton.setCursor(Cursor.HAND);

        // TABLE RESERVATION
        Image tabkeViewImage = new Image("images/table.png");
        ImageView tableView = new ImageView(tabkeViewImage);
        tableView.setFitWidth(40);
        tableView.setPreserveRatio(true);
        Button tableResButton = new Button();
        tableResButton.setGraphic(tableView);
        tableResButton.setText("Reservation");
        tableResButton.setFont(Font.font("Helvetica", FontWeight.BOLD, 18));
        tableResButton.setStyle("-fx-background-color: transparent;");
        tableResButton.setCursor(Cursor.HAND);
        tableResButton.setTextFill(Color.WHITE);
        tableResButton.setTextAlignment(TextAlignment.CENTER);

        // LOGOUT BUTTON
        Image image2 = new Image("images/logout.png");
        ImageView imageView2 = new ImageView(image2);
        imageView2.setFitWidth(30);
        imageView2.setPreserveRatio(true);
        Button logOutButton = new Button();
        logOutButton.setText("LOGOUT");
        logOutButton.setGraphic(imageView2);
        logOutButton.setFont(Font.font("Helvetica", FontWeight.BOLD, 16));
        logOutButton.setStyle("-fx-background-color: transparent;");
        logOutButton.setTextFill(Color.WHITE);
        logOutButton.setCursor(Cursor.HAND);

        // Add to cart button
        Button addToCart = new Button("Add to Cart");

        AnchorPane.setLeftAnchor(addToCart, 400.0);
        AnchorPane.setRightAnchor(addToCart, 150.0);
        AnchorPane.setBottomAnchor(addToCart, 50.0);
        AnchorPane.setTopAnchor(addToCart, 490.0);
        // ObservableList carts = FXCollections.observableArrayList();
        cartItems = FXCollections.observableArrayList();
        addToCart.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Filing fl = new Filing();
                // cartItems.add(itemTable.getSelectionModel().getSelectedItems().get(0).toString());
                String cart = itemTable.getSelectionModel().getSelectedItems().get(0).toString();
                fl.writeData(cart, cartFile);
                // cartItems.add(itemTable.getSelectionModel().getSelectedItems());
                System.out.println(cartItems);
            }

        });

        // Adding Table of items
        this.items();

        AnchorPane leftPane = new AnchorPane(homeButton, menuButton, cartButton, logOutButton,
                tableResButton);
        leftPane.setStyle("-fx-background-color: #686BFF;");
        AnchorPane rightPane = new AnchorPane(label, itemTable, addToCart);
        AnchorPane a1 = new AnchorPane(leftPane, rightPane, separator);

        AnchorPane.setLeftAnchor(itemTable, 0.0);
        AnchorPane.setRightAnchor(itemTable, 0.0);
        AnchorPane.setBottomAnchor(itemTable, 100.0);
        AnchorPane.setTopAnchor(itemTable, 100.0);

        AnchorPane.setLeftAnchor(leftPane, 0.0);
        AnchorPane.setRightAnchor(leftPane, 600.0);
        AnchorPane.setBottomAnchor(leftPane, 0.0);

        AnchorPane.setLeftAnchor(rightPane, 200.0);
        AnchorPane.setRightAnchor(rightPane, 0.0);

        AnchorPane.setLeftAnchor(separator, 200.0);
        AnchorPane.setRightAnchor(separator, 600.0);

        AnchorPane.setTopAnchor(homeButton, 40.0);
        AnchorPane.setLeftAnchor(homeButton, 10.0);
        AnchorPane.setRightAnchor(homeButton, 30.0);

        AnchorPane.setLeftAnchor(menuButton, 20.0);
        AnchorPane.setTopAnchor(menuButton, 100.0);

        AnchorPane.setLeftAnchor(cartButton, 20.0);
        AnchorPane.setTopAnchor(cartButton, 160.0);

        AnchorPane.setLeftAnchor(logOutButton, 10.0);
        AnchorPane.setBottomAnchor(logOutButton, 35.0);
        AnchorPane.setRightAnchor(logOutButton, 30.0);
        AnchorPane.setTopAnchor(logOutButton, 540.0);

        AnchorPane.setLeftAnchor(tableResButton, 10.0);
        AnchorPane.setTopAnchor(tableResButton, 230.0);

        AnchorPane.setLeftAnchor(label, 250.0);
        AnchorPane.setTopAnchor(label, 20.0);
        AnchorPane.setBottomAnchor(label, 400.0);
        logOutButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Login login = new Login();

                try {
                    login.start(menuPage);
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
                    menu.start(menuPage);
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
                    cart.start(menuPage);
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
                    home.start(menuPage);
                } catch (Exception e) {

                    e.printStackTrace();
                }

            }

        });
        tableResButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                TableReservation Table = new TableReservation();

                try {
                    Table.start(menuPage);
                } catch (Exception e) {

                    e.printStackTrace();
                }

            }

        });

        menuPagScene = new Scene(a1, 800, 600);
        menuPage.setTitle("Home Page");
        menuPage.setResizable(false);
        menuPage.setScene(menuPagScene);
        menuPage.show();
    }

    public static ObservableList<String> test() {
        return cartItems;
    }
}