package Clinic_Appointment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AppointmentMangage {
private Connection con;

public AppointmentMangage(Connection con) {
	this.con=con;
}

public List<Appointment> getAllAppointment() throws SQLException
{
	List<Appointment> appointment=new ArrayList<>();
	String query="Select * from Appointment";
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery(query);
	{
		while(rs.next())
		{
			Appointment a=new Appointment(
					rs.getInt("Appointment_id")+" "+
					rs.getString("Appointment_date")+" "+
					rs.getString("Appointment_time")+" "+
					rs.getInt("doctor_id")+" "+
					rs.getInt("patient_id"));
		}
	}
	return appointment;
}

public void addAppointment(Appointment appointment) throws SQLException {
	 String query="Insert into appointment(date,time,doctor_id,patient_id) value(?,?)";
	 PreparedStatement ps=con.prepareStatement(query);
	 ps.setInt(1, appointment.getAppointment_id());
	 ps.setString(2,appointment.getDate());
	 ps.setString(3,appointment.getTime());
	 ps.setInt(4, appointment.getDoctor_id());
	 ps.setInt(5, appointment.getDoctor_id());
	 ps.executeUpdate();
	
}

public Appointment getAppointmentById(int id) throws SQLException {
	Appointment appointment=null;
	String query="select * From appointment where id=?";
	PreparedStatement ps=con.prepareStatement(query);
	ps.setInt(1, id);
	ResultSet rs=ps.executeQuery();
	if(rs.next()) {
		Appointment ap=new Appointment(
				rs.getInt("Appointment_id")+" "+
						rs.getString("Appointment_date")+" "+
						rs.getString("Appointment_time")+" "+
						rs.getInt("doctor_id")+" "+
						rs.getInt("patient_id"));
	 
	}
	return appointment;
	
}


public void updateAppointment(Appointment appointment) throws SQLException {
	String query="update Appointment set (Appointment_date=?,Appointment_time=?,doctor_id=?,patient_id=?) where Appointment_id=?  "	;
	PreparedStatement ps=con.prepareStatement(query);
	ps.setString(1,appointment.getDate());
	ps.setString(2, appointment.getTime());
	ps.setInt(3,appointment.getDoctor_id());
	ps.setInt(4, appointment.getPatient_id());

}

public void deleteAppointment(int id) throws SQLException {
	String query="delete from appointment where appointment_id";
	PreparedStatement ps=con.prepareStatement(query);
	ps.setInt(1,id);
	ps.executeQuery();
}


}
