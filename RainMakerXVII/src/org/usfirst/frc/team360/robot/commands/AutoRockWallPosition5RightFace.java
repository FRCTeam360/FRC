package org.usfirst.frc.team360.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class AutoRockWallPosition5RightFace extends CommandGroup {
    
    public  AutoRockWallPosition5RightFace() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.
    	addSequential(new ShiftDown());
    	addSequential(new WaitCommand(.25));
    	addSequential(new ResetEncs());
    	addSequential(new DriveStraightPID(.8, 180, 2482));
    	addSequential(new ResetEncs());
    	addSequential(new DriveStraightPID(.4, 180, 428));
    	addSequential(new ShiftUp());
    	addSequential(new WaitCommand(.25));
    	addSequential(new PIdNav(186));
    	addSequential(new ResetEncs());
    	addSequential(new DriveStraightPID(.85, 186, 2158));
    	addSequential(new PIdNav(135));
    	addSequential(new CameraAim());
        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
