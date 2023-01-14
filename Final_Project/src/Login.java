import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Login extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    Scene LoginScene;
    Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;

        Text headingText = new Text("Sign In Form");

        Label emaiLabel = new Label("Email Address");
        TextField emailField = new TextField();
        emailField.setPromptText("Email Address");
        emailField.setMinWidth(200);

        Label passLabel = new Label("Password");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        passwordField.setMinWidth(200);

        Button LoginButton = new Button("Login");
        Button signButton = new Button("Create An Account");

        GridPane logGridPane = new GridPane();
        logGridPane.setAlignment(Pos.CENTER);
        // logGridPane.add(headingText, 0, 0);
        logGridPane.setHgap(10);
        logGridPane.setVgap(10);
        logGridPane.setPadding(new Insets(25, 25, 25, 25));
        logGridPane.add(emaiLabel, 1, 1);
        logGridPane.add(emailField, 1, 2);
        logGridPane.add(passLabel, 2, 1);
        logGridPane.add(passwordField, 2, 2);
        logGridPane.add(LoginButton, 2, 3);
        logGridPane.add(signButton, 2, 3);
        logGridPane.setMargin(signButton, new Insets(0, 0, 0, 100));

        signButton.setOnAction(new EventHandler<ActionEvent>() {

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

        LoginScene = new Scene(logGridPane, 600, 600);

        stage.setScene(LoginScene);
        stage.show();
    }
}
