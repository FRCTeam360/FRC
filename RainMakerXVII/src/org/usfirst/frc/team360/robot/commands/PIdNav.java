package org.usfirst.frc.team360.robot.commands;

import org.usfirst.frc.team360.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PIdNav extends Command {
	double point = 0;
	double targetAngle = 0;
    public PIdNav(double point) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    	if(point > 360){
    		point = point - 360;
    	} else if(point < 1){
    		point = point + 360;
    	}
    	this.point = point;
    	requires(Robot.drivetrain);
    }
    double speed = 0;
    double kPNavX = .0234;
    double integrel = 0;
    double kINavX = 0.000002;
    double prevError = 0;
    // Called just before this Command runs the first time
    protected void initialize() {
    }
    double error = 0;
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(point > Robot.navx.getAngle() && point - Robot.navx.getAngle() <= 180){
    		error = point - Robot.navx.getAngle();
    	} else if(point < Robot.navx.getAngle() && Robot.navx.getAngle()-point >= 180){
    		error = point + 360 - Robot.navx.getAngle();
    	} else if(point < Robot.navx.getAngle() && Robot.navx.getAngle()-point < 180){
    		error = -1 * (Robot.navx.getAngle() - point);
    	} else if(point > Robot.navx.getAngle() && point - Robot.navx.getAngle() > 180){
    		error = -1 * (Robot.navx.getAngle() + 360 - point);
    	}
    //	speed =  .5;
    	integrel += error * kINavX ;
    	speed = kPNavX * error + integrel;
    	if(speed > 1){
    		speed = 1;
    	} else if(speed < -1){
    		speed = -1;
    	} 
    	Robot.drivetrain.drive(-speed, speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return  Robot.navx.getAngle() < point + .5 && Robot.navx.getAngle() > point - .5;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}