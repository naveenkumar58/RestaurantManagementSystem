import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class TableReservation extends Application {

    Stage TableReservation;
    Scene TableReservationScene;
    Filing fl;
    String file = "Table Reservation.txt";

    @Override
    public void start(Stage primaryStage) throws Exception {

        TableReservation = primaryStage;

        primaryStage.setTitle("Table Reservation");

        Separator separator = new Separator(Orientation.VERTICAL);
        separator.setMinHeight(600);

        Text label = new Text("TABLE RESERVATION");
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

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Label nameLabel = new Label("Name:");
        nameLabel.setFont(Font.font("Helvetica", FontWeight.BOLD, 16));
        nameLabel.setTextFill(Color.BLACK);
        grid.add(nameLabel, 0, 1);

        TextField nameField = new TextField();
        nameField.setStyle("-fx-background-radius: 20;");
        grid.add(nameField, 1, 1);

        Label phoneLabel = new Label("Phone No:");
        phoneLabel.setFont(Font.font("Helvetica", FontWeight.BOLD, 16));
        phoneLabel.setTextFill(Color.BLACK);
        grid.add(phoneLabel, 0, 2);

        TextField phoneField = new TextField();
        phoneField.setStyle("-fx-background-radius: 20;");
        grid.add(phoneField, 1, 2);

        Label dateLabel = new Label("Date:");
        dateLabel.setFont(Font.font("Helvetica", FontWeight.BOLD, 16));
        dateLabel.setTextFill(Color.BLACK);
        grid.add(dateLabel, 0, 3);

        DatePicker datePicker = new DatePicker();
        grid.add(datePicker, 1, 3);

        Label personLabel = new Label("Persons:");
        personLabel.setFont(Font.font("Helvetica", FontWeight.BOLD, 16));
        personLabel.setTextFill(Color.BLACK);
        grid.add(personLabel, 0, 4);

        ComboBox<String> personsBox = new ComboBox<>();
        personsBox.setStyle("-fx-background-radius: 20;");
        personsBox.setPromptText("Select Persons");
        personsBox.setMaxWidth(250);
        personsBox.getItems().addAll("1", "3", "5", "7", "9", "12");
        grid.add(personsBox, 1, 4);

        Button submitButton = new Button("Submit");
        submitButton.setMaxWidth(200);
        submitButton.setTextFill(Color.WHITE);
        submitButton.setFont(Font.font("Helvetica", FontWeight.BOLD, 14));
        submitButton.setCursor(Cursor.HAND);
        submitButton.setOnMouseEntered(e -> submitButton.setEffect(new DropShadow()));
        submitButton.setOnMouseExited(e -> submitButton.setEffect(null));
        submitButton.setStyle("-fx-background-radius: 20; -fx-background-color: BLUE;");
        grid.add(submitButton, 1, 5);

        submitButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                fl = new Filing();
                if (nameField.getText().equals("") || phoneField.getText().equals("")
                        || datePicker.getValue() == null || personsBox.getValue() == null) {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setContentText("Please Fill All The Fields");
                    alert.show();
                } else {
                    String res = nameField.getText() + "," + phoneField.getText() + "," + datePicker.getValue() + ","
                            + personsBox.getValue();
                    fl.writeData(res, file);
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setContentText("Your table has been reserved");
                    alert.show();
                }

            }

        });

        AnchorPane leftPane = new AnchorPane(homeButton, menuButton, cartButton, logOutButton,
                tableResButton);
        leftPane.setStyle("-fx-background-color: #686BFF;");
        AnchorPane rightPane = new AnchorPane(label, grid);
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

        AnchorPane.setLeftAnchor(label, 150.0);
        AnchorPane.setTopAnchor(label, 40.0);
        AnchorPane.setBottomAnchor(label, 400.0);

        AnchorPane.setLeftAnchor(grid, 10.0);
        AnchorPane.setBottomAnchor(grid, 35.0);
        AnchorPane.setRightAnchor(grid, 30.0);
        AnchorPane.setTopAnchor(grid, 170.0);

        logOutButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Login login = new Login();

                try {
                    login.start(TableReservation);
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
                    menu.start(TableReservation);
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
                    cart.start(TableReservation);
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
                    home.start(TableReservation);
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
                    Table.start(TableReservation);
                } catch (Exception e) {

                    e.printStackTrace();
                }

            }

        });

        TableReservationScene = new Scene(a1, 800, 600);
        TableReservation.setScene(TableReservationScene);
        TableReservation.setResizable(false);
        TableReservation.show();
    }
}
