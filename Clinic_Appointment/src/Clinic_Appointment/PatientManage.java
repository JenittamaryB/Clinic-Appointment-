package Clinic_Appointment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PatientManage {
private Connection con;

public PatientManage(Connection connection)
{
 this.con=connection;
}

public List<Patient> getAllPatients() throws SQLException {
	List<Patient> patient=new ArrayList<>();
	String query="SELECT * FROM Patient";
	Statement st=con.createStatement();
    ResultSet rs=st.executeQuery(query);
	
while(rs.next()) 
{
	Patient p=new Patient(
	rs.getInt("patient_id")
	+" "+rs.getString("patient_name")
	+" "+rs.getString("mobilenumber")
	+" "+rs.getString("Address"));
 patient.add(p);
}
return patient;

}

public void addPatient(Patient patient) throws SQLException {
	String query="INSERT INTO patient(name,phone)values(?,?)";
	PreparedStatement ps=con.prepareStatement(query);
	ps.setString(1,patient.getPatient_name());
	ps.setString(2, patient.getMobileNumber());
	ps.setString(3,patient.getAddress());
}

public Patient getPatientById(int id) throws SQLException {
	Patient patient=null;
	String query="select * from patient where patient_id=?";
	PreparedStatement ps=con.prepareStatement(query);
	ps.setInt(1,id);
	ResultSet rs=ps.executeQuery();
	{
		if(rs.next()) 
		{
			Patient p=new Patient(rs.getInt("patient_id")
					+" "+rs.getString("patient_name")
					+" "+rs.getString("mobilenumber")
					+" "+rs.getString("Address"));
		}
		
	}
	return patient;
}

public void updatePatient(Patient patient) throws SQLException {
	String query="update patient set patient_name=?,mobilenumber=? where patient_id=?";
	PreparedStatement ps=con.prepareStatement(query);
	ps.setString(1,patient.getPatient_name());
	ps.setString(2,patient.getMobileNumber());
	ps.setInt(3,patient.getPatient_id());
	ps.executeUpdate();
	
}

public void deletePatient(int id) throws SQLException {
	String query="delete from patient where patient_id=?";
	PreparedStatement ps=con.prepareStatement(query);
	ps.setInt(1, id);
	ps.executeUpdate();
}




}
