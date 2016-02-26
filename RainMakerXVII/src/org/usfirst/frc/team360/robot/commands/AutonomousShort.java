package org.usfirst.frc.team360.robot.commands;

import org.usfirst.frc.team360.robot.Robot;

import edu.wpi.first.wpilibj.Timer; 
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team360.robot.subsystems.DriveTrain;

/**
 *
 */
@SuppressWarnings("unused")
public class AutonomousShort extends CommandGroup {
	
	public AutonomousShort() {
		// add commands here
		addSequential(new Drive(1, 3));
		addSequential(new DriveBackwards(1, 3));
		addSequential(new Drive(1, 3));
	//	addSequential(new Drive(1,1));
	}
}