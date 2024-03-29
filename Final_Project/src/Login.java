import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.PopupWindow.AnchorLocation;

public class Login extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    Scene LoginScene;
    Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;

        new Text("Sign In Form");

        // HOME IMAGE
        Image image = new Image("images/login.png");
        // Creating the image view
        ImageView imageView = new ImageView();
        // Setting image to the image view
        imageView.setImage(image);
        // Setting the image view parameters
        imageView.setX(10);
        imageView.setY(10);
        imageView.setFitWidth(100);
        imageView.setPreserveRatio(true);

        Label emaiLabel = new Label("Email Address");
        emaiLabel.setTextFill(Color.WHITE);
        TextField emailField = new TextField();
        emaiLabel.setFont(Font.font("Helvetica", FontWeight.BOLD, 14));
        emailField.setPromptText("Email Address");
        emailField.setMinWidth(200);

        Label passLabel = new Label("Password");
        passLabel.setTextFill(Color.WHITE);
        PasswordField passwordField = new PasswordField();
        passLabel.setFont(Font.font("Helvetica", FontWeight.BOLD, 14));
        passwordField.setPromptText("Password");
        passwordField.setMinWidth(200);

        CheckBox showPass = new CheckBox("Show Password");
        showPass.setTextFill(Color.WHITE);
        showPass.setFont(Font.font("Helvetica", FontWeight.BOLD, 14));
        TextField passText = new TextField();

        showPass.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (showPass.isSelected()) {
                    passText.setText(passwordField.getText());
                    passText.setVisible(true);
                    passwordField.setVisible(false);
                    return;
                } else {
                    passwordField.setText(passText.getText());
                    passwordField.setVisible(true);
                    passText.setVisible(false);
                }

            }
        });

        Button LoginButton = new Button("Login");
        LoginButton.setPrefSize(40, 20);
        LoginButton.setFont(Font.font("Helvetica", FontWeight.BOLD, 16));
        LoginButton.setTextFill(Color.WHITE);
        LoginButton.setCursor(Cursor.HAND);
        LoginButton.setCursor(Cursor.HAND);
        LoginButton.setOnMouseEntered(e -> LoginButton.setEffect(new DropShadow()));
        LoginButton.setOnMouseExited(e -> LoginButton.setEffect(null));
        LoginButton.setStyle("-fx-background-radius: 20; -fx-background-color: BLUE;");

        Button signUpButton = new Button("Sign Up");
        signUpButton.setTextFill(Color.BLACK);
        signUpButton.setFont(Font.font("Helvetica", FontWeight.BOLD, 14));
        signUpButton.setCursor(Cursor.HAND);
        signUpButton.setStyle("-fx-background-color: transparent;-fx-underline: true;");

        Label askSignup = new Label("Don't have an account?");
        askSignup.setTextFill(Color.WHITE);
        askSignup.setFont(Font.font("Helvetica", FontWeight.BOLD, 14));

        GridPane logGridPane = new GridPane();
        logGridPane.setAlignment(Pos.CENTER);
        logGridPane.setHgap(10);
        logGridPane.setVgap(10);
        logGridPane.setPadding(new Insets(25, 25, 25, 25));
        logGridPane.add(emaiLabel, 1, 1);
        logGridPane.add(emailField, 2, 1);
        logGridPane.add(passLabel, 1, 2);
        logGridPane.add(passText, 2, 2);
        logGridPane.add(passwordField, 2, 2);
        logGridPane.add(showPass, 2, 3);

        AnchorPane loginAnchorPane = new AnchorPane(logGridPane, LoginButton, askSignup, signUpButton, imageView);
        loginAnchorPane.setStyle("-fx-background-color: #686BFF;");

        AnchorPane.setLeftAnchor(loginAnchorPane, 0.0);
        AnchorPane.setRightAnchor(loginAnchorPane, 0.0);
        AnchorPane.setTopAnchor(loginAnchorPane, 0.0);
        AnchorPane.setBottomAnchor(loginAnchorPane, 0.0);

        AnchorPane.setLeftAnchor(logGridPane, 0.0);
        AnchorPane.setRightAnchor(logGridPane, 0.0);
        AnchorPane.setTopAnchor(logGridPane, 0.0);
        AnchorPane.setBottomAnchor(logGridPane, 0.0);

        AnchorPane.setLeftAnchor(imageView, 400.0);
        AnchorPane.setTopAnchor(imageView, 150.0);
        AnchorPane.setBottomAnchor(imageView, 0.0);

        AnchorPane.setLeftAnchor(LoginButton, 390.0);
        AnchorPane.setRightAnchor(LoginButton, 300.0);
        AnchorPane.setBottomAnchor(LoginButton, 200.0);

        AnchorPane.setLeftAnchor(askSignup, 340.0);
        AnchorPane.setTopAnchor(askSignup, 420.0);

        AnchorPane.setLeftAnchor(signUpButton, 495.0);
        AnchorPane.setTopAnchor(signUpButton, 415.0);
        signUpButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                SignUp sign = new SignUp();
                try {

                    sign.start(stage);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });

        LoginButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Boolean correctEmailPassword;
                Authentication auth = new Authentication();
                correctEmailPassword = auth.signIn(emailField.getText(), passwordField.getText());
                if (emailField.getText().equals("admin") && passwordField.getText().equals("admin")) {
                    AdminPanel admin = new AdminPanel();
                    try {
                        admin.start(stage);
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                } else if (correctEmailPassword == true) {
                    HomePage home = new HomePage();
                    try {
                        home.start(stage);
                    } catch (Exception e) {

                        e.printStackTrace();
                    }
                }
            }
        });

        LoginScene = new Scene(loginAnchorPane, 800, 600);
        stage.setResizable(false);
        stage.setScene(LoginScene);
        stage.show();
    }
}
