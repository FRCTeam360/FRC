package org.usfirst.frc.team360.robot.subsystems;
import org.usfirst.frc.team360.robot.*;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {
	public static DoubleSolenoid shooter =RobotMap.Shooter;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public void open(){ 
		Shooter.set(DoubleSolenoid.Value.kForward);
	}
	public void close() {
		Shooter .set(DoubleSolenoid.Value.kReverse);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    }
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
   
}

