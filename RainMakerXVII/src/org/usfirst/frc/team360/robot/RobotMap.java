package org.usfirst.frc.team360.robot;
import org.usfirst.frc.team360.robot.subsystems.Pneumatics;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.vision.USBCamera;

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
	
	public static double angle = 0;
	public static double CameraFudgeFactor = 1.5; // comp bot

	//public static double CameraFudgeFactor = 7;//practice bot
	public static double distance = 0;
	
	public static boolean dangerZone = false;
	
	public static Relay lights;
	
	public static VictorSP motorR1 = new VictorSP(0);
	public static VictorSP motorR2 = new VictorSP(1);
	public static VictorSP motorL1 = new VictorSP(2);
	public static VictorSP motorL2 = new VictorSP(3);

	public static VictorSP intakeMotor = new VictorSP(6); 

	//supershifter pneumatics ang
	
	public static USBCamera front;
	public static USBCamera back;
	public static USBCamera cam;
	public static boolean frontCam;
	
	public static DigitalInput angle1 = new DigitalInput(6);//.5
	public static DigitalInput angle2 = new DigitalInput(7);//1
	public static DigitalInput angle3 = new DigitalInput(8);//2
	public static DigitalInput angle4 = new DigitalInput(9);//4
	public static DigitalInput angle5 = new DigitalInput(23);//8
	public static DigitalInput angle6 = new DigitalInput(22);//16
	public static DigitalInput angle7 = new DigitalInput(21);//32
	
	public static DigitalInput distance1 = new DigitalInput(20);//1
	public static DigitalInput distance2 = new DigitalInput(19);//2
	public static DigitalInput distance3 = new DigitalInput(18);//4
	public static DigitalInput distance4 = new DigitalInput(12);//8
	public static DigitalInput distance5 = new DigitalInput(13);//16
	public static DigitalInput distance6 = new DigitalInput(11);//32
	public static DigitalInput distance7 = new DigitalInput(10);//64
	
	public static DoubleSolenoid superShifter = new DoubleSolenoid(0, 1);
	
	public static DoubleSolenoid catapultTusks = new DoubleSolenoid(5, 4);
	
	public static DoubleSolenoid intakeArms = new DoubleSolenoid(2, 3 );
	
	public static Encoder encR = new Encoder(3, 2);
	public static Encoder encL = new Encoder(0, 1);
	
	public static AHRS ahrs = new AHRS(Port.kMXP);
	
	public static DigitalInput intake = new DigitalInput(4);
	public static DigitalInput catapult = new DigitalInput(5);
	
	public static Compressor compressor = new Compressor();
	
}
