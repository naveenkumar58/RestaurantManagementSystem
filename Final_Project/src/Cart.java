import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
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
        
        Button homeButton = new Button("Home");
        Button menuButton = new Button("Menu");
        Button cartButton = new Button("Cart");
        Button logOutButton = new Button("Log Out");
        Button tableResButton = new Button("Table\nReservation");
        tableResButton.setTextAlignment(TextAlignment.CENTER);
        Button clearAllBut = new Button("Clear All");
        Button clearBut = new Button("Clear");
        Button placeOrderButton = new Button("Place Order");

        Label paymentLabel = new Label("GRAND TOTAL");

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
        AnchorPane a1 = new AnchorPane(separator,menuButton,cartButton,homeButton,logOutButton,tableResButton,cartTable,clearAllBut,clearBut,placeOrderButton,paymentLabel);

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

        AnchorPane.setLeftAnchor(cartTable, 200.0);
        AnchorPane.setRightAnchor(cartTable, 0.0);
        AnchorPane.setTopAnchor(cartTable, 80.0);
        AnchorPane.setBottomAnchor(cartTable, 150.0);

        AnchorPane.setLeftAnchor(clearAllBut, 220.0);
        AnchorPane.setRightAnchor(clearAllBut, 500.0);
        AnchorPane.setTopAnchor(clearAllBut, 460.0);
        AnchorPane.setBottomAnchor(clearAllBut, 110.0);

        AnchorPane.setLeftAnchor(clearBut, 320.0);
        AnchorPane.setRightAnchor(clearBut, 400.0);
        AnchorPane.setTopAnchor(clearBut, 460.0);
        AnchorPane.setBottomAnchor(clearBut, 110.0);

        AnchorPane.setLeftAnchor(placeOrderButton, 690.0);
        AnchorPane.setRightAnchor(placeOrderButton, 30.0);
        AnchorPane.setTopAnchor(placeOrderButton, 460.0);
        AnchorPane.setBottomAnchor(placeOrderButton, 110.0);

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
        // naveen learning branch created
        CartPageScene = new Scene(a1,800,600);
        cartPage.setResizable(false);
        cartPage.setScene(CartPageScene);
        cartPage.show();

    }
}
