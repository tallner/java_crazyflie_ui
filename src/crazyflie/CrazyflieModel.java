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

    public void rampMotors(long thrust) {
        int thrust_mult = 1;
        int thrust_step = 50;
      //  long thrust = 15000;
        float pitch = 0;
        float roll = 0;
        float yawrate = 0;
        System.out.println("test");
        long oldtr = 0;

        // send packet with zero thrust to arm the copter
        this.mCrazyflie.sendPacket(new CommanderPacket(0, 0, 0, (char) oldtr));
        
        /*
        while (thrust >= 15000) {
        	this.mCrazyflie.sendPacket(new CommanderPacket(roll, pitch, yawrate, (char) thrust));
        	try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        	*/
        
        
  //      while (thrust >= 15000) {
            System.out.println("sendPacket: " + thrust);
            this.mCrazyflie.sendPacket(new CommanderPacket(roll, pitch, yawrate, (char) thrust));
            /*
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
          //  if (thrust >= 30000) {
          //      thrust_mult = -1;
          //  }
           // thrust += thrust_step * thrust_mult;
       // }
        
        
        //this.mCrazyflie.sendPacket(new CommanderPacket(0, 0, 0, (char) 0));
        // Make sure that the last packet leaves before the link is closed
        // since the message queue is not flushed before closing
   //     try {
  //          Thread.sleep(1000);
  //      } catch (InterruptedException e) {
  //          e.printStackTrace();
  //      }
        
    }
	
    @Override
	public void run() {
    	mCrazyflie.connect();
    	
    	while (!exit.get()) {
			
		}
    	mCrazyflie.disconnect();
	}
    
    /** start the underlying thread */
    public void start() {
       t.start();
      // System.out.println("Thread " + t.getName() + "is " + t.getState());
    }
    
 // for stopping the thread
    public void stop()
    {
        exit.set(true);
        
    }

    
    
}
