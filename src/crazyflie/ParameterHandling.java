package crazyflie;

import java.io.IOException;

/*
 *cpu.flash                :       1024 TOC id: 7
activeMarker.back        :          3 TOC id: 211
activeMarker.front       :          1 TOC id: 210
activeMarker.left        :          4 TOC id: 212
activeMarker.mode        :          3 TOC id: 214
activeMarker.poll        :          0 TOC id: 215
activeMarker.right       :          2 TOC id: 213
cmdrCPPM.angPitch        :       50.0 TOC id: 32
cmdrCPPM.angRoll         :       50.0 TOC id: 31
cmdrCPPM.ratePitch       :      720.0 TOC id: 29
cmdrCPPM.rateRoll        :      720.0 TOC id: 28
cmdrCPPM.rateYaw         :      400.0 TOC id: 30
colAv.bboxMaxX           : 3.4028235E38 TOC id: 166
colAv.bboxMaxY           : 3.4028235E38 TOC id: 167
colAv.bboxMaxZ           : 3.4028235E38 TOC id: 168
colAv.bboxMinX           : -3.4028235E38 TOC id: 163
colAv.bboxMinY           : -3.4028235E38 TOC id: 164
colAv.bboxMinZ           : -3.4028235E38 TOC id: 165
colAv.ellipsoidX         :        0.3 TOC id: 160
colAv.ellipsoidY         :        0.3 TOC id: 161
colAv.ellipsoidZ         :        0.9 TOC id: 162
colAv.enable             :          0 TOC id: 159
colAv.horizon            :        1.0 TOC id: 169
colAv.maxPeerLocAge      :       5000 TOC id: 172
colAv.maxSpeed           :        0.5 TOC id: 170
colAv.sidestepThrsh      :       0.25 TOC id: 171
colAv.vorIters           :        100 TOC id: 174
colAv.vorTol             :     1.0E-5 TOC id: 173
commander.enHighLevel    :          0 TOC id: 19
controller.tiltComp      :          0 TOC id: 96
cpu.flash                :       1024 TOC id: 7
cpu.id0                  :    5308454 TOC id: 8
cpu.id1                  : 1395871751 TOC id: 9
cpu.id2                  :  540619824 TOC id: 10
ctrlINDI.act_dyn_p       :    0.03149 TOC id: 131
ctrlINDI.act_dyn_q       :    0.03149 TOC id: 132
ctrlINDI.act_dyn_r       :    0.03149 TOC id: 133
ctrlINDI.bound_ctrl_input:    32000.0 TOC id: 117
ctrlINDI.filt_cutoff     :        8.0 TOC id: 134
ctrlINDI.filt_cutoff_r   :        8.0 TOC id: 135
ctrlINDI.g1_p            :  0.0066146 TOC id: 121
ctrlINDI.g1_q            :  0.0052125 TOC id: 122
ctrlINDI.g1_r            :  -0.001497 TOC id: 123
ctrlINDI.g2              :  4.3475E-5 TOC id: 124
ctrlINDI.outerLoopActive :          0 TOC id: 136
ctrlINDI.pitch_kp        :        5.0 TOC id: 119
ctrlINDI.ref_err_p       :       24.0 TOC id: 125
ctrlINDI.ref_err_q       :       24.0 TOC id: 126
ctrlINDI.ref_err_r       :       24.0 TOC id: 127
ctrlINDI.ref_rate_p      :       14.0 TOC id: 128
ctrlINDI.ref_rate_q      :       14.0 TOC id: 129
ctrlINDI.ref_rate_r      :       14.0 TOC id: 130
ctrlINDI.roll_kp         :        5.0 TOC id: 118
ctrlINDI.thrust_threshold:      300.0 TOC id: 116
ctrlINDI.yaw_kp          :        5.0 TOC id: 120
ctrlMel.i_range_m_xy     :        1.0 TOC id: 114
ctrlMel.i_range_m_z      :     1500.0 TOC id: 115
ctrlMel.i_range_xy       :        2.0 TOC id: 100
ctrlMel.i_range_z        :        0.4 TOC id: 104
ctrlMel.kR_xy            :    70000.0 TOC id: 107
ctrlMel.kR_z             :    60000.0 TOC id: 108
ctrlMel.kd_omega_rp      :      200.0 TOC id: 113
ctrlMel.kd_xy            :        0.2 TOC id: 98
ctrlMel.kd_z             :        0.4 TOC id: 102
ctrlMel.ki_m_xy          :        0.0 TOC id: 111
ctrlMel.ki_m_z           :      500.0 TOC id: 112
ctrlMel.ki_xy            :       0.05 TOC id: 99
ctrlMel.ki_z             :       0.05 TOC id: 103
ctrlMel.kp_xy            :        0.4 TOC id: 97
ctrlMel.kp_z             :       1.25 TOC id: 101
ctrlMel.kw_xy            :    20000.0 TOC id: 109
ctrlMel.kw_z             :    12000.0 TOC id: 110
ctrlMel.mass             :      0.027 TOC id: 105
ctrlMel.massThrust       :   132000.0 TOC id: 106
deck.bcAIDeck            :          0 TOC id: 216
deck.bcBuzzer            :          0 TOC id: 190
deck.bcCPPM              :          0 TOC id: 192
deck.bcDWM1000           :          0 TOC id: 197
deck.bcFlow              :          0 TOC id: 202
deck.bcFlow2             :          1 TOC id: 203
deck.bcGTGPS             :          0 TOC id: 191
deck.bcLedRing           :          0 TOC id: 177
deck.bcMultiranger       :          0 TOC id: 208
deck.bcOA                :          0 TOC id: 207
deck.bcUSD               :          0 TOC id: 193
deck.bcZRanger           :          0 TOC id: 195
deck.bcZRanger2          :          1 TOC id: 196
deck.bdLighthouse4       :          0 TOC id: 209
firmware.modified        :          0 TOC id: 219
firmware.revision0       :          0 TOC id: 217
firmware.revision1       :          0 TOC id: 218
flightmode.althold       :          0 TOC id: 20
flightmode.posSet        :          0 TOC id: 22
flightmode.poshold       :          0 TOC id: 21
flightmode.stabModePitch :          1 TOC id: 26
flightmode.stabModeRoll  :          1 TOC id: 25
flightmode.stabModeYaw   :          0 TOC id: 27
flightmode.yawMode       :          2 TOC id: 23
flightmode.yawRst        :          0 TOC id: 24
health.startPropTest     :          0 TOC id: 58
hlCommander.vland        :        0.5 TOC id: 176
hlCommander.vtoff        :        0.5 TOC id: 175
imu_sensors.BMP388       :          0 TOC id: 6
imu_sensors.HMC5883L     :          0 TOC id: 1
imu_sensors.MS5611       :          0 TOC id: 2
imu_tests.HMC5883L       :          0 TOC id: 4
imu_tests.MPU6500        :          0 TOC id: 3
imu_tests.MS5611         :          0 TOC id: 5
kalman.initialX          :        0.0 TOC id: 153
kalman.initialY          :        0.0 TOC id: 154
kalman.initialYaw        :        0.0 TOC id: 156
kalman.initialZ          :        0.0 TOC id: 155
kalman.mNBaro            :        2.0 TOC id: 150
kalman.mNGyro_rollpitch  :        0.1 TOC id: 151
kalman.mNGyro_yaw        :        0.1 TOC id: 152
kalman.maxPos            :      100.0 TOC id: 157
kalman.maxVel            :       10.0 TOC id: 158
kalman.pNAcc_xy          :        0.5 TOC id: 145
kalman.pNAcc_z           :        1.0 TOC id: 146
kalman.pNAtt             :        0.0 TOC id: 149
kalman.pNPos             :        0.0 TOC id: 148
kalman.pNVel             :        0.0 TOC id: 147
kalman.quadIsFlying      :          0 TOC id: 144
kalman.resetEstimation   :          0 TOC id: 143
lighthouse.method        :          1 TOC id: 220
lighthouse.sweepStd      :     4.0E-4 TOC id: 221
lighthouse.sweepStd2     :      0.001 TOC id: 222
locSrv.enLhAngleStream   :          0 TOC id: 34
locSrv.enRangeStreamFP32 :          0 TOC id: 33
locSrv.extPosStdDev      :       0.01 TOC id: 35
locSrv.extQuatStdDev     :     0.0045 TOC id: 36
loco.mode                :          0 TOC id: 198
memTst.resetW            :          0 TOC id: 18
motion.adaptive          :          0 TOC id: 205
motion.disable           :          0 TOC id: 204
motion.flowStdFixed      :        2.0 TOC id: 206
motorPowerSet.enable     :          0 TOC id: 137
motorPowerSet.m1         :          0 TOC id: 138
motorPowerSet.m2         :          0 TOC id: 139
motorPowerSet.m3         :          0 TOC id: 140
motorPowerSet.m4         :          0 TOC id: 141
pid_attitude.pitch_kd    :        0.0 TOC id: 42
pid_attitude.pitch_ki    :        3.0 TOC id: 41
pid_attitude.pitch_kp    :        6.0 TOC id: 40
pid_attitude.roll_kd     :        0.0 TOC id: 39
pid_attitude.roll_ki     :        3.0 TOC id: 38
pid_attitude.roll_kp     :        6.0 TOC id: 37
pid_attitude.yaw_kd      :       0.35 TOC id: 45
pid_attitude.yaw_ki      :        1.0 TOC id: 44
pid_attitude.yaw_kp      :        6.0 TOC id: 43
pid_rate.pitch_kd        :        2.5 TOC id: 51
pid_rate.pitch_ki        :      500.0 TOC id: 50
pid_rate.pitch_kp        :      250.0 TOC id: 49
pid_rate.roll_kd         :        2.5 TOC id: 48
pid_rate.roll_ki         :      500.0 TOC id: 47
pid_rate.roll_kp         :      250.0 TOC id: 46
pid_rate.yaw_kd          :        0.0 TOC id: 54
pid_rate.yaw_ki          :       16.7 TOC id: 53
pid_rate.yaw_kp          :      120.0 TOC id: 52
posCtlPid.rpLimit        :       20.0 TOC id: 78
posCtlPid.thrustBase     :      36000 TOC id: 76
posCtlPid.thrustMin      :      20000 TOC id: 77
posCtlPid.xKd            :        0.0 TOC id: 69
posCtlPid.xKi            :        0.0 TOC id: 68
posCtlPid.xKp            :        2.0 TOC id: 67
posCtlPid.xyVelMax       :        1.0 TOC id: 79
posCtlPid.yKd            :        0.0 TOC id: 72
posCtlPid.yKi            :        0.0 TOC id: 71
posCtlPid.yKp            :        2.0 TOC id: 70
posCtlPid.zKd            :        0.0 TOC id: 75
posCtlPid.zKi            :        0.5 TOC id: 74
posCtlPid.zKp            :        2.0 TOC id: 73
posCtlPid.zVelMax        :        1.0 TOC id: 80
posCtrlIndi.K_dxi_x      :        5.0 TOC id: 93
posCtrlIndi.K_dxi_y      :        5.0 TOC id: 94
posCtrlIndi.K_dxi_z      :        5.0 TOC id: 95
posCtrlIndi.K_xi_x       :        1.0 TOC id: 90
posCtrlIndi.K_xi_y       :        1.0 TOC id: 91
posCtrlIndi.K_xi_z       :        1.0 TOC id: 92
posEstAlt.estAlphaAsl    :      0.997 TOC id: 62
posEstAlt.estAlphaZr     :        0.9 TOC id: 63
posEstAlt.vAccDeadband   :       0.04 TOC id: 66
posEstAlt.velFactor      :        1.0 TOC id: 64
posEstAlt.velZAlpha      :      0.995 TOC id: 65
powerDist.idleThrust     :          0 TOC id: 142
ring.effect              :          6 TOC id: 178
ring.emptyCharge         :        3.1 TOC id: 185
ring.fadeColor           :          0 TOC id: 187
ring.fadeTime            :        0.5 TOC id: 188
ring.fullCharge          :        4.2 TOC id: 186
ring.glowstep            :       0.05 TOC id: 184
ring.headlightEnable     :          0 TOC id: 183
ring.neffect             :          0 TOC id: 179
ring.solidBlue           :         20 TOC id: 182
ring.solidGreen          :         20 TOC id: 181
ring.solidRed            :         20 TOC id: 180
sensfusion6.baseZacc     :        1.0 TOC id: 57
sensfusion6.ki           :      0.002 TOC id: 56
sensfusion6.kp           :        0.8 TOC id: 55
sound.effect             :          0 TOC id: 13
sound.freq               :       4000 TOC id: 15
sound.neffect            :         14 TOC id: 14
sound.ratio              :          0 TOC id: 16
stabilizer.controller    :          1 TOC id: 60
stabilizer.estimator     :          2 TOC id: 59
stabilizer.stop          :          0 TOC id: 61
system.forceArm          :          0 TOC id: 12
system.highlight         :          0 TOC id: 189
system.selftestPassed    :          1 TOC id: 11
system.taskDump          :          0 TOC id: 17
tdoaEngine.logId         :          0 TOC id: 199
tdoaEngine.logOthrId     :          0 TOC id: 200
tdoaEngine.matchAlgo     :          0 TOC id: 201
usd.logging              :          0 TOC id: 194
velCtlPid.vxKd           :        0.0 TOC id: 83
velCtlPid.vxKi           :        1.0 TOC id: 82
velCtlPid.vxKp           :       25.0 TOC id: 81
velCtlPid.vyKd           :        0.0 TOC id: 86
velCtlPid.vyKi           :        1.0 TOC id: 85
velCtlPid.vyKp           :       25.0 TOC id: 84
velCtlPid.vzKd           :        0.0 TOC id: 89
velCtlPid.vzKi           :       15.0 TOC id: 88
velCtlPid.vzKp           :       25.0 TOC id: 87
 */

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import se.bitcraze.crazyflie.lib.crazyflie.Crazyflie;
import se.bitcraze.crazyflie.lib.param.ParamListener;
import se.bitcraze.crazyflie.lib.toc.Toc;
import se.bitcraze.crazyflie.lib.toc.TocElement;
import se.bitcraze.crazyflie.lib.toc.VariableType;
import se.bitcraze.crazyflie.lib.toc.VariableTypeTest;

/**
 * Simple example that connects to the Crazyflie on the given channel and data rate.
 * It triggers reading of all the parameters and displays their values. It then modifies
 * one parameter and reads back it's value. Finally it disconnects.
 */
public class ParameterHandling implements Runnable{

    private Crazyflie mCrazyflie;
    private AtomicBoolean exit = new AtomicBoolean();
    private List<String[]> mParamCheckList = new ArrayList<String[]>();
    private List<String> mParamGroups = new ArrayList<String>();
    
    private Thread t;

    /**
     * Initialize and run the example with the specified connection data
     *
     * @param connectionData
     */
    public ParameterHandling(Crazyflie _myCrazyflie) {
        
        mCrazyflie = _myCrazyflie;
        
        
        t = new Thread(this, "ParameterThread");
    	exit.set(false);
    }

    private void readAllParameters() {
        // You can register a callback for a specific group.name combo
        this.mCrazyflie.getParam().addParamListener(new ParamListener("cpu", "flash") {
            @Override
            public void updated(String name, Number value) {
                System.out.println("The connected Crazyflie has " + value + "kb of flash.\n");
                mCrazyflie.getParam().removeParamListeners("cpu", "flash");
            
            }
        });
        this.mCrazyflie.getParam().requestParamUpdate("cpu.flash");

        //TODO: improve/simplify
        final Toc paramToc = this.mCrazyflie.getParam().getToc();
        List<String> keyList = new ArrayList<String>(paramToc.getTocElementMap().keySet());
        Collections.sort(keyList);
        System.out.println("Number of parameters: " + keyList.size());
        

        // Print all parameters and their current values
        for(String completeName : keyList) {
            
            String[] split = completeName.split("\\.");
            String group = split[0];
            
           // System.out.println(completeName);
            String paramTocElement = paramToc.getElementByCompleteName(completeName).toString();
            String[] tocarr = paramTocElement.split("\\, ",0);
            String[] variableInfo = {completeName, tocarr[1]};
            
            mParamCheckList.add(variableInfo);

            mParamGroups.add(group);
            
            this.mCrazyflie.getParam().addParamListener(new ParamListener(group, null) {
                @Override
                public void updated(String name, Number value) {
                    System.out.println(String.format("%-25s", name) + ": " + String.format("%10s", value.toString()) + " TOC id: " + paramToc.getElementId(name));
                }
            });
            this.mCrazyflie.getParam().requestParamUpdate(completeName);

        }
        
    }

    public void setValue (String paramName,String paramValue) {
        String dataType = "Parameter not found";
        Number value = null;
        
        //find the correct datatype
    	for (String[] item : mParamCheckList) {
			if (item[0].equals(paramName))
    			dataType = item[1];
		}
    	
    	if (dataType.equals("Parameter not found"))
    		return ;
    	else {
    		
    		switch (dataType) {
				case "UINT8_T" -> {value = Byte.parseByte(paramValue);}
				case "UINT16_T" -> {value = Short.parseShort(paramValue);}
				case "UINT32_T" -> {value = Integer.parseInt(paramValue);}
				case "INT8_T" -> {value = Byte.parseByte(paramValue);}
				case "INT32_T" -> {value = Integer.parseInt(paramValue);}
				case "FLOAT" -> {value = Float.parseFloat(paramValue);}
				default ->
					throw new IllegalArgumentException("Unexpected type: " + dataType);
    		}
    		mCrazyflie.getParam().setValue(paramName, value);
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
		// TODO Auto-generated method stub
		readAllParameters();
		/*
		while (!exit.get()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
		*/
	}
}
