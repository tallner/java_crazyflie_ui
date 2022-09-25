package crazyflie;


/*
acc.x
acc.y
acc.z
baro.asl
baro.pressure
baro.temp
controller.accelz
controller.actuatorThrust
controller.cmd_pitch
controller.cmd_roll
controller.cmd_thrust
controller.cmd_yaw
controller.ctr_yaw
controller.pitch
controller.pitchRate
controller.r_pitch
controller.r_roll
controller.r_yaw
controller.roll
controller.rollRate
controller.yaw
controller.yawRate
crtp.rxRate
crtp.txRate
ctrlINDI.cmd_pitch
ctrlINDI.cmd_roll
ctrlINDI.cmd_thrust
ctrlINDI.cmd_yaw
ctrlINDI.r_pitch
ctrlINDI.r_roll
ctrlINDI.r_yaw
ctrlMel.accelz
ctrlMel.cmd_pitch
ctrlMel.cmd_roll
ctrlMel.cmd_thrust
ctrlMel.cmd_yaw
ctrlMel.i_err_x
ctrlMel.i_err_y
ctrlMel.i_err_z
ctrlMel.r_pitch
ctrlMel.r_roll
ctrlMel.r_yaw
ctrlMel.zdx
ctrlMel.zdy
ctrlMel.zdz
ctrltarget.ax
ctrltarget.ay
ctrltarget.az
ctrltarget.pitch
ctrltarget.roll
ctrltarget.vx
ctrltarget.vy
ctrltarget.vz
ctrltarget.x
ctrltarget.y
ctrltarget.yaw
ctrltarget.z
ctrltargetZ.ax
ctrltargetZ.ay
ctrltargetZ.az
ctrltargetZ.vx
ctrltargetZ.vy
ctrltargetZ.vz
ctrltargetZ.x
ctrltargetZ.y
ctrltargetZ.z
ext_pos.X
ext_pos.Y
ext_pos.Z
extrx.ch0
extrx.ch1
extrx.ch2
extrx.ch3
extrx.pitch
extrx.roll
extrx.thrust
extrx.yaw
gyro.x
gyro.xRaw
gyro.xVariance
gyro.y
gyro.yRaw
gyro.yVariance
gyro.z
gyro.zRaw
gyro.zVariance
health.checkStops
health.motorPass
health.motorTestCount
health.motorVarXM1
health.motorVarXM2
health.motorVarXM3
health.motorVarXM4
health.motorVarYM1
health.motorVarYM2
health.motorVarYM3
health.motorVarYM4
locSrvZ.tick
mag.x
mag.y
mag.z
memTst.errCntW
pid_attitude.pitch_outD
pid_attitude.pitch_outI
pid_attitude.pitch_outP
pid_attitude.roll_outD
pid_attitude.roll_outI
pid_attitude.roll_outP
pid_attitude.yaw_outD
pid_attitude.yaw_outI
pid_attitude.yaw_outP
pid_rate.pitch_outD
pid_rate.pitch_outI
pid_rate.pitch_outP
pid_rate.roll_outD
pid_rate.roll_outI
pid_rate.roll_outP
pid_rate.yaw_outD
pid_rate.yaw_outI
pid_rate.yaw_outP
pm.batteryLevel
pm.chargeCurrent
pm.extCurr
pm.extVbat
pm.extVbatMV
pm.state
pm.vbat
pm.vbatMV
posCtl.VXd
posCtl.VXi
posCtl.VXp
posCtl.VZd
posCtl.VZi
posCtl.VZp
posCtl.Xd
posCtl.Xi
posCtl.Xp
posCtl.Yd
posCtl.Yi
posCtl.Yp
posCtl.Zd
posCtl.Zi
posCtl.Zp
posCtl.targetVX
posCtl.targetVY
posCtl.targetVZ
posCtl.targetX
posCtl.targetY
posCtl.targetZ
posCtrlIndi.T_incremented
posCtrlIndi.T_inner
posCtrlIndi.T_inner_f
posCtrlIndi.T_tilde
posCtrlIndi.accErr_x
posCtrlIndi.accErr_y
posCtrlIndi.accErr_z
posCtrlIndi.accFT_x
posCtrlIndi.accFT_y
posCtrlIndi.accFT_z
posCtrlIndi.accF_x
posCtrlIndi.accF_y
posCtrlIndi.accF_z
posCtrlIndi.accRef_x
posCtrlIndi.accRef_y
posCtrlIndi.accRef_z
posCtrlIndi.accS_x
posCtrlIndi.accS_y
posCtrlIndi.accS_z
posCtrlIndi.angF_pitch
posCtrlIndi.angF_roll
posCtrlIndi.angF_yaw
posCtrlIndi.angS_pitch
posCtrlIndi.angS_roll
posCtrlIndi.angS_yaw
posCtrlIndi.cmd_phi
posCtrlIndi.cmd_theta
posCtrlIndi.gyr_p
posCtrlIndi.gyr_q
posCtrlIndi.gyr_r
posCtrlIndi.phi_tilde
posCtrlIndi.posRef_x
posCtrlIndi.posRef_y
posCtrlIndi.posRef_z
posCtrlIndi.theta_tilde
posCtrlIndi.velRef_x
posCtrlIndi.velRef_y
posCtrlIndi.velRef_z
posCtrlIndi.velS_x
posCtrlIndi.velS_y
posCtrlIndi.velS_z
posEstAlt.estVZ
posEstAlt.estimatedZ
posEstAlt.velocityZ
pwm.m1_pwm
pwm.m2_pwm
pwm.m3_pwm
pwm.m4_pwm
radio.isConnected
radio.rssi
range.back
range.front
range.left
range.right
range.up
range.zrange
sensfusion6.accZbase
sensfusion6.gravityX
sensfusion6.gravityY
sensfusion6.gravityZ
sensfusion6.isCalibrated
sensfusion6.isInit
sensfusion6.qw
sensfusion6.qx
sensfusion6.qy
sensfusion6.qz
sitAw.ARDetected
sitAw.FFAccWZDetected
sitAw.TuDetected
stabilizer.intToOut
stabilizer.pitch
stabilizer.roll
stabilizer.rtStab
stabilizer.thrust
stabilizer.yaw
stateEstimate.ax
stateEstimate.ay
stateEstimate.az
stateEstimate.pitch
stateEstimate.qw
stateEstimate.qx
stateEstimate.qy
stateEstimate.qz
stateEstimate.roll
stateEstimate.vx
stateEstimate.vy
stateEstimate.vz
stateEstimate.x
stateEstimate.y
stateEstimate.yaw
stateEstimate.z
stateEstimateZ.ax
stateEstimateZ.ay
stateEstimateZ.az
stateEstimateZ.quat
stateEstimateZ.ratePitch
stateEstimateZ.rateRoll
stateEstimateZ.rateYaw
stateEstimateZ.vx
stateEstimateZ.vy
stateEstimateZ.vz
stateEstimateZ.x
stateEstimateZ.y
stateEstimateZ.z
sys.armed
sys.canfly
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicBoolean;

import database.LoggerObject;
import databaseHelpers.DatabaseHelper;
import se.bitcraze.crazyflie.lib.crazyflie.Crazyflie;
import se.bitcraze.crazyflie.lib.log.LogConfig;
import se.bitcraze.crazyflie.lib.log.LogListener;
import se.bitcraze.crazyflie.lib.log.Logg;
import se.bitcraze.crazyflie.lib.toc.Toc;
import se.bitcraze.crazyflie.lib.toc.VariableType;

/**
 * It prints all elements of the Logg table of contents.
 * Then it adds log configurations:
 * * the battery voltage
 * * the barometer temperature & pressue
 * and prints the values to the console.
 */
public class Logging implements Runnable{

    private Crazyflie myCrazyflie;
    
    private AtomicBoolean exit = new AtomicBoolean();
    private Thread t;
    
    private final LogConfig lcLogger = new LogConfig("Logger", 1000);
    
    private float vbat;
    private int batteryLevel;
    private float pitch;
    private float roll;
    private float yaw;
    private long m1_pwm;
    private long m2_pwm; 
    private long m3_pwm; 
    private long m4_pwm;
    
    private Logg logg;
    private LoggerObject myDBLogger;
   

    /**
     * Initialize and run the example with the specified connection data
     *
     * @param connectionData
     */
    public Logging(Crazyflie _myCrazyflie) {
        
        myCrazyflie = _myCrazyflie;
        
        logg = this.myCrazyflie.getLogg();

        t = new Thread(this, "LoggerThread");
    	exit.set(false);
    	
    	printLoggingTOC();
    	addLogConfigs();
    	
    	myDBLogger = new LoggerObject(DatabaseHelper.DbConnect("crazylog"));
    }

    private void printLoggingTOC() {
        final Toc logToc = this.myCrazyflie.getLogg().getToc();
        List<String> keyList = new ArrayList<String>(logToc.getTocElementMap().keySet());
        Collections.sort(keyList);
        System.out.println("Number of logging elements: " + keyList.size());

        // Print all logging elements
        for(String completeName : keyList) {
            System.out.println(completeName);
        }
        
    }

    private void addLogConfigs() {
        // The definition of the logconfig can be made before the setup is finished
        
        lcLogger.addVariable("pm.vbat", VariableType.FLOAT);
    //    lcLogger.addVariable("pm.batteryLevel", VariableType.UINT8_T);

        lcLogger.addVariable("stabilizer.pitch", VariableType.FLOAT);
        lcLogger.addVariable("stabilizer.roll", VariableType.FLOAT);
        lcLogger.addVariable("stabilizer.yaw", VariableType.FLOAT);
              
        lcLogger.addVariable("pwm.m1_pwm", VariableType.UINT32_T);
        lcLogger.addVariable("pwm.m2_pwm", VariableType.UINT32_T);
    //    lcLogger.addVariable("pwm.m3_pwm", VariableType.UINT32_T);
   //     lcLogger.addVariable("pwm.m4_pwm", VariableType.UINT32_T);
        /**
         *  Adding the configuration cannot be done until a Crazyflie is connected and
         *  the setup is finished, since we need to check that the variables we
         *  would like to log are in the TOC.
         */
        if (logg != null) {
            logg.addConfig(lcLogger);
            

            System.out.println("\nNumber of logConfigs: " + logg.getLogConfigs().size());

            logg.addLogListener(new LogListener() {

                @Override
                public void logConfigAdded(LogConfig logConfig) {
                    String msg = "";
                    if(logConfig.isAdded()) {
                        msg = "' added";
                    } else {
                        msg = "' deleted";
                    }
                    System.out.println("LogConfig '" + logConfig.getName() + " (ID: " + logConfig.getId() + ")" + msg);
                }

                @Override
                public void logConfigError(LogConfig logConfig) {
                    System.err.println("Error when logging '" + logConfig.getName() + "': " + logConfig.getErrMsg());
                }

                @Override
                public void logConfigStarted(LogConfig logConfig) {
                    String msg = "";
                    if(logConfig.isStarted()) {
                        msg = "' started";
                    } else {
                        msg = "' stopped";
                    }
                    System.out.println("LogConfig '" + logConfig.getName() + " (ID: " + logConfig.getId() + ")" + msg);
                }

                @Override
                public void logDataReceived(LogConfig logConfig, Map<String, Number> data, int timestamp) {
                    System.out.println("LogConfig '" + logConfig.getName()  + "', timestamp: " + timestamp + ", data : ");
                    
                    // TODO sort?
                    for (Entry<String, Number> entry : data.entrySet()) {
                        System.out.println("\t Name: " + entry.getKey() + ", data: " + entry.getValue());
                        if (entry.getKey().equals("pm.vbat")) vbat = (float) entry.getValue();
                        if (entry.getKey().equals("pm.batteryLevel")) batteryLevel = (int) entry.getValue();
                        if (entry.getKey().equals("stabilizer.pitch")) pitch = (float) entry.getValue();
                        if (entry.getKey().equals("stabilizer.roll")) roll = (float) entry.getValue();
                        if (entry.getKey().equals("stabilizer.yaw")) yaw = (float) entry.getValue();
                        if (entry.getKey().equals("pwm.m1_pwm")) m1_pwm = (long) entry.getValue();
                        if (entry.getKey().equals("pwm.m2_pwm")) m2_pwm = (long) entry.getValue();
                        if (entry.getKey().equals("pwm.m3_pwm")) m3_pwm = (long) entry.getValue();
                        if (entry.getKey().equals("pwm.m4_pwm")) m4_pwm = (long) entry.getValue();
                        
                    }
                    
                    System.out.println("-------------------------------------------------------------------------------");
                    
    				myDBLogger.createLog(
    						"christian", 
    						vbat, 
    						batteryLevel, 
    						pitch, 
    						roll, 
    						yaw, 
    						(int) m1_pwm, 
    						(int) m2_pwm, 
    						(int) m3_pwm, 
    						(int) m4_pwm);
                }

            });

        }
    }

    
    /** start the underlying thread */
    public void start() {
    	exit.set(false);
    	t.start();
    }
    
 // for stopping the thread
    public void stop()
    {
        exit.set(true);
    }
    
	@Override
	public void run() {

     // Start the logging
        logg.start(lcLogger);
        
		
		while (!exit.get()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
		
		logg.stop(lcLogger);
        logg.delete(lcLogger);
		
	}



}
