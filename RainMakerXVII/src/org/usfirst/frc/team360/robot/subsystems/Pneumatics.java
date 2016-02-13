package org.usfirst.frc.team360.robot.subsystems;

import org.usfirst.frc.team360.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;
/**
 *
 */
public class Pneumatics extends Subsystem {
    Compressor comp = RobotMap.compressor;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void pressurize (){
    	comp.start();
    }
    public void stop(){
    	comp.stop();
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    }
}

