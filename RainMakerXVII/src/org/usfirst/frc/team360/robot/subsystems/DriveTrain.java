package org.usfirst.frc.team360.robot.subsystems;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team360.robot.*;
//import org.usfirst.frc.team360.robot.commands.JoystickTankDrive;
/**
 *
 */
public class DriveTrain extends Subsystem {
	VictorSP motorR1 = RobotMap.motorR1;
	VictorSP motorR2 = RobotMap.motorR2;
	VictorSP motorL1 = RobotMap.motorL1;
	VictorSP motorL2 = RobotMap.motorL2;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	  public void drive(double motorR, double motorL) {
		  motorR1.set(motorR);
		  motorR2.set(motorR);
		  motorL1.set(-motorL);
		  motorL2.set(-motorL);
	  }
	  public void driveR(double RMotor){
		  motorR1.set(RMotor);
		  motorR2.set(RMotor);
	  }
	  public void driveL(double LMotor){
		  motorL1.set(LMotor);
		  motorL2.set(LMotor);
	  }
	  public void stopR(){
		  motorR1.stopMotor();
		  motorR2.stopMotor();  
	  }
	  public void stopL(){
		  motorL1.stopMotor();
		  motorL2.stopMotor();
	  }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    }
}

