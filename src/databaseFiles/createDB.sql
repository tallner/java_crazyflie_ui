drop database if exists crazylog;
create database if not exists crazylog;
use crazylog;

drop table if exists sensorvalues;
create table if not exists sensorvalues(
	log_id int auto_increment,
    username varchar(50) not null UNIQUE,
    battery_voltage float,
    battery_soc int,
    pitch float,
    roll float,
    yaw float,
    motor1_pwm int,
    motor2_pwm int,
    motor3_pwm int,
    motor4_pwm int,
    primary key (log_id)
);