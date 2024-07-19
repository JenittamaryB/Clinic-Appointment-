package Clinic_Appointment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorManage
{
private Connection con;

public DoctorManage(Connection connection)
{
	this.con=connection;
}

public List<Doctor> getAllDoctors() throws SQLException 
{
	List<Doctor> doctors=new ArrayList<>();
	String query="SELECT * FROM doctors";
	Statement statement=con.createStatement();
		ResultSet result=statement.executeQuery(query);
	{
		while(result.next()) 
		{
			Doctor doctor=new Doctor(result.getInt("Doctor_id"),
					result.getString("name"),
					result.getString("specialization"));
			doctors.add(doctor);
			
		}
		
				}
	return doctors;
}

public void addDoctor(Doctor doctor) throws SQLException 
{
	String query="INSERT INTO Doctor(name,specialization) VALUES(?,?)";
	PreparedStatement ps=con.prepareStatement(query);
	
		ps.setString(1,doctor.getName());
		ps.setString(2,doctor.getSpecialization());
		ps.executeUpdate();
	
}

public Doctor getDoctorById(int id) throws SQLException{
	Doctor doctor=null;
	String query="select * from Doctor where Doctor_id=?";
	
    PreparedStatement ps=con.prepareStatement(query);
	ps.setInt(1,id);
	ResultSet rs=ps.executeQuery();
	{
		if(rs.next()){
		   doctor=new Doctor(
					rs.getInt("Doctor_id"),
					rs.getString("name"),
					rs.getString("Specialization"));
			
					
		}
	}
	return doctor;
	
}

public void updateDoctor(Doctor doctor) throws SQLException {
	String query="update doctor set name=?,Specialization=? where doctor_id=?";
	PreparedStatement ps=con.prepareStatement(query);
	ps.setString(1,doctor.getName());
	ps.setString(2,doctor.getSpecialization());
	ps.executeUpdate();
}

public void deleteDoctor(int id) throws SQLException {
	String query="delete from doctor where doctor_id";
	PreparedStatement ps=con.prepareStatement(query);
	ps.setInt(1, id);
	ps.executeUpdate();
}





}



