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
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
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

    public boolean chkRadioBtn(){
        if(maleRadioButton.isSelected()){
            return true;
        }else if(femaleRadioButton.isSelected()){
            return true;
        }
        else 
        return false;
    }

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
        firstName.setFont(Font.font("Helvetica", FontWeight.BOLD, 12));
        firstName.setTextFill(Color.WHITE);
        firstnameField = new TextField();

        Label emailLabel = new Label("Email Address");
        emailLabel.setFont(Font.font("Helvetica", FontWeight.BOLD, 12));
        emailLabel.setTextFill(Color.WHITE);
        emailField = new TextField();

        Label passLabel = new Label("Password");
        passLabel.setFont(Font.font("Helvetica", FontWeight.BOLD, 12));
        passLabel.setTextFill(Color.WHITE);
        passwordField = new PasswordField();

        Label confirmPassLabel = new Label("Confirm Password");
        confirmPassLabel.setTextFill(Color.WHITE);
        confirmPassLabel.setFont(Font.font("Helvetica", FontWeight.BOLD, 12));
        confirmPassField = new PasswordField();

        Label gender = new Label("Gender");
        gender.setTextFill(Color.WHITE);
        gender.setFont(Font.font("Helvetica", FontWeight.BOLD, 12));
        ToggleGroup rbToggle = new ToggleGroup();
        maleRadioButton = new RadioButton("Male");
        maleRadioButton.setTextFill(Color.WHITE);
        maleRadioButton.setFont(Font.font("Helvetica", FontWeight.BOLD, 12));
        femaleRadioButton = new RadioButton("Female");
        femaleRadioButton.setTextFill(Color.WHITE);
        femaleRadioButton.setFont(Font.font("Helvetica", FontWeight.BOLD, 12));
        maleRadioButton.setToggleGroup(rbToggle);
        femaleRadioButton.setToggleGroup(rbToggle);

        Label dobLabel = new Label("Date Of Birth");
        dobLabel.setFont(Font.font("Helvetica", FontWeight.BOLD, 12));
        dobLabel.setTextFill(Color.WHITE);
        dobDatePicker = new DatePicker();

        Button signUpButton = new Button("Sign Up");
        signUpButton.setFont(Font.font("Helvetica", FontWeight.BOLD, 14));
        signUpButton.setStyle("-fx-background-radius: 10px; -fx-background-color: BLUE;");
        // signUpButton.setFont(Font.font(null, FontWeight.BOLD, 12));
        signUpButton.setTextFill(Color.WHITE);
        signUpButton.setOnMouseEntered(e -> signUpButton.setEffect(new DropShadow()));
        signUpButton.setOnMouseExited(e -> signUpButton.setEffect(null));
        signUpButton.setCursor(Cursor.HAND);

        Button cancelButton = new Button("Cancel");
        cancelButton.setStyle("-fx-background-radius: 10px; -fx-background-color: RED;");
        cancelButton.setFont(Font.font(null, FontWeight.BOLD, 14));
        cancelButton.setTextFill(Color.WHITE);
        // cancelButton.setPrefWidth(80);
        cancelButton.setOnMouseEntered(e -> cancelButton.setEffect(new DropShadow()));
        cancelButton.setOnMouseExited(e -> cancelButton.setEffect(null));
        cancelButton.setCursor(Cursor.HAND);

        CheckBox showPass = new CheckBox("Show Password");
        showPass.setFont(Font.font("Helvetica", FontWeight.BOLD, 12));
        showPass.setTextFill(Color.WHITE);
        CheckBox showConfirmPass = new CheckBox("Show Password");
        showConfirmPass.setFont(Font.font("Helvetica", FontWeight.BOLD, 12));
        showConfirmPass.setTextFill(Color.WHITE);
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

        signUpPane.setStyle("-fx-background-color: #686BFF;");

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
                if (firstnameField.getText().equals("") || emailField.getText().equals("")
                        || dobDatePicker.getValue().equals("") || passwordField.getText().equals("")
                        || confirmPassField.getText().equals("") || chkRadioBtn() == false) {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setContentText("Please fill all the fields");
                    alert.show();
                } else {
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
            }
        });

        signUp = new Scene(signUpPane, 800, 600);
        signUpstage.setResizable(false);
        signUpstage.setScene(signUp);
        signUpstage.show();
    }

}
