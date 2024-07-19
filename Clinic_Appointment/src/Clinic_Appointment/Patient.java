package Clinic_Appointment;

public class Patient 
{
 int patient_id;
 String patient_name;
 String MobileNumber;
 String Address;


public Patient(int patient_id, String patient_name, String mobileNumber, String address) {
	super();
	this.patient_id = patient_id;
	this.patient_name = patient_name;
	MobileNumber = mobileNumber;
	Address = address;
}


public Patient(String string) {
	// TODO Auto-generated constructor stub
}


public Patient(int patientIdToUpdate, String updatedPatientName, String updatedPhone) {
	// TODO Auto-generated constructor stub
}


public int getPatient_id() {
	return patient_id;
}
public void setPatient_id(int patient_id) {
	this.patient_id = patient_id;
}
public String getPatient_name() {
	return patient_name;
}
public void setPatient_name(String patient_name) {
	this.patient_name = patient_name;
}
public String getMobileNumber() {
	return MobileNumber;
}
public void setMobileNumber(String mobileNumber) {
	MobileNumber = mobileNumber;
}
public String getAddress() {
	return Address;
}
public void setAddress(String address) {
	Address = address;
}
@Override
public String toString() {
	return "Patient [patient_id=" + patient_id + ", patient_name=" + patient_name + ", MobileNumber=" + MobileNumber
			+ ", Address=" + Address + "]";
}
}
