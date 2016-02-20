package org.usfirst.frc.team360.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
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
	
	//motors
	public static VictorSP motorR1 = new VictorSP(0);
	public static VictorSP motorR2 = new VictorSP(1);
	public static VictorSP motorL1 = new VictorSP(2);
	public static VictorSP motorL2 = new VictorSP(3);
	
	//supershifter pneumatics 
	public static DoubleSolenoid superShifter = new DoubleSolenoid(0, 1);
	//compressor 
	public static Compressor compressor = new Compressor();
	
	public static DigitalInput angle1 = new DigitalInput(6);//1
	public static DigitalInput angle2 = new DigitalInput(7);//2
	public static DigitalInput angle3 = new DigitalInput(8);//4
	public static DigitalInput angle4 = new DigitalInput(9);//8
	public static DigitalInput angle5 = new DigitalInput(23);//16
	public static DigitalInput angle6 = new DigitalInput(22);//32
	public static DigitalInput angle7 = new DigitalInput(21);//64
	public static DigitalInput distance1 = new DigitalInput(20);//1
	public static DigitalInput distance2 = new DigitalInput(19);//2
	public static DigitalInput distance3 = new DigitalInput(18);//4
	public static DigitalInput distance4 = new DigitalInput(12);//8
	public static DigitalInput distance5 = new DigitalInput(13);//16
	public static DigitalInput distance6 = new DigitalInput(11);//32
	public static DigitalInput distance7 = new DigitalInput(10);//64
	public static DigitalInput test = new DigitalInput(0);
}
