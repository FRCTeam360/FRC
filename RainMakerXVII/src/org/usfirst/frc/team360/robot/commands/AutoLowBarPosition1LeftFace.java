package org.usfirst.frc.team360.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class AutoLowBarPosition1LeftFace extends CommandGroup {
    
    public  AutoLowBarPosition1LeftFace() {
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
    	addSequential(new DriveStraightPID(.95, 180, 200));
    	addSequential(new IntakeArmDown());
    	addSequential(new ResetEncs());
    	addSequential(new DriveStraightPID(.95, 180, 2382));
    	addSequential(new PIdNav(194));
    	addSequential(new ResetEncs());
    	addSequential(new IntakeArmUp());
    	addSequential(new DriveStraightPID(.95, 194, 846));
    	addSequential(new PIdNav(220));
    	addSequential(new ResetEncs());
    	addSequential(new DriveStraightPID(.95, 220, 1926));
    	addSequential(new PIdNav(240));
    	addSequential(new CameraAim());
    	//addSequential(new Shoot());
        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
