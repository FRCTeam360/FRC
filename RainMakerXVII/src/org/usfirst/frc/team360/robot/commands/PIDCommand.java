package org.usfirst.frc.team360.robot.commands;

import org.usfirst.frc.team360.robot.RobotMap;
import org.usfirst.frc.team360.robot.subsystems.DriveTrain;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PIDCommand extends Command implements PIDOutput {
	AHRS ahrs = RobotMap.ahrs;
	
	VictorSP motorR1 = RobotMap.motorR1; 
	VictorSP motorR2 = RobotMap.motorR2; 
	VictorSP motorL1 = RobotMap.motorL1; 
	VictorSP motorL2 = RobotMap.motorL2; 
	DriveTrain myRobot; 
	PIDController turnController;
	
	static final double kToleranceDegrees = 2.0f;
	
	static final double kP = 0.03;
	  static final double kI = 0.00;
	  static final double kD = 0.00;
	  static final double kF = 0.00;

    public PIDCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void init() {
    	 myRobot = new DriveTrain();
	     // myRobot.setExpiration(0.1);
	    //  stick = new Joystick(0);
	      try {
	          /* Communicate w/navX-MXP via the MXP SPI Bus.                                     */
	          /* Alternatively:  I2C.Port.kMXP, SerialPort.Port.kMXP or SerialPort.Port.kUSB     */
	          /* See http://navx-mxp.kauailabs.com/guidance/selecting-an-interface/ for details. */
	          ahrs = new AHRS(SPI.Port.kMXP); 
	      } catch (RuntimeException ex ) {
	          DriverStation.reportError("Error instantiating navX-MXP:  " + ex.getMessage(), true);
	      }
	      turnController = new PIDController(kP, kI, kD, kF, ahrs, this);
	      turnController.setInputRange(-360.0f,  360.0f);
	      turnController.setOutputRange(-1.0, 1.0);
	      turnController.setAbsoluteTolerance(kToleranceDegrees);
	      turnController.setContinuous(true);
	      turnController.setSetpoint(90);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	 myRobot.setSafetyEnabled(false);
	      myRobot.drive(0.0, 0.0);    // stop robot	    //    for 2 seconds
	      myRobot.drive(0.0, 0.0);	// stop robot
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }

	@Override
	public void pidWrite(double output) {
		// TODO Auto-generated method stub  
		motorR1.set(turnController.get());
	    motorR2.set(turnController.get());  
	    motorL1.set(-turnController.get());
	    motorL2.set(-turnController.get());
	         
		
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}
}
