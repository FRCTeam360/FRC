package org.usfirst.frc.team360.robot.commands;

import org.usfirst.frc.team360.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class NavXPID extends Command {
	double speed = 0;
	double myLength = 0;
    public NavXPID(double length) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	myLength = length;
    	requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	speed = Robot.navxpidsubsystem.doPID(Robot.navx.getAngle(), myLength);
    	Robot.drivetrain.drive(speed, -speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return false;
    	//return Robot.navx.getAngle() + 1 >  myLength &&Robot.navx.getAngle() - 1 <  myLength;
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
