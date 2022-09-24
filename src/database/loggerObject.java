package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import databaseHelpers.jsonHelper;

public class loggerObject {
	private Connection _connection;
	private ArrayList<loggerBean> _logger;
	
	private String createLog = "INSERT INTO sensorvalues "
			+ "(username,"
			+ "battery_voltage,battery_soc,"
			+ "pitch,roll,yaw,"
			+ "motor1_pwm,motor2_pwm,motor3_pwm,motor4_pwm)"
			+ "VALUES (?,?,?,?,?,?,?,?,?,?) ON DUPLICATE KEY UPDATE log_id=log_id";
	private String readAllLogs = "SELECT * FROM sensorvalues";
	
	public loggerObject(Connection cn) {
		_connection = cn;
		_logger = new ArrayList<loggerBean>();
		getLogs();
		
	}
	
	public ArrayList<loggerBean> getLogs() {
		if (_logger.size() > 0) 
			return _logger;
			
		try (PreparedStatement myQry = this._connection.prepareStatement(readAllLogs)) {
			runQuery(myQry);
		} catch (SQLException e) {
			System.out.println("getLogs exception for statement");
			e.printStackTrace();
		}
		
		return _logger;
	}
	
	public int createLog(String name, int age, String skill) {
		int count = -1;
		
		if (age<0 || age>150) return -1;
		if (name.isBlank()) return -1;
		
		try (PreparedStatement myQry = this._connection.prepareStatement(createLog)) {
			myQry.setString(1, name);
			myQry.setInt(2, age);
			myQry.setString(3, skill);
			count = myQry.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("getActor exception for statement");
			e.printStackTrace();
		}
		
		return count;
	}
	
	public String toJson() {
		String beansContent = "";
		for (loggerBean ab : _logger) {
			beansContent += ab.toJson() + ",";
		}
		
		return jsonHelper.toJsonArray("Actors", beansContent);
	}

 	private loggerBean buildLog(ResultSet rs) {
		loggerBean ab = new loggerBean();

		try {
			ab.setId(rs.getInt("actor_id"));
			ab.setAge(rs.getInt("age"));
			ab.setName(rs.getString("name"));
			ab.setSkill(rs.getString("skill"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ab;
	}
	
 	private void buildLogs(ResultSet rs) throws SQLException {
 		while(rs.next()) {  // rows
			this._logger.add(buildLog(rs));
		}
 	}
 	
 	private void runQuery(PreparedStatement query) {

		try (ResultSet rs = query.executeQuery()) {
			buildLogs(rs);
		} catch (SQLException e) {
			System.out.println("getActors exception for result set");
			e.printStackTrace();
		}

 	}
 	
 	private String selectQueryString(String function) {
 		String returnString = null;
 		
 		if (function.equals("age")) 
 			returnString = updateActorsAge;
 		else if (function.equals("skills")) 
 			returnString = updateActorsSkill;
 		else if (function.equals("all"))
 			returnString = updateActor;
 
 		
		return returnString;
 		
 	}
 	
 	private int selectQuery(PreparedStatement myQry, String name, int newAge, String newSkill, String function) throws SQLException {
 		int count = -1;
 		
 		if (function.equals("age")) {
 			myQry.setInt(1, newAge);
 			myQry.setString(2, name);
			count = myQry.executeUpdate();
			
 		}
 		else if (function.equals("skills")) {
 			myQry.setString(1, newSkill);
 			myQry.setString(2, name);
			count = myQry.executeUpdate();
			
 		}
 		else if (function.equals("all")){
 			myQry.setInt(1, newAge);
 			myQry.setString(2, newSkill);
 			myQry.setString(3, name);
			count = myQry.executeUpdate();
 		}
 		
		return count;
 		
 	}
}
