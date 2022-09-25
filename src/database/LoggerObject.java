package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import databaseHelpers.jsonHelper;

public class LoggerObject {
	private Connection _connection;
	private ArrayList<LoggerBean> _logger;
	
	private String createLog = "INSERT INTO sensorvalues "
			+ "(username,"
			+ "battery_voltage,battery_soc,"
			+ "pitch,roll,yaw,"
			+ "motor1_pwm,motor2_pwm,motor3_pwm,motor4_pwm)"
			+ "VALUES (?,?,?,?,?,?,?,?,?,?)";
	private String readAllLogs = "SELECT * FROM sensorvalues";
	
	public LoggerObject(Connection cn) {
		_connection = cn;
		_logger = new ArrayList<LoggerBean>();
		getLogs();
		
	}
	
	public ArrayList<LoggerBean> getLogs() {
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
	
	public int createLog(
			String username, 
			float battery_voltage,
			int battery_soc,			
			float pitch,
			float roll,
			float yaw,
			int motor1_pwm,
			int motor2_pwm,
			int motor3_pwm,
			int motor4_pwm)
	{
		int count = -1;

		if (username.isBlank()) return -1;
		
		try (PreparedStatement myQry = this._connection.prepareStatement(createLog)) {
			myQry.setString(1, username);
			myQry.setFloat(2, battery_voltage);
			myQry.setInt(3, battery_soc);
			myQry.setFloat(4, pitch);
			myQry.setFloat(5, roll);
			myQry.setFloat(6, yaw);
			myQry.setInt(7, motor1_pwm);
			myQry.setInt(8, motor2_pwm);
			myQry.setInt(9, motor3_pwm);
			myQry.setInt(10, motor4_pwm);
						
			count = myQry.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("createLog exception for statement");
			e.printStackTrace();
		}
		
		return count;
	}
	
	public String toJson() {
		String beansContent = "";
		for (LoggerBean lb : _logger) {
			beansContent += lb.toJson() + ",";
		}
		
		return jsonHelper.toJsonArray("Logger", beansContent);
	}

 	private LoggerBean buildLog(ResultSet rs) {
		LoggerBean lb = new LoggerBean();

		try {
			lb.setId(rs.getInt("log_id"));
			lb.set_username(rs.getString("username"));
			lb.set_battery_voltage(rs.getFloat("battery_voltage"));
			lb.set_battery_soc(rs.getInt("battery_soc"));			
			lb.set_pitch(rs.getFloat("pitch"));
			lb.set_roll(rs.getFloat("roll"));
			lb.set_yaw(rs.getFloat("yaw"));
			lb.set_motor1_pwm(rs.getInt("motor1_pwm"));
			lb.set_motor2_pwm(rs.getInt("motor2_pwm"));
			lb.set_motor3_pwm(rs.getInt("motor3_pwm"));
			lb.set_motor4_pwm(rs.getInt("motor4_pwm"));

			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lb;
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
			System.out.println("runQuery exception for result set");
			e.printStackTrace();
		}

 	}

}
