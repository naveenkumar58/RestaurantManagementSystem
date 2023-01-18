import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SignUp extends Application {


    Scene signUp;
    Stage signUpstage;

    @Override
    public void start(Stage primaryStage) throws Exception {

        ScrollPane scrollPane = new ScrollPane();

        signUpstage = primaryStage;
        Label firstName = new Label("Name");
        TextField firstnameField = new TextField();

        Label lastName = new Label("Last Name");
        TextField lastNameField = new TextField();

        Label emailLabel = new Label("Email Address");
        TextField emailField = new TextField();

        Label passLabel = new Label("Password");
        PasswordField passwordField = new PasswordField();

        Label gender = new Label("Gender");
        ToggleGroup rbToggle = new ToggleGroup();
        RadioButton maleRadioButton = new RadioButton("Male");
        RadioButton femaleRadioButton = new RadioButton("Female");
        maleRadioButton.setToggleGroup(rbToggle);
        femaleRadioButton.setToggleGroup(rbToggle);

        Label dobLabel = new Label("Date Of Birth");
        DatePicker dobDatePicker = new DatePicker();

        Button signUpButton = new Button("Sign Up");
        Button cancelButton = new Button("Cancel");

        GridPane signUpPane = new GridPane();
        signUpPane.setAlignment(Pos.CENTER);
        signUpPane.setHgap(10);
        signUpPane.setVgap(10);
        signUpPane.add(firstName, 1, 1);
        signUpPane.add(firstnameField, 1, 2);
        signUpPane.add(lastName, 2, 1);
        signUpPane.add(lastNameField, 2, 2);
        signUpPane.add(emailLabel, 1, 3);
        signUpPane.add(emailField, 1, 4);
        signUpPane.add(dobLabel, 2, 3);
        signUpPane.add(dobDatePicker, 2, 4);
        signUpPane.add(gender, 1, 5);
        signUpPane.add(maleRadioButton, 1, 6);
        signUpPane.add(femaleRadioButton, 1, 6);
        signUpPane.setMargin(femaleRadioButton, new Insets(0, 0, 0, 80));
        signUpPane.add(passLabel, 2, 5);
        signUpPane.add(passwordField, 2, 6);
        signUpPane.add(signUpButton, 2, 7);
        signUpPane.add(cancelButton, 2, 7);
        signUpPane.setMargin(cancelButton, new Insets(0, 0, 0, 80));

        cancelButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Login login = new Login();

                try {
                    login.start(signUpstage);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        });

        signUpButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                HomePage homePage = new HomePage();

                try {
                    homePage.start(signUpstage);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                
            }
            
        });

        // signUpButton.setOnAction(new EventHandler<ActionEvent>() {

        //     @Override
        //     public void handle(ActionEvent event) {
               
        //         Dialog<ButtonType> dialog = new Dialog<>();
        //         dialog.initModality(Modality.APPLICATION_MODAL);
        //         dialog.setTitle("Sign Up Successful");
        //         Button signInButton = new Button("Sign In");
        //         dialog.getDialogPane().setContent(signInButton);
        //         dialog.showAndWait();

        //         signInButton.setOnAction(new EventHandler<ActionEvent>() {

        //             @Override
        //             public void handle(ActionEvent event) {
        //                 Login login = new Login();
        //                 dialog.close();

        //                 try {
        //                     login.start(signUpstage);
        //                 } catch (Exception e) {
        //                     e.printStackTrace();
        //                 }

        //             }

        //         });
        //     }

        // });

        signUp = new Scene(signUpPane, 800, 600);
        // signUp = new Scene(scrollPane, 600, 600);
        signUpstage.setResizable(false);
        signUpstage.setScene(signUp);
        signUpstage.show();
    }

}
