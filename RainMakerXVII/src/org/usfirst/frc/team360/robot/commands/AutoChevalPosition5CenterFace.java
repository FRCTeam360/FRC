package org.usfirst.frc.team360.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class AutoChevalPosition5CenterFace extends CommandGroup {
    
    public  AutoChevalPosition5CenterFace() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.
    	addSequential(new ShiftUp());
    	addSequential(new WaitCommand(.25));
    	addSequential(new ResetEncs());
    	addSequential(new DriveStraightPID(-.85, 180, 660));
    	addSequential(new IntakeArmDown());
    	addSequential(new ResetEncs());
    	addSequential(new WaitCommand(1));
    	addSequential(new DriveStraightPID(-.85, 180, 456));
    	addSequential(new IntakeArmUp());
    	addSequential(new ResetEncs());
    	addSequential(new DriveStraightPID(-.9, 180, 1337));
    	addSequential(new PIdNav2(20));
    	addSequential(new ResetNavx());
    	addSequential(new PIdNav(115));
    	addSequential(new ResetEncs());
    	addSequential(new DriveStraightPID(.9, 115, 1789));
    	addSequential(new PIdNav(160));
    	addSequential(new CameraAim());
        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
