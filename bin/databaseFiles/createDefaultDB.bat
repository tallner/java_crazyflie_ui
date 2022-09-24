@ECHO OFF

SET mySQLpath="C:\Program Files\MySQL\MySQL Workbench 8.0\mysql.exe"
SET mySQLfilePath=.\sqlfiles
SET myPW="tallner"
SET myUS="root"
SET myDB="crazylog"

SET mySQLfileName_0=createDB.sql

%mySQLpath% --user=%myUS% --database=%myDB% --password=%myPW% < "%mySQLfilePath%\%mySQLfileName_0%"