package org.usfirst.frc.team360.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Talon;

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
	
	//motors
	public static Talon motorR1 = new Talon(0);
	public static Talon motorR2 = new Talon(1);
	public static Talon motorL1 = new Talon(2);
	public static Talon motorL2 = new Talon(3);
	
	
	//supershifter pneumatics 
	public static DoubleSolenoid superShifter = new DoubleSolenoid(0, 1);
	//compressor 
	public static Compressor compressor = new Compressor();
}
