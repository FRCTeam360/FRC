package org.usfirst.frc.team360.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class SideChickDrive extends Subsystem {
	RobotDrive SideChick;
	Joystick joyL, joyR;

    public void initDefaultCommand() {
    	SideChick = new RobotDrive(1,2,3,4);
    	joyL = new Joystick(1);
    	joyR = new Joystick(2);
    }
    
    public void autonomousPeriodic() {
    	
    }
    
    public void operatorControl() {
    		SideChick.tankDrive(joyL, joyR);
    		Timer.delay(0.01);
    }

}

