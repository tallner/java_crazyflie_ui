package crazyflie;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

import se.bitcraze.crazyflie.lib.crazyflie.Crazyflie;
import se.bitcraze.crazyflie.lib.crazyflie.Crazyflie.State;
import se.bitcraze.crazyflie.lib.crazyflie.DataListener;
import se.bitcraze.crazyflie.lib.crazyradio.ConnectionData;
import se.bitcraze.crazyflie.lib.crazyradio.Crazyradio;
import se.bitcraze.crazyflie.lib.crazyradio.RadioDriver;
import se.bitcraze.crazyflie.lib.crtp.CommanderPacket;
import se.bitcraze.crazyflie.lib.crtp.CrtpPacket;
import se.bitcraze.crazyflie.lib.crtp.CrtpPort;
import se.bitcraze.crazyflie.lib.usb.UsbLinkJava;

/* Features crazyflie
 * Connect
 * Disconnect
 * Start Log data
 * Start Write data
 */
/**
 * Simple example that connects to the Crazyflie on the given channel and data rate.
 * It prints the contents of the console.
 */
public class CrazyflieModel implements Runnable {

    private Crazyflie mCrazyflie;
    private StringBuffer consoleBuffer = new StringBuffer();
    
    private AtomicBoolean exit = new AtomicBoolean();
    private String name;
    private Thread t;
    
    private long thrust;
    private float pitch;
    private float roll;
    private float calibPitch;
    private float calibRoll;

    public CrazyflieModel(ConnectionData connectionData, String _name) {
        
    	name = _name;
    	t = new Thread(this, name);
    	exit.set(false);
    	

        mCrazyflie = new Crazyflie(new RadioDriver(new UsbLinkJava()));

        mCrazyflie.addDataListener(new DataListener(CrtpPort.CONSOLE) {

            @Override
            public void dataReceived(CrtpPacket packet) {
                byte[] payload = packet.getPayload();
                
                //skip packet when it only contains zeros
                if (containsOnly00(payload)) {
                	
                    return;
                }
                String trimmedText = new String(payload).trim();
                if (contains0A(payload)) {
                    consoleBuffer.append(trimmedText);
                    System.out.println(consoleBuffer);
                    consoleBuffer = new StringBuffer();
                } else {
                    consoleBuffer.append(trimmedText);
                    
                }
            }
        });

        System.out.println("Connecting to " + connectionData);

        mCrazyflie.setConnectionData(connectionData);
 

    }

    private boolean contains0A(byte[] payload) {
        for (byte b : payload) {
            if (b == 10) {
                return true;
            }
        }
        return false;
    }

    private boolean containsOnly00(byte[] payload) {
        for (byte b : payload) {
            if (b != 0) {
                return false;
            }
        }
        return true;
    }

    public Crazyflie getCrazyflie() {
        return this.mCrazyflie;
    }

    /*
    pitch --> fram/tillbaka, positiv höjer nosen dvs backar coptern
    roll --> sidled, positiv lyfter vänstra sidan dvs svänger höger
    yaw --> snurrar runt, positiv snurrar höger
    */
    
    public void setCalibrationData(float _calibRoll, float _calibPitch) {
    	//  myCrazyflie.setPitch((float) myRobo.getMouseY());
        //  myCrazyflie.setRoll((float) myRobo.getMouseX());
    	calibPitch = _calibPitch;
    	calibRoll = _calibRoll;
    	
    	//System.out.println("Pitch " + calibPitch + "// Roll" + calibRoll);
    }
    
    public void setPitch(double mousePos) {
    	//pitch --> fram/tillbaka, positiv höjer nosen dvs backar coptern
    	//pitch -10 - 10 degrees if scaled a 360 circle with 18
    	this.pitch = (float) Math.floor(((calibPitch - mousePos)/180));
		//System.out.println("Pitch="+pitch);
    }
    
    public void setThrust(long _thrust) {
		thrust = _thrust;
    }
    
    public void setRoll(double mousePos) {
    	//roll --> sidled, positiv lyfter vänstra sidan dvs svänger höger
    	//roll -10 - 10 degrees if scaled a 360 circle with 18
		this.roll = (float) Math.floor(((mousePos - calibRoll)/180));
	//	System.out.println("Roll="+roll);
    }
    
    private void runMotors(float roll,float pitch,float yawrate, long thrust) {
    	thrust = (thrust < 15000) ? 0 : thrust;
    	
    	/*
    	 * This command will set the attitude controller setpoint for the next 500ms. 
    	 * After 500ms without net setpoint, the Crazyflie will apply a setpoint with the same thrust but with roll/pitch/yawrate = 0, 
    	 * this will make the Crazyflie stop accelerate. 
    	 * After 2secons without new setpoint the Crazyflie will cut power to the motors.
    	 * thrust 10001 (next to no power) to 60000 (full power).
    	 * roll and pitch are in degrees
    	 * yawrate degrees/second
    	 */
    	

        // send packet with zero thrust to arm the copter
        this.mCrazyflie.sendPacket(new CommanderPacket(0, 0, 0, (char) 0));
    
      //  System.out.println("sendPacket: " + roll + pitch + thrust);
        this.mCrazyflie.sendPacket(new CommanderPacket(roll, pitch, yawrate, (char) thrust));
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.mCrazyflie.sendPacket(new CommanderPacket(0, 0, 0, (char) 0));
        // Make sure that the last packet leaves before the link is closed
        // since the message queue is not flushed before closing
       
    }
    
	
    @Override
	public void run() {
    	mCrazyflie.connect();
    	
    	while (!exit.get()) {
    		runMotors(this.roll,this.pitch,0, thrust);
		}
    	
    	mCrazyflie.disconnect();
    	
    	t.interrupt();
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

    
    
}
