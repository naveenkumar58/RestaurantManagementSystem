
public class User {
	String firstName, lastName, gender, DOB, email, password, rePassword;

	public void setFirstName(String param) {
		this.firstName = param;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setGender(String param) {
		this.gender = param;
	}

	public String getGender() {
		return this.gender;
	}

	public void setdob(String dob) {
		this.DOB = dob;
	}

	private String getDOB() {
		return this.DOB;
	}

	public void setEmail(String param) {
		this.email = param;
	}

	public String getEmail() {
		return this.email;
	}

	public void setPassword(String param) {
		this.password = param;
	}

	public String getPassword() {
		return this.password;
	}

	public void setConfirmPassword(String param) {
		this.rePassword = param;
	}

	public String getConfirmPassword() {
		return this.rePassword;
	}

	public String toString() {
		return this.firstName + "," + this.gender + "," + this.getDOB() + "," + this.email + ","
				+ this.password;
	}
}
