package org.usfirst.frc.team360.robot;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.VictorSP;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static double leftMotor = 1;
    // public static double rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static double rangefinderPort = 1;
    // public static double rangefinderModule = 1;
	
	//motors
	public static VictorSP motorR1 = new VictorSP(0);
	public static VictorSP motorR2 = new VictorSP(1);
	public static VictorSP motorL1 = new VictorSP(2);
	public static VictorSP motorL2 = new VictorSP(3);
	//public static Encoder encoder1;
	//public static Encoder encoder2;
	public static Encoder encoder1 = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
	public static Encoder encoder2 = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
	
	
	//supershifter pneumatics 
	public static DoubleSolenoid superShifter = new DoubleSolenoid(0, 1);
	//compressor 
	public static Compressor compressor = new Compressor();
}
