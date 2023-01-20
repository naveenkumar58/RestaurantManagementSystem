import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
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
    Login loginObj = new Login();
    User userData;
    TextField firstnameField, emailField;
    RadioButton maleRadioButton, femaleRadioButton;
    DatePicker dobDatePicker;
    PasswordField passwordField, confirmPassField;

    public User getUserDetails() {
        userData.setFirstName(firstnameField.getText());
        if (maleRadioButton.isSelected()) {
            userData.setGender("Male");
        } else if (femaleRadioButton.isSelected()) {
            userData.setGender("Female");
        }
        userData.setdob(dobDatePicker.getValue().toString());
        userData.setEmail(emailField.getText());
        userData.setPassword(passwordField.getText());
        userData.setConfirmPassword(confirmPassField.getText());
        return userData;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        userData = new User();
        ScrollPane scrollPane = new ScrollPane();

        signUpstage = primaryStage;
        Label firstName = new Label("Username");
        firstnameField = new TextField();

        Label emailLabel = new Label("Email Address");
        emailField = new TextField();

        Label passLabel = new Label("Password");
        passwordField = new PasswordField();

        Label confirmPassLabel = new Label("Confirm Password");
        confirmPassField = new PasswordField();

        Label gender = new Label("Gender");
        ToggleGroup rbToggle = new ToggleGroup();
        maleRadioButton = new RadioButton("Male");
        femaleRadioButton = new RadioButton("Female");
        maleRadioButton.setToggleGroup(rbToggle);
        femaleRadioButton.setToggleGroup(rbToggle);

        Label dobLabel = new Label("Date Of Birth");
        dobDatePicker = new DatePicker();

        Button signUpButton = new Button("Sign Up");
        signUpButton.setCursor(Cursor.HAND);

        Button cancelButton = new Button("Cancel");
        cancelButton.setCursor(Cursor.HAND);

        CheckBox showPass = new CheckBox("Show Password");
        CheckBox showConfirmPass = new CheckBox("Show Password");
        TextField passText = new TextField();
        TextField confirmPassText = new TextField();

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

        showConfirmPass.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (showConfirmPass.isSelected()) {
                    confirmPassText.setText(confirmPassField.getText());
                    confirmPassText.setVisible(true);
                    confirmPassField.setVisible(false);
                    return;
                } else {
                    confirmPassField.setText(confirmPassText.getText());
                    confirmPassField.setVisible(true);
                    confirmPassText.setVisible(false);
                }

            }
        });

        GridPane signUpPane = new GridPane();
        signUpPane.setAlignment(Pos.CENTER);
        signUpPane.setHgap(10);
        signUpPane.setVgap(10);
        signUpPane.add(firstName, 1, 1);
        signUpPane.add(firstnameField, 1, 2);
        signUpPane.add(emailLabel, 2, 1);
        signUpPane.add(emailField, 2, 2);
        signUpPane.add(dobLabel, 1, 3);
        signUpPane.add(dobDatePicker, 1, 4);
        signUpPane.add(gender, 2, 3);
        signUpPane.add(maleRadioButton, 2, 4);
        signUpPane.add(femaleRadioButton, 2, 4);
        signUpPane.setMargin(femaleRadioButton, new Insets(0, 0, 0, 80));
        signUpPane.add(passLabel, 1, 5);
        signUpPane.add(passText, 1, 6);
        signUpPane.add(passwordField, 1, 6);
        signUpPane.add(showPass, 1, 7);
        signUpPane.add(confirmPassLabel, 2, 5);
        signUpPane.add(confirmPassText, 2, 6);
        signUpPane.add(confirmPassField, 2, 6);
        signUpPane.add(showConfirmPass, 2, 7);
        signUpPane.add(signUpButton, 2, 8);
        signUpPane.add(cancelButton, 2, 8);
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
                boolean confirm;
                // Filing fileWrite = new Filing();
                // System.out.println(fileWrite.readData("signup.txt"));
                // fileWrite.writeData(getUserDetails(), "signup.txt");
                Authentication auth = new Authentication();
                confirm = auth.signUp(getUserDetails());
                if (confirm == false) {
                    HomePage home = new HomePage();
                    try {
                        home.start(signUpstage);
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        });

        signUp = new Scene(signUpPane, 800, 600);
        signUpstage.setResizable(false);
        signUpstage.setScene(signUp);
        signUpstage.show();
    }

}
