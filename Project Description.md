# Project description of the java_crazyflie_ui

This is an IoT program to read and write data from a Bitcraze drone  

Version 0.1  
This version is for the GRIT Advanced Java project.  
Simple control in a JavaFX UI.  
This version aims to set up a java program that communicates to the Bitcraze Crazyflie drone.  
Via the crazyflie API it is possible to read and write data to the drone.  
This data is showed on the GUI created in JavaFX and stored in a MySQL database if requested by the user.  
Additionally the aim is to create an API that could be used to control the drone remotely.  

Version later  
Autonomous flight (room measurement, person tracker etc)  
Needs additional hardware  

# Use cases
- Nothing, this is just for fun

# Features
JavaFX GUI - V0.1
- input control roll, pitch, yaw, thrust
- output battery level, sensor information
- input username
- input name for the flight

JavaFX GUI - Vlater
- button to start a autonomous flight
- enable remote control(API) 

MySQL database - V0.1
- store data from the current flight
- sensor data, username, flight details

API - Vlater
- create an API for remote control, test and document via Swagger
- read weather data from external API and show on GUI

# Frameworks and tools
 V0.1
 - Crazyflie library
- Java
- JavaFX
- MySQL

Vlater
- Swagger

