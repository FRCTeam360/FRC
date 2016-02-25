package org.usfirst.frc.team360.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team360.robot.*;
/**
 *
 */
public class SuperShifter extends Subsystem {
    
	public static DoubleSolenoid superShifter = RobotMap.superShifter;  
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public void open(){ 
		superShifter.set(DoubleSolenoid.Value.kForward);
	}
	public void close() {
		superShifter.set(DoubleSolenoid.Value.kReverse);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

