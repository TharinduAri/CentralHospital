package net.model;

public class Appointment {
	
	int appointmentId;
	int userId;
	int doctorId;
	String date;
	String time;
	String Docname;
	String Status;
	

	public Appointment(int appointmentId, int doctorId, String date, String time, String docname, String status) {
		super();
		this.appointmentId = appointmentId;
		this.doctorId = doctorId;
		this.date = date;
		this.time = time;
		Docname = docname;
		Status = status;
	}
	
	
	public Appointment(int appointmentId, int userId, int doctorId, String date, String time, String docname,
			String status) {
		this.appointmentId = appointmentId;
		this.userId = userId;
		this.doctorId = doctorId;
		this.date = date;
		this.time = time;
		Docname = docname;
		Status = status;
	}



	public int getAppointmentId() {
		return appointmentId;
	}



	public int getUserId() {
		return userId;
	}



	public int getDoctorId() {
		return doctorId;
	}



	public String getDate() {
		return date;
	}



	public String getTime() {
		return time;
	}



	public String getDocname() {
		return Docname;
	}



	public String getStatus() {
		return Status;
	}



	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}



	public void setDate(String date) {
		this.date = date;
	}



	public void setTime(String time) {
		this.time = time;
	}



	public void setDocname(String docname) {
		Docname = docname;
	}



	public void setStatus(String status) {
		Status = status;
	}


	
	
	
	
	
	

}
