package org.usfirst.frc.team360.robot.commands;

import org.usfirst.frc.team360.robot.Robot;

import edu.wpi.first.wpilibj.Timer; 
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousShort extends CommandGroup {
	
	public AutonomousShort() {
		// add commands here
		Robot.drivetrain.drive(1, 1);
		Timer.delay(1);
		Robot.drivetrain.stop();
	}
}