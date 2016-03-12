
package org.usfirst.frc.team360.robot;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team360.robot.commands.AutoLowBarCross;
import org.usfirst.frc.team360.robot.commands.AutoLowBarShoot;
import org.usfirst.frc.team360.robot.commands.CatapultDown;
import org.usfirst.frc.team360.robot.commands.CatapultUp;
import org.usfirst.frc.team360.robot.commands.DriveEncs;
import org.usfirst.frc.team360.robot.commands.IntakeArmDown;
import org.usfirst.frc.team360.robot.commands.IntakeArmUp;
import org.usfirst.frc.team360.robot.commands.IntakeMotors;
import org.usfirst.frc.team360.robot.commands.JoystickTankDrive;
import org.usfirst.frc.team360.robot.commands.NavXPID;
import org.usfirst.frc.team360.robot.commands.PIdNav;
import org.usfirst.frc.team360.robot.commands.Pressurize;
import org.usfirst.frc.team360.robot.commands.PrintNavXAngle;
import org.usfirst.frc.team360.robot.commands.PrintRPIData;
import org.usfirst.frc.team360.robot.commands.RPIAngle;
import org.usfirst.frc.team360.robot.commands.RPIDistance;
import org.usfirst.frc.team360.robot.commands.ShiftDown;
import org.usfirst.frc.team360.robot.commands.ShiftUp;
import org.usfirst.frc.team360.robot.commands.TurnToCameraAngle;
import org.usfirst.frc.team360.robot.commands.driveStraightPID;
import org.usfirst.frc.team360.robot.commands.getEncs;
import org.usfirst.frc.team360.robot.subsystems.Catapult;
import org.usfirst.frc.team360.robot.subsystems.DriveTrain;
import org.usfirst.frc.team360.robot.subsystems.IntakeArms;
import org.usfirst.frc.team360.robot.subsystems.IntakeMotor;
import org.usfirst.frc.team360.robot.subsystems.NavX;
import org.usfirst.frc.team360.robot.subsystems.NavXPIDSubsystem;
import org.usfirst.frc.team360.robot.subsystems.Pneumatics;
import org.usfirst.frc.team360.robot.subsystems.RPIServer;
import org.usfirst.frc.team360.robot.subsystems.SuperShifter;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	// ENCODERS ON COMP BOT ARE 21.16 ticks per In
	//ENCODER ON PRACTICE BOT ARE 14.21
	public static DriveTrain drivetrain;
	public static SuperShifter supershifter;
	public static Pneumatics pneumatics;
	public static Catapult catapult;
	public static IntakeArms intakearm;
	public static IntakeMotor intakemotor; 
	public static NavX navx;
	public static NavXPIDSubsystem navxpidsubsystem;
	public static RPIServer rpiserver;
	
    Command joysticktankdrive;
    Command pressurize;
    Command printrpidata;
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
    Command driveencs;
    Command autoCommand;
    Command pidnav;
    Command rpiangle;
    Command rpidistance;
    Command drivestraightpid;
    CameraServer server;
    
    SendableChooser auto;
   
	public static OI oi;

    /**
     * This func
     * tion is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        // instantiate the command used for the autonomous period
    	try{
    	server = CameraServer.getInstance();
    	server.setQuality(100);
    	server.startAutomaticCapture("cam0");
    	
    	supershifter = new SuperShifter();
    	pneumatics = new Pneumatics();
    	drivetrain = new DriveTrain();
    	catapult = new Catapult();
    	intakearm = new IntakeArms();
    	intakemotor = new IntakeMotor();
    	navx = new NavX();
    	navxpidsubsystem = new NavXPIDSubsystem();
    	rpiserver = new RPIServer();
    	pidnav = new PIdNav(90);
    	joysticktankdrive = new JoystickTankDrive();
        pressurize = new Pressurize();
        shiftup = new ShiftUp();
        shiftdown = new ShiftDown();
        catapultdown = new CatapultDown();
        catapultup = new CatapultUp();
        intakearmdown = new IntakeArmDown();
     //   navxpid = new NavXPID(270);
        intakearmup = new IntakeArmUp();
        printnavxangle = new PrintNavXAngle();
        intakemotors = new IntakeMotors();
        getencs = new getEncs();
        printrpidata = new PrintRPIData();
        drivestraightpid = new driveStraightPID(.4, 180, 200);
        //driveencs = new DriveEncs(1850, 1);
        rpiangle = new RPIAngle();
        rpidistance = new RPIDistance();
		oi = new OI();
	      
	      auto = new SendableChooser();
	   //   auto.addDefault("drive", new DriveEncs(2862, 1));
	  //    auto.addDefault("drive", new DriveEncs(4000, 1));
	 //	     auto.addDefault("Lowbar Cross auto", new AutoLowBarCross());
	  //    auto.addDefault("Turn", new PIdNav(90));
	  //    SmartDashboard.putData("auto" , auto);
    	} catch(Exception e) {
			System.out.println(e);
		}
    }
    
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}
	double setpoint = 0;
	double error = 0;
    public void autonomousInit() {
        // schedule the autonomous command (example)
    	navx.reset();
    	Timer.delay(.25);
    	drivetrain.resetREnc();
    	autoCommand = (Command) auto.getSelected();
    	if(autoCommand != null){
    	//	autoCommand.start();
    	}
    	pidnav.start();
   // 	drivestraightpid.start();
    	//turnController.enable();
  //  	pidnav.start();
    //	turnController.enable();
    //	navxpid.start();

    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
  //      rpiangle.start();
     //   navxpid.start();
        
        printnavxangle.start();
    }
    
    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
    	if(autoCommand != null){
        		autoCommand.cancel();
        }

    	navx.reset();
    	rpiangle.start();
    	rpidistance.start();
    	printrpidata.start();
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
		
       
		try {
			 Scheduler.getInstance().run();
			    //    navxpid.start();
			        joysticktankdrive.start();
			        pressurize.start();
			        printnavxangle.start();
			        getencs.start();
			        rpiangle.start();
			  //      printrpidata.start();
		} catch(Exception e) {
			System.out.println(e);
		}
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
