
package org.usfirst.frc.team360.robot;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot; 

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team360.robot.commands.CatapultDown;
import org.usfirst.frc.team360.robot.commands.CatapultUp;
import org.usfirst.frc.team360.robot.commands.IntakeArmDown;
import org.usfirst.frc.team360.robot.commands.IntakeArmUp;
import org.usfirst.frc.team360.robot.commands.IntakeMotors;
import org.usfirst.frc.team360.robot.commands.JoystickTankDrive;
import org.usfirst.frc.team360.robot.commands.NavXPID;
import org.usfirst.frc.team360.robot.commands.Pressurize;
import org.usfirst.frc.team360.robot.commands.PrintNavXAngle;
import org.usfirst.frc.team360.robot.commands.ShiftDown;
import org.usfirst.frc.team360.robot.commands.ShiftUp;
import org.usfirst.frc.team360.robot.commands.getEncs;
import org.usfirst.frc.team360.robot.subsystems.Catapult;
import org.usfirst.frc.team360.robot.subsystems.DriveTrain;
import org.usfirst.frc.team360.robot.subsystems.IntakeArms;
import org.usfirst.frc.team360.robot.subsystems.IntakeMotor;
import org.usfirst.frc.team360.robot.subsystems.NavX;
import org.usfirst.frc.team360.robot.subsystems.NavXPIDSubsystem;
import org.usfirst.frc.team360.robot.subsystems.Pneumatics;
import org.usfirst.frc.team360.robot.subsystems.SuperShifter;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static DriveTrain drivetrain;
	public static SuperShifter supershifter;
	public static Pneumatics pneumatics;
	public static Catapult catapult;
	public static IntakeArms intakearm;
	public static IntakeMotor intakemotor; 
	public static NavX navx;
	public static NavXPIDSubsystem navxpidsubsystem;
	
    Command joysticktankdrive;
    Command pressurize;
    Command shiftup;
    Command shiftdown;
    Command catapultup;
    Command catapultdown; 
    Command intakearmup; 
    Command intakearmdown;
    Command intakemotors;
    Command printnavxangle;
    Command getencs;
    Command navxpid;
    
    CameraServer server;
	public static OI oi;

    /**
     * This func
     * tion is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        // instantiate the command used for the autonomous period
    	server = CameraServer.getInstance();
    	server.setQuality(50);
    	server.startAutomaticCapture("cam0");
    	
    	supershifter = new SuperShifter();
    	pneumatics = new Pneumatics();
    	drivetrain = new DriveTrain();
    	catapult = new Catapult();
    	intakearm = new IntakeArms();
    	intakemotor = new IntakeMotor();
    	navx = new NavX();
    	navxpidsubsystem = new NavXPIDSubsystem();
    	
    	
    	joysticktankdrive = new JoystickTankDrive();
        pressurize = new Pressurize();
        shiftup = new ShiftUp();
        shiftdown = new ShiftDown();
        catapultdown = new CatapultDown();
        catapultup = new CatapultUp();
        intakearmdown = new IntakeArmDown();
        navxpid = new NavXPID(180);
        intakearmup = new IntakeArmUp();
        printnavxangle = new PrintNavXAngle();
        intakemotors = new IntakeMotors();
        getencs = new getEncs();
        
		oi = new OI();
    }
    
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
        
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
	public void teleopPeriodic() {
        Scheduler.getInstance().run();
        joysticktankdrive.start();
        pressurize.start();
        printnavxangle.start();
        getencs.start();
        SmartDashboard.putNumber("encr", drivetrain.getREnc());
        SmartDashboard.putNumber("encl", drivetrain.getLEnc());
        SmartDashboard.putBoolean("pneu", RobotMap.intake.get());
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
