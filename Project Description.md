# java_crazyflie_ui

V1 -> for the GRIT project
Simple control.
This version aims to set up a java program that communicates to the Bitcraze Crazyflie drone.
Via the crazyflie API it is possible to read and write data to the drone.
This data is showed on the GUI created in JavaFX and stored in a MySQL database if requested by the user.
Additionally the aim is to create an API that could be used to control the drone remotely.

V2 -> for later
Autonomous flight and room measurement
Needs additional hardware

# Use cases
- Nothing, this is just for fun

# Features
JavaFX GUI
- input control roll, pitch, yaw, thrust
- output battery level, sensor information
- button to start a autonomous flight
- input username
- input name for the flight
- enable remote control(API)

MySQL database
- store data from the current flight
- sensor data, username, flight details

API
- create an API for remote control, test and document via Swagger
- read weather data from external API and show on GUI

# Frameworks and tools
- Crazyflie library
- Java
- JavaFX
- Swagger
- MySQL
