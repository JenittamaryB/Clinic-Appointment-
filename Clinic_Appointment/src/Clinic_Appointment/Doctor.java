package Clinic_Appointment;

public class Doctor
{
 int doctor_id;
 String name;
 String Specialization;

public Doctor(int doctor_id, String name, String specialization) {
	super();
	this.doctor_id = doctor_id;
	this.name = name;
	this.Specialization = specialization;
}

public int getDoctor_id()
{
	return doctor_id;
}
public void setDoctor_id(int doctor_id)
{
	this.doctor_id = doctor_id;
}
public String getName()
{
	return name;
}
public void setName(String name) 
{
	this.name = name;
}
public String getSpecialization() 
{
	return Specialization;
}
public void setSpecialization(String specialization)
{
	Specialization = specialization;
}
@Override
public String toString() {
	return "Doctor [doctor_id=" + doctor_id + ", name=" + name + ", Specialization=" + Specialization + "]";
}
}
