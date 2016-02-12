package org.usfirst.frc.team360.robot.commands;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem; 
import org.usfirst.frc.team360.robot.RobotMap;
import org.usfirst.frc.team360.robot.*; 



/**
 *
 */
public class SetMotorByNavX extends Command {	
	VictorSP motorR1 = RobotMap.motorR1;
	VictorSP motorR2 = RobotMap.motorR2;
	VictorSP motorL1 = RobotMap.motorL1;
	VictorSP motorL2 = RobotMap.motorL2;
	
    public SetMotorByNavX() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	//requires(navX);
    	
    }
          // Put methods for controlling this su
    

    // Called just before this Command runs the first time
    protected void initialize() {	
   
    }
    
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//setDirecton = getRange / cos()
    			motorR1.set(Robot.navx.getAngle()/360); 
    			motorR2.set(Robot.navx.getAngle()/360);
    			motorL1.set(Robot.navx.getAngle()/360);
    			motorL2.set(Robot.navx.getAngle()/360);
    	//position_X += velocity_X
    	//position_Y += velocity_Y
    			
    	//velocity_X = velocity*cos(angle)
    	//velocity_Y = velocity*sin(angle)
    					
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
