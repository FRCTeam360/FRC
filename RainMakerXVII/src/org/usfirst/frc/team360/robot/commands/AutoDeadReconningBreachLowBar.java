package org.usfirst.frc.team360.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class AutoDeadReconningBreachLowBar extends CommandGroup {

	public AutoDeadReconningBreachLowBar(){
		addSequential(new ShiftUp());
    	addSequential(new WaitCommand(.25));
       	addSequential( new AutoBreachBangBang(.25));
    	addSequential(new IntakeArmDown());
    	addSequential( new AutoBreachBangBang(4.5));
    	addParallel(new IntakeArmUp());
	}
}
