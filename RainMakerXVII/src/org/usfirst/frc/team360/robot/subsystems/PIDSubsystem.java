package org.usfirst.frc.team360.robot.subsystems;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team360.robot.RobotMap;
import edu.wpi.first.wpilibj.SPI;
import com.kauailabs.navx.frc.AHRS;

/**
 * The Pivot subsystem contains the Van-door motor and the pot for PID control
 * of angle of the pivot and claw.
 */
public class PIDSubsystem extends Subsystem implements edu.wpi.first.wpilibj.PIDOutput {
	
	AHRS ahrs = RobotMap.ahrs;
	
	VictorSP motorR1 = RobotMap.motorR1; 
	VictorSP motorR2 = RobotMap.motorR2; 
	VictorSP motorL1 = RobotMap.motorL1; 
	VictorSP motorL2 = RobotMap.motorL2;
	
	Encoder enc1 = new Encoder(6, 7, false, Encoder.EncodingType.k4X);
	Encoder enc2 = new Encoder (8, 9, false, Encoder.EncodingType.k4X);
	
	DriveTrain myRobot; 
	PIDController turnController;
	
	static final double kToleranceDegrees = 2.0f;
	
	static final double kP = 0.03;
	  static final double kI = 0.00;
	  static final double kD = 0.00;
	  static final double kF = 0.00;
	
	public void PIDInput(){
		
		enc1.get();
		enc2.get();
		
		
	}
	public void init(){
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
	
	public void run(){
		 myRobot.setSafetyEnabled(false);
	      myRobot.drive(0.0, 0.0);    // stop robot	    //    for 2 seconds
	      myRobot.drive(0.0, 0.0);	// stop robot
	}
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    
    }

		
	
	void PIDOutput(){
		//motorR1.set();  
	          
	       motorR1.set(turnController.get());
	       motorR2.set(turnController.get());  
	       motorL1.set(-turnController.get());
	       motorL2.set(-turnController.get());
	         
		
	}
	@Override
	public void pidWrite(double output) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}

