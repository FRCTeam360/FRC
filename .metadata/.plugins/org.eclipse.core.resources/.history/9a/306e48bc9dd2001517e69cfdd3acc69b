package org.usfirst.frc.team360.robot.commands;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Command;
import java.io.*;
import org.usfirst.frc.team360.robot.Robot;
import org.usfirst.frc.team360.robot.RobotMap;
import org.usfirst.frc.team360.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.Timer;

@SuppressWarnings("unused")
public class usbSave extends Command {  
	
	
	
		FileOutputStream fop;
		String content = "";
		ObjectOutputStream save = null;
		File file;
		protected void initialize() {
		
		file = new File("u/newfile.txt");
		// if program does not work, replace motor"R, L, RL, LR".get() with RobotMap.motor"R, L, RL, LR".get()
		try  {
			if (!file.exists()) {
				file.createNewFile();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

		@Override
		protected void execute() {
			content = "";

			content += Robot.drivetrain.getMotor();
			content += ("time: " + Timer.getMatchTime());
			// if program does not work, replace motor"R, L, RL, LR".get() with RobotMap.motor"R, L, RL, LR".get()
			try  {
				fop = new FileOutputStream(file);
				byte[] contentInBytes = content.getBytes();
				
				fop.write(contentInBytes);
				fop.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
			

		@Override
		protected boolean isFinished() {
			return false;
		}

		@Override
		protected void end() {
			try {
				fop.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		protected void interrupted() {
			end();
		}
}