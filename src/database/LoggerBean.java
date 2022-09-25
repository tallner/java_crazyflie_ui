package database;

import java.util.ArrayList;

import databaseHelpers.jsonHelper;
import databaseHelpers.keyvaluepair;

public class LoggerBean {
	
	private int log_id;
	private String username;
	private float battery_voltage;
	private int battery_soc;
	private float pitch;
	private float roll;
	private float yaw;
	private int motor1_pwm;
	private int motor2_pwm;
	private int motor3_pwm;
	private int motor4_pwm;

	public void setId(int _log_id) {
		log_id = _log_id;
	}

	public int getId() {
		return log_id;
	}

	public String get_username() {
		return username;
	}

	public void set_username(String _username) {
		username = _username;
	}

	public float get_battery_voltage() {
		return battery_voltage;
	}

	public void set_battery_voltage(float _battery_voltage) {
		battery_voltage = _battery_voltage;
	}

	public int get_battery_soc() {
		return battery_soc;
	}

	public void set_battery_soc(int _battery_soc) {
		battery_soc = _battery_soc;
	}

	public float get_pitch() {
		return pitch;
	}

	public void set_pitch(float _pitch) {
		pitch = _pitch;
	}

	public float get_roll() {
		return roll;
	}

	public void set_roll(float _roll) {
		roll = _roll;
	}

	public float get_yaw() {
		return yaw;
	}

	public void set_yaw(float _yaw) {
		yaw = _yaw;
	}

	public int get_motor1_pwm() {
		return motor1_pwm;
	}

	public void set_motor1_pwm(int _motor1_pwm) {
		motor1_pwm = _motor1_pwm;
	}

	public int get_motor2_pwm() {
		return motor2_pwm;
	}

	public void set_motor2_pwm(int _motor2_pwm) {
		motor2_pwm = _motor2_pwm;
	}

	public int get_motor3_pwm() {
		return motor3_pwm;
	}

	public void set_motor3_pwm(int _motor3_pwm) {
		motor3_pwm = _motor3_pwm;
	}

	public int get_motor4_pwm() {
		return motor4_pwm;
	}

	public void set_motor4_pwm(int _motor4_pwm) {
		motor4_pwm = _motor4_pwm;
	}
	
	

	@Override
	public String toString() {
		return "loggerBean [log_id=" + log_id + ", username=" + username + ", battery_voltage=" + battery_voltage
				+ ", battery_soc=" + battery_soc + ", pitch=" + pitch + ", roll=" + roll + ", yaw=" + yaw
				+ ", motor1_pwm=" + motor1_pwm + ", motor2_pwm=" + motor2_pwm + ", motor3_pwm=" + motor3_pwm
				+ ", motor4_pwm=" + motor4_pwm + "]";
	}

	public String toJson() {
		ArrayList<keyvaluepair> datalist = new ArrayList<keyvaluepair>();
		datalist.add(new keyvaluepair("username", username));
		datalist.add(new keyvaluepair("battery_voltage", Float.toString(battery_voltage)));
		datalist.add(new keyvaluepair("battery_soc", Integer.toString(battery_soc)));
		
		datalist.add(new keyvaluepair("pitch", Float.toString(pitch)));
		datalist.add(new keyvaluepair("roll", Float.toString(roll)));
		datalist.add(new keyvaluepair("yaw", Float.toString(yaw)));
		
		datalist.add(new keyvaluepair("motor1_pwm", Integer.toString(motor1_pwm)));
		datalist.add(new keyvaluepair("motor2_pwm", Integer.toString(motor2_pwm)));
		datalist.add(new keyvaluepair("motor3_pwm", Integer.toString(motor3_pwm)));
		datalist.add(new keyvaluepair("motor4_pwm", Integer.toString(motor4_pwm)));
		

		return jsonHelper.toJsonObject(datalist);
	}

}
