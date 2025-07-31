package net.model;

public class User {
	private int userId;
	private String email;
	private String firstName;
	private String lastName;
	private String password;
	private String role;
	private String gender;
	private String dob;
	private String phone;
	private String streetAddress;
	private String city;
	private String state;
	private String postalCode;


    public User(int userId, String email, String firstName, String lastName, String password, String role,
            String gender, String dob, String phone, String streetAddress, String city, String state, String postalCode) {
    this.userId = userId;
    this.email = email;
    this.firstName = firstName;
    this.lastName = lastName;
    this.password = password;
    this.role = role;
    this.gender = gender;
    this.dob = dob;
    this.phone = phone;
    this.streetAddress = streetAddress;
    this.city = city;
    this.state = state;
    this.postalCode = postalCode;
}

//public User(String firstName, String lastName, String dob, String email, String phone, String password,
//            String gender, String streetAddress, String city, String state, String postalCode) {
//    this.firstName = firstName;
//    this.lastName = lastName;
//    this.dob = dob;
//    this.email = email;
//    this.phone = phone;
//    this.password = password;
//    this.gender = gender;
//    this.streetAddress = streetAddress;
//    this.city = city;
//    this.state = state;
//    this.postalCode = postalCode;
//}
//	
	
	
	
	public User(int userId, String email, String firstName, String lastName, String password, String gender, String dob,
			String phone, String streetAddress, String city, String state, String postalCode) {
		this.userId = userId;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.gender = gender;
		this.dob = dob;
		this.phone = phone;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
	}



	public User(int userId, String email, String firstName, String lastName, String gender, String dob) {
		this.userId=userId;
		this.email=email;
		this.firstName=firstName;
		this.lastName=lastName;
		this.gender=gender;
		this.dob=dob;
	}

//temp
	public User(String email, String firstName, String lastName, String dob, String phone, String password,
			String gender, String streetAddress, String city, String state, String postalCode) {
	    this.email = email;
		this.firstName = firstName;
	    this.lastName = lastName;
	    this.dob = dob;
	    this.phone = phone;
	    this.password = password;
	    this.gender = gender;
	    this.streetAddress = streetAddress;
	    this.city = city;
	    this.state = state;
	    this.postalCode = postalCode;
	}
//end

	public User(int userId, String email) {
		this.userId=userId;
		this.email=email;
	}

	public User(int userId, String email, String firstName, String role) {
		this.userId = userId;
		this.email = email;
		this.firstName = firstName;
		this.role = role;
	}



	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthDate() {
		return dob;
	}
	public void setBirthDate(String dob) {
		this.dob = dob;
	}
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getStreetAddress() {
		return streetAddress;
	}


	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getPostalCode() {
		return postalCode;
	}


	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

}
