package validation.model;

import java.sql.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Student {

	@NotEmpty(message = "Id is empty")
	private String id;
	@NotEmpty(message = "Name is empty")
	private String name;
	@NotNull(message = "Gender is not checked")
	private String gender;
	@NotNull(message = "Birthdate is null")
	private Date birthdate;
	@NotEmpty(message = "Address is empty")
	private String address;
	private String image;

	public Student() {
	}

	public Student(@NotEmpty(message = "Id is empty") String id, 
			@NotEmpty(message = "Name is empty") String name,
			@NotNull(message = "Gender is not checked") String gender,
			@NotNull(message = "Birthdate is null") Date birthdate,
			@NotEmpty(message = "Address is empty") String address, String image) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.birthdate = birthdate;
		this.address = address;
		this.image = image;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
