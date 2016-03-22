package org.usfirst.frc.team360.robot.subsystems;

import org.usfirst.frc.team360.robot.Robot;
import org.usfirst.frc.team360.robot.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakeMotor extends Subsystem {
	VictorSP IntakeMotor = RobotMap.intakeMotor;
	
	
	public void runMotor(double speed){
		if(Robot.catapult.getCatapultPosition() == false){
			IntakeMotor.set(speed);
		} else {
			IntakeMotor.stopMotor();
		}
	
	}
	
    public void stop(){
    	IntakeMotor.stopMotor();
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    
    }
}

