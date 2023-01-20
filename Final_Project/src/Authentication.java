import java.util.ArrayList;
import java.util.HashMap;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class Authentication {
	private static final String usersFile = "signup.txt";

	HashMap<String, Integer> columnMap = new HashMap<>();

	Authentication() {
		columnMap.put("fName", 0);
		// columnMap.put("lName", 1);
		columnMap.put("gender", 1);
		columnMap.put("date", 2);
		columnMap.put("email", 3);
		columnMap.put("password", 4);
	}

	public boolean searchByEmail(ArrayList<String> arrayList, String email) {
		for (int i = 0; i < arrayList.size(); i++) {
			String lineInfo = arrayList.get(i);
			// System.out.println(lineInfo);
			if (lineInfo != null) {
				String[] columns = lineInfo.split(",");
				// System.out.println((columns[columnMap.get("email")]));
				if (columns[columnMap.get("email")].equals(email)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean searchByEmailAndPassword(ArrayList<String> arrayList, String email, String password) {
		for (int i = 0; i < arrayList.size(); i++) {
			String lineInfo = arrayList.get(i);
			// System.out.println(lineInfo);
			if (lineInfo != null) {
				String[] columns = lineInfo.split(",");
				// System.out.println((columns[columnMap.get("email")]));
				if (columns[columnMap.get("email")].equals(email)
						&& columns[columnMap.get("password")].equals(password)) {
					return true;
				}
			}
		}
		return false;
	}

	Filing filing = new Filing();

	public boolean signUp(User userData) {
		ArrayList<String> usersFileData = filing.readData(usersFile);
		Boolean isEmailFound = searchByEmail(usersFileData, userData.getEmail());
		if (isEmailFound == true) {
			Alert signUpError = new Alert(Alert.AlertType.ERROR);
			signUpError.setContentText("Email already exist");
			// System.out.println("Email already exist");
			signUpError.show();
			return true;
		} else {
			// password match validation usersFileData,pass1,pass2
			if (userData.getPassword().equals(userData.getConfirmPassword())) {
				filing.writeData(userData.toString(), usersFile);
				Alert signUpSuccessful = new Alert(Alert.AlertType.INFORMATION);
				signUpSuccessful.setContentText("You have successfully created Your Account");
				signUpSuccessful.show();
				return false;
			} else {
				Alert signUpError = new Alert(Alert.AlertType.ERROR);
				signUpError.setContentText("Password doesn't match");
				signUpError.show();
				return true;
			}
		}
	}

	public boolean signIn(String emial, String Password) {
		ArrayList<String> usersFileData = filing.readData(usersFile);
		Boolean isEmailAndPasswordFound = searchByEmailAndPassword(usersFileData, emial, Password);
		if (isEmailAndPasswordFound == true) {
			Alert loginSuccessful = new Alert(Alert.AlertType.INFORMATION);
			loginSuccessful.setContentText("You are successfully Login");
			loginSuccessful.show();
			return true;

		} else {
			Alert loginError = new Alert(Alert.AlertType.ERROR);
			loginError.setContentText("Invalid Email or Password");
			loginError.show();
			return false;
		}

	}

}
