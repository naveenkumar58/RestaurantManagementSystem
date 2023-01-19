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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
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

        Label emaiLabel = new Label("Email Address");
        TextField emailField = new TextField();
        emailField.setPromptText("Email Address");
        emailField.setMinWidth(200);

        Label passLabel = new Label("Password");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        passwordField.setMinWidth(200);
        CheckBox showPass = new CheckBox("Show Password");
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
        LoginButton.setCursor(Cursor.HAND);
        LoginButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Authentication auth = new Authentication();
                auth.signIn(emailField.getText(), passwordField.getText());
            }
        });

        Button signUpButton = new Button("Sign Up");
        signUpButton.setCursor(Cursor.HAND);
        signUpButton.setStyle("-fx-background-color: transparent;");

        Label askSignup = new Label("Don't have an account?");

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

        AnchorPane loginAnchorPane = new AnchorPane(logGridPane, LoginButton, askSignup, signUpButton);

        AnchorPane.setLeftAnchor(loginAnchorPane, 0.0);
        AnchorPane.setRightAnchor(loginAnchorPane, 0.0);
        AnchorPane.setTopAnchor(loginAnchorPane, 0.0);
        AnchorPane.setBottomAnchor(loginAnchorPane, 0.0);

        AnchorPane.setLeftAnchor(logGridPane, 0.0);
        AnchorPane.setRightAnchor(logGridPane, 0.0);
        AnchorPane.setTopAnchor(logGridPane, 0.0);
        AnchorPane.setBottomAnchor(logGridPane, 0.0);

        AnchorPane.setLeftAnchor(LoginButton, 370.0);
        AnchorPane.setRightAnchor(LoginButton, 300.0);
        AnchorPane.setTopAnchor(LoginButton, 370.0);
        AnchorPane.setBottomAnchor(LoginButton, 200.0);

        AnchorPane.setLeftAnchor(askSignup, 370.0);
        AnchorPane.setTopAnchor(askSignup, 450.0);

        AnchorPane.setLeftAnchor(signUpButton, 495.0);
        AnchorPane.setRightAnchor(signUpButton, 245.0);
        AnchorPane.setTopAnchor(signUpButton, 445.0);
        AnchorPane.setBottomAnchor(signUpButton, 126.0);

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
                HomePage homePage = new HomePage();

                try {
                    homePage.start(stage);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        });

        LoginScene = new Scene(loginAnchorPane, 800, 600);
        stage.setResizable(false);
        stage.setScene(LoginScene);
        stage.show();
    }
}
