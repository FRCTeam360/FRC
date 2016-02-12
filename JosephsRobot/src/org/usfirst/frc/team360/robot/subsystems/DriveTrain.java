package org.usfirst.frc.team360.robot.subsystems;

import org.usfirst.frc.team360.robot.OI;
import org.usfirst.frc.team360.robot.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
    VictorSP motor1 = RobotMap.motor1;
    VictorSP motor2 = RobotMap.motor2;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public void drive(){
		motor1.set(OI.joyR.getRawAxis(1));
		motor2.set(OI.joyL.getRawAxis(1));
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
