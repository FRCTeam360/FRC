package org.usfirst.frc.team360.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class AutoDeadReconningBreachBAndDDefenses extends CommandGroup {

	public AutoDeadReconningBreachBAndDDefenses(){
		addSequential(new ShiftDown());
    	addSequential(new WaitCommand(.25));
    	addSequential( new AutoBreachBangBang(2));
	}
}
