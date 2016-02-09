
package org.usfirst.frc.team360.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team360.robot.commands.JoystickTankDrive;
import org.usfirst.frc.team360.robot.commands.Pressurize;
import org.usfirst.frc.team360.robot.commands.ShiftDown;
import org.usfirst.frc.team360.robot.commands.ShiftUp;
import org.usfirst.frc.team360.robot.commands.getCameraValue;
import org.usfirst.frc.team360.robot.subsystems.DriveTrain;
import org.usfirst.frc.team360.robot.subsystems.Pneumatics;
import org.usfirst.frc.team360.robot.subsystems.RaspberryPiServer;
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
	public static RaspberryPiServer raspberrypiserver;
	
	public LiveWindow livewindow;
	
    Command joysticktankdrive;
    Command pressurize;
    Command shiftup;
    Command shiftdown;
    Command getcameravalue;
	public static OI oi;
	String i = "";


    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        // instantiate the command used for the autonomous period
    	supershifter = new SuperShifter();
    	pneumatics = new Pneumatics();
    	raspberrypiserver = new RaspberryPiServer();
    	drivetrain = new DriveTrain();
    	joysticktankdrive = new JoystickTankDrive();
        pressurize = new Pressurize();
        shiftup = new ShiftUp();
        shiftdown = new ShiftDown();
        getcameravalue = new getCameraValue();
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
    	RobotMap.motorL1.set(OI.joyL.getRawAxis(1));
    	RobotMap.motorR1.set(OI.joyL.getRawAxis(1));
    	RobotMap.motorL2.set(OI.joyL.getRawAxis(1));
    	RobotMap.motorR2.set(OI.joyL.getRawAxis(1));
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
    	//SmartDashboard.putString("output", "er");
		//SmartDashboard.putString("ou", i + Double.toString(Math.random()));
    	SmartDashboard.putDouble("o", OI.joyL.getRawAxis(1));
        Scheduler.getInstance().run();
        joysticktankdrive.start();
        pressurize.start();
        getcameravalue.start();
        //getcameravalue.start();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
