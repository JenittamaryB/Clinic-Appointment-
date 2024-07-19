package Clinic_Appointment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ClinicMain {

	public static void main(String[] args) throws SQLException {
		String url="jdbc:mysql://localhost:3306/clinic";
		String username="root";
		String password="root";
		Connection con=DriverManager.getConnection(url,username,password);
		System.out.println("Database connected!");
		DoctorManage dm=new DoctorManage(con);
		PatientManage pm=new PatientManage(con);
		AppointmentMangage am=new  AppointmentMangage(con);
		
		
		Scanner sc=new Scanner(System.in);
	    boolean exit=false;
	    
	    while(!exit) {

	    	System.out.println("/n menu");
	    	System.out.println("1.Add Doctor");
	    	System.out.println("2.List Doctor");
	    	System.out.println("3.Update Doctor");
	    	System.out.println("4.Delete Doctor");
	    	System.out.println("5.Add patient");
	    	System.out.println("6.list Patient");
	    	System.out.println("7.Update Patient");
	    	System.out.println("8.Deletee Patient");
	    	System.out.println("9.Add Appointment");
	    	System.out.println("10.List Appointment");
	    	System.out.println("11.Update Appointment");
	    	System.out.println("12.Delete Appointement");
	    	System.out.println("13.Exit");
	    	
	    	System.out.println("Choose an option:");
	    	int choice=sc.nextInt();
	    	sc.nextLine();
	    	
	    	
	    	switch(choice) 
	    	{
	    	case 1:
	    	 System.out.println("Enter the doctor name:");
	    	 String doctorname=sc.nextLine();
	    	 
	    	 System.out.println("Enter Specialization");
	    	 String specialization=sc.nextLine();
	    	 
	    	 Doctor newDoctor=new Doctor(0,doctorname,specialization);
	    	 dm.addDoctor(newDoctor);
	    	 System.out.println("Doctor added"+ newDoctor);
	    	 break;
	       
	    	
	    	case 2:
	    		List<Doctor> doctors=dm.getAllDoctors();
	    		System.out.println("All Doctors");
	    		
	    		for(Doctor doctor:doctors) 
	    		{
	    			System.out.println(doctor);
	    		 }
	    		break;
	    		
	    	case 3:
	    		System.out.println("Enter doctorId to update");
	    		int doctorId=sc.nextInt();
	    		sc.nextLine();
	    		System.out.println("Enter new doctor name:");
	    		String newdoctor=sc.nextLine();
	    		System.out.println("Enter new Specilaization");
	    		String newSpecailization=sc.nextLine();
	    		Doctor updatedoctor=new Doctor(doctorId,newdoctor,newSpecailization);
	    		dm.updateDoctor(updatedoctor);
	    		System.out.println("Doctor Update"+updatedoctor);
	            break;
	            
	    	case 4:
	    		 System.out.print("Enter doctor ID to delete: ");
                 int doctorIdToDelete = sc.nextInt();
                 dm.deleteDoctor(doctorIdToDelete);
                 System.out.println("Doctor with ID " + doctorIdToDelete + " deleted.");
                 break;
                 
	    	case 5:
	    		System.out.print("Enter patient name: ");
                String patientName = sc.nextLine();
                
                System.out.print("Enter phone number: ");
                String phone = sc.nextLine();
                
                System.out.println("Enter Address:");
                String address=sc.nextLine();
                
                Patient newPatient=new Patient(0, patientName, phone, address);
                pm.addPatient(newPatient);
                System.out.println("Patient added: " + newPatient);
                break;
                
	    	case 6:
	    		List<Patient> patients = pm.getAllPatients();
                System.out.println("All Patients:");
                for (Patient patient : patients) {
                    System.out.println(patient);
                }
                break;
                
	    	case 7:
	    		System.out.print("Enter patient ID to update: ");
                int patientIdToUpdate = sc.nextInt();
                sc.nextLine(); // consume newline
                System.out.print("Enter new patient name: ");
                String updatedPatientName = sc.nextLine();
                System.out.print("Enter new phone number: ");
                String updatedPhone = sc.nextLine();
                Patient updatedPatient = new Patient(patientIdToUpdate, updatedPatientName, updatedPhone);
                pm.updatePatient(updatedPatient);
                System.out.println("Patient updated: " + updatedPatient);
                break;

	    	case 8:
	    		System.out.print("Enter patient ID to delete: ");
                int patientIdToDelete = sc.nextInt();
                pm.deletePatient(patientIdToDelete);
                System.out.println("Patient with ID " + patientIdToDelete + " deleted.");
                break;
                
	    	case 9:
	    		 System.out.print("Enter doctor ID: ");
                 int doctorID = sc.nextInt();
                 System.out.print("Enter patient ID: ");
                 int patientId = sc.nextInt();
                 sc.nextLine(); // consume newline
                 System.out.print("Enter appointment date (YYYY-MM-DD): ");
                 String dateStr = sc.nextLine();
                 System.out.print("Enter appointment time (HH:MM:SS): ");
                 String timeStr = sc.nextLine();
                 java.sql.Date appointmentDate = java.sql.Date.valueOf(dateStr);
                 java.sql.Time appointmentTime = java.sql.Time.valueOf(timeStr);
                 Appointment newAppointment = new Appointment(0, doctorID, patientId, appointmentDate, appointmentTime);
                 am.addAppointment(newAppointment);
                 System.out.println("Appointment added: " + newAppointment);
                 break;
                 
	    	case 10:
	    		 List<Appointment> appointments = am.getAllAppointment();
                 System.out.println("All Appointments:");
                 for (Appointment appointment : appointments) {
                     System.out.println(appointment);
                 }
                 
	    	case 11:
	    		System.out.print("Enter appointment ID to update: ");
                int appointmentIdToUpdate = sc.nextInt();
                System.out.print("Enter doctor ID: ");
                int updatedDoctorId = sc.nextInt();
                System.out.print("Enter patient ID: ");
                int updatedPatientId = sc.nextInt();
                sc.nextLine(); // consume newline
                System.out.print("Enter new appointment date (YYYY-MM-DD): ");
                String updatedDateStr = sc.nextLine();
                System.out.print("Enter new appointment time (HH:MM:SS): ");
                String updatedTimeStr = sc.nextLine();
                java.sql.Date updatedDate = java.sql.Date.valueOf(updatedDateStr);
                java.sql.Time updatedTime = java.sql.Time.valueOf(updatedTimeStr);
                Appointment updatedAppointment = new Appointment(appointmentIdToUpdate, updatedDoctorId, updatedPatientId, updatedDate, updatedTime);
                am.updateAppointment(updatedAppointment);
                System.out.println("Appointment updated: " + updatedAppointment);
                break;
                
	    	case 12:
	    		System.out.print("Enter appointment ID to delete: ");
                int appointmentIdToDelete = sc.nextInt();
                am.deleteAppointment(appointmentIdToDelete);
                System.out.println("Appointment with ID " + appointmentIdToDelete + " deleted.");
                break;
                
	    	





	    		






	    		

	    
	         
	    
	}
}
	}
}

