package org.usfirst.frc.team360.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class AutoChevalPosition4RightFace extends CommandGroup {
    
    public  AutoChevalPosition4RightFace() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order
    	addSequential(new ShiftUp());
    	addSequential(new WaitCommand(.25));
    	addSequential(new ResetEncs());
    	addSequential(new DriveStraightPID(-.85, 180, 837));
    	addSequential(new IntakeArmDown());
    	addSequential(new ResetEncs());
    	addSequential(new WaitCommand(1));
    	addSequential(new DriveStraightPID(-.85, 180, 456));
    	addSequential(new IntakeArmUp());
    	addSequential(new ResetEncs());
    	addSequential(new DriveStraightPID(-.85, 180, 1337));
    	addSequential(new PIdNav2(20));
    	addSequential(new ResetNavx());
    	addSequential(new PIdNav(192));
    	addSequential(new ResetEncs());
    	addSequential(new DriveStraightPID(.85, 192, 2539));
    	addSequential(new PIdNav(115));
    	addSequential(new CameraAim());
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
