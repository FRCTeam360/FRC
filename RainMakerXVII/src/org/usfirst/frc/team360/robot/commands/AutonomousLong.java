package org.usfirst.frc.team360.robot.commands;

import org.usfirst.frc.team360.robot.Robot;

import edu.wpi.first.wpilibj.Timer; 
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousLong extends CommandGroup {
	
	public AutonomousLong() {
		// add commands here
		Robot.drivetrain.drive(1, 1);
		Timer.delay(5);
		Robot.drivetrain.stop();
	}
}