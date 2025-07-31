package net.model;

public class Patient extends User {
	private String appointmentStatus;

//	public Patient(int userId, String email, String firstName, String lastName, String password, String role,
//			String gender, String dob, String phone, String appointmentStatus, String streetAddress, String city,
//			String state, String postalCode) {
//		super(userId, email, firstName, lastName, password, role, gender, dob, phone, streetAddress, city, state,
//				postalCode);
//		this.appointmentStatus = appointmentStatus;
//	}
//
//	public Patient(String email,String firstName, String lastName, String dob,  String phone, String password,
//			String gender, String streetAddress, String city, String state, String postalCode) {
//		super(email,firstName, lastName, dob,  phone, password, gender, streetAddress, city, state, postalCode);
//	}
//
	public Patient(int userId, String email, String firstName, String lastName, String password, String gender,
			String dateOfBirth, String streetAddress, String city, String state, String postalCode, String phone,
			String appointmentStatus) {
		super(userId, email, firstName, lastName, password, gender, dateOfBirth, streetAddress, city, state, postalCode,
				phone);
		this.appointmentStatus = appointmentStatus;
	}

	public Patient(int userId, String email) {
		super(userId, email);
	}
//temporary
	public Patient(String email, String firstName, String lastName, String dob, String phone, String password,
			String gender, String streetAddress, String city, String state, String postalCode) {
		super(email,firstName,lastName,dob,phone,password,gender,streetAddress,city,state,postalCode);
	}
//end
	public String getAppointmentStatus() {
		return appointmentStatus;
	}

	public void setAppointmentStatus(String appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}
}
