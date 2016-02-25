package org.usfirst.frc.team360.robot;
import org.usfirst.frc.team360.robot.subsystems.Pneumatics;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI.Port;
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
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	
	//
	public static final double kPNavX = .018;
	public static final double kINavX = .00001;
	public static final double kDNavX = .000015;
	public static VictorSP motorR1 = new VictorSP(0);
	public static VictorSP motorR2 = new VictorSP(1);
	public static VictorSP motorL1 = new VictorSP(2);
	public static VictorSP motorL2 = new VictorSP(3);
	public static VictorSP intakeMotor = new VictorSP(6); 

	//supershifter pneumatics 
	public static DoubleSolenoid superShifter = new DoubleSolenoid(0, 1);
	public static DoubleSolenoid catapultTusks = new DoubleSolenoid(5, 4);
	public static DoubleSolenoid intakeArms = new DoubleSolenoid(3, 2);
	
	public static Encoder encR = new Encoder(3, 2);
	public static Encoder encL = new Encoder(0, 1);
	
	public static AHRS ahrs = new AHRS(Port.kMXP); 
	
	//compressor 
	public static Compressor compressor = new Compressor();
	
}
