package Clinic_Appointment;

import java.sql.Date;
import java.sql.Time;

public class Appointment 
{
int appointment_id;
String Appointment_date;
String Appointment_time;
int doctor_id;
int patient_id;

public Appointment(int appointment_id, String date, String time, int doctor_id, int patient_id) {
	super();
	this.appointment_id = appointment_id;
	this.Appointment_date = date;
	this.Appointment_time= time;
	this.doctor_id = doctor_id;
	this.patient_id = patient_id;
	
}
public Appointment(String string) {
	// TODO Auto-generated constructor stub
}
public Appointment(int appointment_id2, int doctorId, int patientId, Date appointmentDate, Time appointmentTime) {
	// TODO Auto-generated constructor stub
}
public int getAppointment_id() {
	return appointment_id;
}
public void setAppointment_id(int appointment_id) {
	this.appointment_id = appointment_id;
}
public String getDate() {
	return Appointment_date;
}
public void setDate(String date) {
	this.Appointment_date = date;
}
public String getTime() {
	return Appointment_time;
}
public void setTime(String time) {
	this.Appointment_time = time;
}
public int getDoctor_id() {
	return doctor_id;
}
public void setDoctor_id(int doctor_id) {
	this.doctor_id = doctor_id;
}
public int getPatient_id() {
	return patient_id;
}
public void setPatient_id(int patient_id) {
	this.patient_id = patient_id;
}
@Override
public String toString() {
	return "Appointment [appointment_id=" + appointment_id + ", date=" + Appointment_date + ", time=" + Appointment_time + ", doctor_id="
			+ doctor_id + ", patient_id=" + patient_id + "]";
}

}
