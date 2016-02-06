package org.usfirst.frc.team360.robot.subsystems;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import org.usfirst.frc.team360.robot.RobotMap;

//4 motors and 2 encoders
public class BasicPID extends PIDSubsystem { // This system extends PIDSubsystem

//	Victor motor = RobotMap.wristMotor;
	//AnalogInput pot = RobotMap.wristPot();
	
	static VictorSP motorR1 = RobotMap.motorR1;
	static VictorSP motorR2 = RobotMap.motorR2;
	static VictorSP motorL1 = RobotMap.motorL1;
	static VictorSP motorL2 = RobotMap.motorL2;
	static Encoder encoder1 = RobotMap.encoder1;
	static Encoder encoder2 = RobotMap.encoder2;
	PIDController basPID = new PIDController( 2.0, 0.0, 0.0, encoder1, motorR1);




	public BasicPID() {
		super("basicPID", 2.0, 0.0, 0.0);
		/* The constructor passes a name for the subsystem and the P, I and D constants 
		 * *that are sued when computing the motor output
		 */
		setAbsoluteTolerance(0.05);
		getPIDController().setContinuous(false);
		setSetpoint(encoder1.get());
		//setSetpoint(encoder2.get())
		
	}
	
    public void initDefaultCommand() {}
    	

    protected double returnPIDInput() {
    	return 0;
   //return.getAverageVoltage(); // returns the sensor value that is providing the feedback for the system
	//encoder1.pidWrite(output);
	//encoder2.pidWrite(output);
    	
    	
    } 
    //encoder
    
    protected void usePIDOutput(double output) {
    	motorL1.pidWrite(output); // this is where the computed output value from the PIDController is applied to the motor
    	motorL2.pidWrite(output);
    	motorR1.pidWrite(output);
    	motorR2.pidWrite(output);
    	
    }
    //motor 
}