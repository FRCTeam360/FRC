package org.usfirst.frc.team360.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class AutoBreachLowBar extends CommandGroup {
    
    public  AutoBreachLowBar() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
    
        // these will run in order.
    	addSequential(new ShiftUp());
    	addSequential(new WaitCommand(.25));
    	addSequential(new ResetEncs());
    	addSequential(new DriveStraightPID(.5, 180, 200));
    	addSequential(new IntakeArmDown());
    	addSequential(new ResetEncs());
    	addSequential(new DriveStraightPID(.5, 180, 2900));
    	addSequential(new IntakeArmUp());
        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
