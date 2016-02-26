package org.usfirst.frc.team360.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team360.robot.Robot;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class usbSave2 extends Command {
    public usbSave2() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    }
    
    String content; //content written to the file
    FileWriter fw;
    BufferedWriter bw;
	File file;
    
    // Called just before this Command runs the first time
    protected void initialize() {
    	try {

    		file = new File("u/newfile2.txt"); //file location
				
			//if file doesnt exist, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			fw = new FileWriter(file.getAbsoluteFile());
			bw = new BufferedWriter(fw);
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	try {
    		content = (Robot.drivetrain.getMotor());
			bw.write(content);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.logger.finished();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}