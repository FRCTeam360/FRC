package org.usfirst.frc.team360.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.DriverStation;
import com.kauailabs.navx.frc.AHRS;

/**
 *
 */
public class navX2 extends Subsystem {
	AHRS ahrs; 

	public void run(){ 
		 ahrs.getAngle();
		 
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
public void init(){ 
	 ahrs = new AHRS(SPI.Port.kMXP); /* Alternatives:  SPI.Port.kMXP, I2C.Port.kMXP or SerialPort.Port.kUSB */
}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
	 
}

