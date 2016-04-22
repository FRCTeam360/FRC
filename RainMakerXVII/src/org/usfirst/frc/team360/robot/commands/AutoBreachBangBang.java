package org.usfirst.frc.team360.robot.commands;

import org.usfirst.frc.team360.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoBreachBangBang extends Command {
	Timer time; 
	double tirme = 0;
    public AutoBreachBangBang(double tirme) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.tirme = tirme;
    	requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	time = new Timer();
    	time.reset();
    	time.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.drive(-.9, -.9);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return time.get() > tirme;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
