package org.usfirst.frc.team360.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team360.robot.RobotMap;

import com.kauailabs.navx.frc.AHRS;

/**
 *
 */
public class navX extends Subsystem {
	AHRS ahrs = RobotMap.ahrs; 

	public double getAngle(){ 
		 return ahrs.getAngle();
		 
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
	 
}

