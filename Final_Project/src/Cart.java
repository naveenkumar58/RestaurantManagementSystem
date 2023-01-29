import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Optional;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
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
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.PopupWindow.AnchorLocation;
import javafx.util.Callback;

public class Cart extends Application {

    Stage cartPage;
    Scene CartPageScene;
    TableView<Products> cartTable;
    String productsFile = "Cart.txt";
    Menu cart;
    ObservableList<Products> itemsList;
    Integer total = 0;
    Products products;
    Label price;

    public Products addProductDetails(String pname, String pprice, Integer pqty) {
        products.setProductName(pname);
        products.setProductPrice(pprice);
        products.setProductQty(pqty);
        return products;
    }

    public void delivery() {
        Filing fl = new Filing();
        Dialog<ButtonType> dialog = new Dialog<>();
        ButtonType type = new ButtonType("Delivery", ButtonData.OTHER);
        ButtonType type2 = new ButtonType("Take Away", ButtonData.OTHER);
        // Setting the content of the dialog
        dialog.setContentText("Delivery or Take Away?");
        // Adding buttons to the dialog pane
        dialog.getDialogPane().getButtonTypes().addAll(type, type2);
        dialog.showAndWait().ifPresent(response -> {
            if (response == type) {
                Delivery del = new Delivery();
                fl.deleteProductFile(productsFile);
                total = 0;
                try {
                    start(cartPage);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                try {
                    del.start(new Stage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                fl.deleteProductFile(productsFile);
                total = 0;
                try {
                    start(cartPage);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setContentText("Your Order Has Been Placed!");
                alert.show();
            }
        });
    }

    public void items() {
        cartTable = new TableView<>();
        // adding items to table view
        TableColumn<Products, String> itemNameColumn = new TableColumn<>("Product Name");
        itemNameColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));

        TableColumn<Products, String> itemPriceColumn = new TableColumn<>("Product price");
        itemPriceColumn.setCellValueFactory(new PropertyValueFactory<>("productPrice"));

        TableColumn<Products, String> itemQtyColumn = new TableColumn<>("Product Quantity");
        itemQtyColumn.setCellValueFactory(new PropertyValueFactory<>("productQty"));

        TableColumn plus = new TableColumn("");
        plus.setCellValueFactory(new PropertyValueFactory<>("plus"));

        TableColumn minus = new TableColumn("");
        minus.setCellValueFactory(new PropertyValueFactory<>("minus"));

        Callback<TableColumn<Products, String>, TableCell<Products, String>> cellPlusFactory = //
                new Callback<TableColumn<Products, String>, TableCell<Products, String>>() {
                    @Override
                    public TableCell call(final TableColumn<Products, String> param) {
                        final TableCell<Products, String> cell = new TableCell<Products, String>() {

                            final Button btn = new Button("+");

                            @Override
                            public void updateItem(String item, boolean empty) {
                                super.updateItem(item, empty);
                                if (empty) {
                                    setGraphic(null);
                                    setText(null);
                                } else {
                                    btn.setOnAction(event -> {
                                        Products productstemp = getTableView().getItems().get(getIndex());
                                        Filing file = new Filing();
                                        Integer qtyTemp = productstemp.getProductQty() + 1;
                                        // total = total + (Integer.valueOf(productstemp.getProductPrice()) * qtyTemp);
                                        productstemp.setProductQty(qtyTemp);
                                        file.updateProduct(productstemp.getProductName(),
                                                productstemp.toString(),
                                                "Cart.txt");
                                        total = total + (Integer.valueOf(productstemp.getProductPrice()) * 1);
                                        cartTable.refresh();
                                        price.setText(total.toString());

                                    });
                                    setGraphic(btn);
                                    setText(null);
                                }
                            }
                        };
                        return cell;
                    }
                };

        Callback<TableColumn<Products, String>, TableCell<Products, String>> cellMinusFactory = new Callback<TableColumn<Products, String>, TableCell<Products, String>>() {
            @Override
            public TableCell call(final TableColumn<Products, String> param) {
                final TableCell<Products, String> cell = new TableCell<Products, String>() {

                    final Button btn = new Button("-");

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                            setText(null);
                        } else {
                            btn.setOnAction(event -> {
                                Products productstemp = getTableView().getItems().get(getIndex());
                                Filing file = new Filing();
                                if (productstemp.getProductQty() > 1) {
                                    Integer qtyTemp = productstemp.getProductQty() - 1;
                                    // total = total + (Integer.valueOf(productstemp.getProductPrice()) * qtyTemp);
                                    productstemp.setProductQty(qtyTemp);
                                    file.updateProduct(productstemp.getProductName(), productstemp.toString(),
                                            "Cart.txt");
                                    total = total - Integer.valueOf(productstemp.getProductPrice());
                                    cartTable.refresh();
                                    price.setText(total.toString());
                                } else {
                                    Alert alert = new Alert(AlertType.ERROR);
                                    alert.setContentText("Quantity cannot be less than 1");
                                    alert.show();
                                }
                            });
                            setGraphic(btn);
                            setText(null);
                        }
                    }
                };
                return cell;
            }
        };
        plus.setCellFactory(cellPlusFactory);
        minus.setCellFactory(cellMinusFactory);

        itemsList = FXCollections.observableArrayList();

        try {
            BufferedReader reader;
            reader = new BufferedReader(new FileReader(productsFile));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                total = total + (Integer.valueOf(parts[1]) * Integer.valueOf(parts[2]));
                itemsList.add(new Products(parts[0], parts[1], Integer.valueOf(parts[2])));
            }

            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        cartTable.setItems(itemsList);
        cartTable.getColumns().addAll(itemNameColumn, itemPriceColumn, itemQtyColumn, plus, minus);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        cartPage = primaryStage;

        Separator separator = new Separator(Orientation.VERTICAL);
        separator.setMinHeight(600);

        Text cartLabel = new Text("CART");
        cartLabel.setFont(Font.font("Helvetica", FontWeight.BOLD, 30));
        cartLabel.setFill(Color.web("#686BFF", 1));

        items();

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

        // CLEAR ALL BUTTON
        Button clearAllBut = new Button("Clear All");
        clearAllBut.setStyle("-fx-background-radius: 20; -fx-background-color: RED;");
        clearAllBut.setFont(Font.font(null, FontWeight.BOLD, 14));
        clearAllBut.setTextFill(Color.WHITE);
        clearAllBut.setPrefWidth(80);
        clearAllBut.setOnMouseEntered(e -> clearAllBut.setEffect(new DropShadow()));
        clearAllBut.setOnMouseExited(e -> clearAllBut.setEffect(null));
        clearAllBut.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                // TODO Auto-generated method stub
                Filing f = new Filing();
                f.deleteProductFile(productsFile);
                try {
                    start(cartPage);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                total = 0;
                price.setText(total.toString());

            }

        });

        // CLEAR BUTTON
        Button clearBut = new Button("Clear");
        clearBut.setStyle("-fx-background-radius: 20; -fx-background-color: BLUE;");
        clearBut.setFont(Font.font(null, FontWeight.BOLD, 14));
        clearBut.setTextFill(Color.WHITE);
        clearBut.setOnMouseEntered(e -> clearBut.setEffect(new DropShadow()));
        clearBut.setOnMouseExited(e -> clearBut.setEffect(null));
        clearBut.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                // TODO Auto-generated method stub
                Filing f = new Filing();
                String item = cartTable.getSelectionModel().getSelectedItem().toString();
                f.deletProductByName(item, productsFile);
                total = 0;
                try {
                    start(cartPage);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

        });

        // PLACE ORDER BUTTON
        Button placeOrderButton = new Button("Place Order");
        placeOrderButton.setStyle("-fx-background-radius: 20; -fx-background-color: GREEN;");
        placeOrderButton.setFont(Font.font(null, FontWeight.BOLD, 14));
        placeOrderButton.setTextFill(Color.WHITE);
        placeOrderButton.setPrefWidth(80);
        placeOrderButton.setOnMouseEntered(e -> placeOrderButton.setEffect(new DropShadow()));
        placeOrderButton.setOnMouseExited(e -> placeOrderButton.setEffect(null));
        placeOrderButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                delivery();
            }
        });

        // TOTAL LABEL
        Label paymentLabel = new Label("GRAND TOTAL");
        paymentLabel.setFont(Font.font(null, FontWeight.BOLD, 16));

        price = new Label(total.toString());
        price.setFont(Font.font(null, FontWeight.BOLD, 16));

        AnchorPane leftPane = new AnchorPane(separator, menuButton, cartButton, homeButton, logOutButton,
                tableResButton);
        AnchorPane rightPane = new AnchorPane(cartTable, clearAllBut, clearBut, placeOrderButton,
                paymentLabel, cartLabel, price);
        leftPane.setStyle("-fx-background-color: #686BFF;");
        AnchorPane a1 = new AnchorPane(leftPane, rightPane, separator);

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

        AnchorPane.setLeftAnchor(cartTable, 0.0);
        AnchorPane.setRightAnchor(cartTable, 0.0);
        AnchorPane.setTopAnchor(cartTable, 80.0);
        AnchorPane.setBottomAnchor(cartTable, 150.0);

        AnchorPane.setLeftAnchor(clearAllBut, 160.0);
        AnchorPane.setRightAnchor(clearAllBut, 310.0);
        AnchorPane.setTopAnchor(clearAllBut, 500.0);
        AnchorPane.setBottomAnchor(clearAllBut, 110.0);

        AnchorPane.setLeftAnchor(clearBut, 10.0);
        AnchorPane.setRightAnchor(clearBut, 450.0);
        AnchorPane.setTopAnchor(clearBut, 500.0);
        AnchorPane.setBottomAnchor(clearBut, 110.0);

        AnchorPane.setLeftAnchor(cartLabel, 270.0);
        AnchorPane.setTopAnchor(cartLabel, 20.0);
        AnchorPane.setBottomAnchor(cartLabel, 110.0);

        AnchorPane.setLeftAnchor(placeOrderButton, 410.0);
        AnchorPane.setRightAnchor(placeOrderButton, 30.0);
        AnchorPane.setTopAnchor(placeOrderButton, 500.0);
        AnchorPane.setBottomAnchor(placeOrderButton, 110.0);

        AnchorPane.setLeftAnchor(paymentLabel, 350.0);
        AnchorPane.setTopAnchor(paymentLabel, 530.0);
        AnchorPane.setBottomAnchor(paymentLabel, 70.0);

        AnchorPane.setLeftAnchor(price, 520.0);
        AnchorPane.setTopAnchor(price, 530.0);
        AnchorPane.setBottomAnchor(price, 70.0);

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
        tableResButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                TableReservation Table = new TableReservation();

                try {
                    Table.start(cartPage);
                } catch (Exception e) {

                    e.printStackTrace();
                }

            }

        });

        CartPageScene = new Scene(a1, 800, 600);
        cartPage.setResizable(false);
        cartPage.setScene(CartPageScene);
        cartPage.show();

    }
}
