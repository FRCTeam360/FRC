package org.usfirst.frc.team360.robot.subsystems;


import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team360.robot.RobotMap;
import com.kauailabs.navx.frc.AHRS; 





public class NavX extends Subsystem {
	AHRS ahrs = RobotMap.ahrs; 
			public double getAngle(){
				return ahrs.getAngle();
				
	}

	protected void initDefaultCommand() {
		
	}
}
