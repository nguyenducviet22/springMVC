package hello.model;

public class User {
	private String lastName;
	private String fisrtName;

	public User() {
	}

	public User(String lastName, String fisrtName) {
		this.lastName = lastName;
		this.fisrtName = fisrtName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFisrtName() {
		return fisrtName;
	}

	public void setFisrtName(String fisrtName) {
		this.fisrtName = fisrtName;
	}

}
