
package org.usfirst.frc.team360.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Timer;

import org.usfirst.frc.team360.robot.commands.ExampleCommand;
import org.usfirst.frc.team360.robot.commands.JoystickTankDrive;
import org.usfirst.frc.team360.robot.commands.Pressurize;
import org.usfirst.frc.team360.robot.commands.ShiftDown;
import org.usfirst.frc.team360.robot.commands.ShiftUp;
import org.usfirst.frc.team360.robot.commands.usbSave;

import org.usfirst.frc.team360.robot.subsystems.ExampleSubsystem;
import org.usfirst.frc.team360.robot.subsystems.DriveTrain;
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
	
    CameraServer server;

    public Robot() {
        server = CameraServer.getInstance();
        server.setQuality(50);
        server.startAutomaticCapture("cam0");
    }

    public void operatorControl() {

        while (isOperatorControl() && isEnabled()) {
            /** robot code here! **/
            Timer.delay(0.005);
        }
    }
	
	Command autonomousCommand;
	SendableChooser autoChooser;

	public static DriveTrain drivetrain;
	public static SuperShifter supershifter;
	public static Pneumatics pneumatics;
	
	
    Command joysticktankdrive;
    Command pressurize;
    Command shiftup;
    Command shiftdown;
    Command usbSave;
	public static OI oi;
	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	


    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	
    	autoChooser = new SendableChooser();
        autoChooser.addDefault("Default Auto", new ExampleCommand());
//        autoChooser.addObject("My Auto", new MyAutoCommand());
        SmartDashboard.putData("Auto mode", autoChooser);
    	
        // instantiate the command used for the autonomous period
    	supershifter = new SuperShifter();
    	pneumatics = new Pneumatics();
    	drivetrain = new DriveTrain();
    	joysticktankdrive = new JoystickTankDrive();
        pressurize = new Pressurize();
        shiftup = new ShiftUp();
        shiftdown = new ShiftDown();
        usbSave = new usbSave();
		oi = new OI();
    }
    
    public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
    	autonomousCommand = (Command) autoChooser.getSelected();
    	if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		usbSave.start();
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
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
