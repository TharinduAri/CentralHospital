package net.model;

public class Doctor extends User{
	private String specialization;
	
	public Doctor(int userId, String email, String firstName, String lastName, String password, String gender,
			String dateOfBirth, String phone, String streetAddress, String city, String state, String postalCode,String specialization) {
		super(userId,email,firstName,lastName,password,gender,dateOfBirth,phone,streetAddress,city,state,postalCode);
		this.specialization=specialization;
	}
	
	//add Doctor constructor
	public Doctor(String email, String firstName, String lastName, String dob, String phone, String password,
			String gender, String streetAddress, String city, String state, String postalCode,String specialization) {
		super(email,firstName,lastName,dob,phone,password,gender,streetAddress,city,state,postalCode);
		this.specialization=specialization;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	
	

}
