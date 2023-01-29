import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.lang.model.util.ElementScanner6;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class AdminPanel extends Application {

    Stage adminStage;
    Scene adminScene;
    Products ProductObj;
    TextField p_text, price_text;
    String productsFile = "products.txt";
    Filing product;
    ObservableList<Products> itemList;
    public static TableView<Products> menu_items;

    public void addProducts() {
        menu_items = new TableView<>();
        // adding items to table view
        TableColumn<Products, String> itemNameColumn = new TableColumn<>("Product Name");
        itemNameColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));

        TableColumn<Products, String> itemPriceColumn = new TableColumn<>("Product price");
        itemPriceColumn.setCellValueFactory(new PropertyValueFactory<>("productPrice"));

        itemList = FXCollections.observableArrayList();

        try {
            BufferedReader reader;
            reader = new BufferedReader(new FileReader(productsFile));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                itemList.add(new Products(parts[0], parts[1]));
            }

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        menu_items.setItems(itemList);
        menu_items.getColumns().addAll(itemNameColumn, itemPriceColumn);
    }

    public void CheckproductExist() {
        if (product.isExists(p_text.getText(), productsFile)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Product already exists!");
            alert.show();

        } else {
            product.addProducts(addProductDetails().toString(), productsFile);
            Alert addAlert = new Alert(Alert.AlertType.INFORMATION);
            addAlert.setContentText("Item Added Successfully!");
            addAlert.show();
            itemList.add(new Products(p_text.getText(), price_text.getText()));
            p_text.clear();
            price_text.clear();
        }
    }

    public Products addProductDetails() {
        ProductObj.setProductName(p_text.getText());
        ProductObj.setProductPrice(price_text.getText());
        return ProductObj;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ProductObj = new Products();
        product = new Filing();
        adminStage = primaryStage;

        Image admin_img = new Image("images/admin.png");
        // Creating the image view
        ImageView imageView = new ImageView();
        // Setting image to the image view
        imageView.setImage(admin_img);
        // Setting the image view parameters
        imageView.setX(10);
        imageView.setY(10);
        imageView.setFitWidth(100);
        imageView.setPreserveRatio(true);
        Label adminLabel = new Label("Admin");
        adminLabel.setFont(Font.font("Helvetica", FontWeight.BOLD, 30));
        adminLabel.setTextFill(Color.WHITE);

        Label p_name = new Label("Product Name");
        p_text = new TextField();
        p_text.setStyle("-fx-background-radius: 10px;");
        p_name.setFont(Font.font("Helvetica", FontWeight.BOLD, 12));

        Label p_price = new Label("Product Price");
        p_price.setFont(Font.font("Helvetica", FontWeight.BOLD, 12));
        price_text = new TextField();
        price_text.setStyle("-fx-background-radius: 10px;");

        Button add_btn = new Button("Add");
        add_btn.setPrefWidth(0);
        add_btn.setStyle("-fx-background-radius: 10px; -fx-background-color: GREEN;");
        add_btn.setFont(Font.font(null, FontWeight.BOLD, 14));
        add_btn.setTextFill(Color.WHITE);
        // add_btn.setPrefWidth(80);
        add_btn.setOnMouseEntered(e -> add_btn.setEffect(new DropShadow()));
        add_btn.setOnMouseExited(e -> add_btn.setEffect(null));

        Button update_btn = new Button("Update");
        update_btn.setPrefWidth(20);
        update_btn.setStyle("-fx-background-radius: 10px; -fx-background-color: BLUE;");
        update_btn.setFont(Font.font(null, FontWeight.BOLD, 14));
        update_btn.setTextFill(Color.WHITE);
        // update_btn.setPrefWidth(80);
        update_btn.setOnMouseEntered(e -> update_btn.setEffect(new DropShadow()));
        update_btn.setOnMouseExited(e -> update_btn.setEffect(null));

        Button dlt_btn = new Button("Delete");
        dlt_btn.setPrefWidth(20);
        dlt_btn.setStyle("-fx-background-radius: 10px; -fx-background-color: RED;");
        dlt_btn.setFont(Font.font(null, FontWeight.BOLD, 14));
        dlt_btn.setTextFill(Color.WHITE);
        // dlt_btn.setPrefWidth(80);
        dlt_btn.setOnMouseEntered(e -> dlt_btn.setEffect(new DropShadow()));
        dlt_btn.setOnMouseExited(e -> dlt_btn.setEffect(null));

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
        logOutButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Login login = new Login();
                try {
                    login.start(adminStage);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                
            }
            
        });

        AnchorPane.setLeftAnchor(logOutButton, 10.0);
        AnchorPane.setBottomAnchor(logOutButton, 40.0);
        AnchorPane.setRightAnchor(logOutButton, 30.0);
        AnchorPane.setTopAnchor(logOutButton, 530.0);
        
        //
        addProducts();

        Separator sep2 = new Separator(Orientation.VERTICAL);
        sep2.setMinHeight(600);

        AnchorPane left_pane = new AnchorPane(imageView, adminLabel,logOutButton);
        left_pane.setStyle("-fx-background-color: #686BFF;");
        AnchorPane right_pane = new AnchorPane(left_pane, p_name, p_text, p_price, price_text, add_btn, dlt_btn, sep2,
                update_btn, menu_items);
        // AnchorPane a1 = new AnchorPane(left_pane, right_pane);

        AnchorPane.setLeftAnchor(left_pane, 0.0);
        AnchorPane.setRightAnchor(left_pane, 600.0);
        AnchorPane.setBottomAnchor(left_pane, 0.0);
        AnchorPane.setTopAnchor(left_pane, 0.0);

        AnchorPane.setLeftAnchor(imageView, 50.0);
        AnchorPane.setBottomAnchor(imageView, 50.0);
        AnchorPane.setTopAnchor(imageView, 20.0);

        AnchorPane.setLeftAnchor(adminLabel, 50.0);
        AnchorPane.setBottomAnchor(adminLabel, 420.0);
        AnchorPane.setTopAnchor(adminLabel, 120.0);

        AnchorPane.setLeftAnchor(sep2, 501.0);
        AnchorPane.setRightAnchor(sep2, 300.0);
        AnchorPane.setBottomAnchor(sep2, 0.0);
        AnchorPane.setTopAnchor(sep2, 0.0);

        AnchorPane.setLeftAnchor(menu_items, 200.0);
        AnchorPane.setRightAnchor(menu_items, 300.0);
        AnchorPane.setBottomAnchor(menu_items, 0.0);
        AnchorPane.setTopAnchor(menu_items, 100.0);

        AnchorPane.setLeftAnchor(p_name, 540.0);
        AnchorPane.setTopAnchor(p_name, 100.0);

        AnchorPane.setLeftAnchor(p_text, 540.0);
        AnchorPane.setRightAnchor(p_text, 80.0);
        // AnchorPane.setBottomAnchor(p_text, 0.0);
        AnchorPane.setTopAnchor(p_text, 120.0);

        AnchorPane.setLeftAnchor(p_price, 540.0);
        AnchorPane.setTopAnchor(p_price, 160.0);

        AnchorPane.setLeftAnchor(price_text, 540.0);
        AnchorPane.setRightAnchor(price_text, 80.0);
        // AnchorPane.setBottomAnchor(menu_items, 0.0);
        AnchorPane.setTopAnchor(price_text, 180.0);

        AnchorPane.setLeftAnchor(add_btn, 552.5);
        AnchorPane.setRightAnchor(add_btn, 97.5);
        AnchorPane.setBottomAnchor(add_btn, 300.0);
        AnchorPane.setTopAnchor(add_btn, 250.0);

        AnchorPane.setLeftAnchor(update_btn, 540.0);
        AnchorPane.setRightAnchor(update_btn, 180.0);
        AnchorPane.setBottomAnchor(update_btn, 230.0);
        AnchorPane.setTopAnchor(update_btn, 320.0);

        AnchorPane.setLeftAnchor(dlt_btn, 640.0);
        AnchorPane.setRightAnchor(dlt_btn, 80.0);
        AnchorPane.setBottomAnchor(dlt_btn, 230.0);
        AnchorPane.setTopAnchor(dlt_btn, 320.0);

        add_btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (p_text.getText().equals("") || price_text.getText().equals("")) {
                    Alert fieldAlert = new Alert(Alert.AlertType.ERROR);
                    fieldAlert.setContentText("Fill all the fields");
                    fieldAlert.show();
                } else {
                    CheckproductExist();

                }
            }

        });

        dlt_btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                if (p_text.getText().equals("")) {
                    Alert fieldAlert = new Alert(Alert.AlertType.ERROR);
                    fieldAlert.setContentText("Fill all the fields");
                    fieldAlert.show();

                } else if (product.isExists(p_text.getText(), productsFile) == true) {
                    product.deletProductByName(p_text.getText(), productsFile);

                    Alert delAlert = new Alert(Alert.AlertType.INFORMATION);
                    delAlert.setContentText("Item Deleted Successfully!");

                    delAlert.show();
                    p_text.clear();
                    price_text.clear();
                    try {
                        start(adminStage);
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                } else {
                    Alert productexist = new Alert(AlertType.ERROR);
                    productexist.setContentText("Product does not exist");
                    productexist.show();
                }
            }
        });

        update_btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (p_text.getText().equals("") || price_text.getText().equals("")) {
                    Alert fieldAlert = new Alert(Alert.AlertType.ERROR);
                    fieldAlert.setContentText("Fill all the fields");
                    fieldAlert.show();
                } else if (product.isExists(p_text.getText(), productsFile) == true) {
                    product.updateProduct(p_text.getText(), addProductDetails().toString(), productsFile);
                    Alert updateAlert = new Alert(Alert.AlertType.INFORMATION);
                    updateAlert.setContentText("Item Updated Successfully!");
                    updateAlert.show();
                    p_text.clear();
                    price_text.clear();
                    try {
                        start(adminStage);
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                } else {
                    Alert productexist = new Alert(AlertType.ERROR);
                    productexist.setContentText("Product does not exist");
                    productexist.show();
                }
            }

        });

        adminScene = new Scene(right_pane, 800, 600);
        adminStage.setResizable(false);
        adminStage.setScene(adminScene);
        adminStage.show();

    }

}
