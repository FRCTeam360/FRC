package org.usfirst.frc.team360.robot.commands;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Command;
import java.io.*;
import org.usfirst.frc.team360.robot.Robot;
import org.usfirst.frc.team360.robot.RobotMap;

@SuppressWarnings("unused")
public class usbSave extends Command {
		FileOutputStream fop;
		String content;
		VictorSP motorR = RobotMap.motorR1;
		VictorSP motorL = RobotMap.motorR2;
		VictorSP motorRL = RobotMap.motorL1;
		VictorSP motorLR = RobotMap.motorL2;
		ObjectOutputStream save = null;

		protected void initialize() {
		
		File file = new File("u/newfile.txt");
		
		content = ("motorR = " + motorR.get());
		content = ("motorL = " + motorL.get());
		content = ("motorRL = " + motorRL.get());
		content = ("motorLR = " + motorLR.get());
		
		try  {
			fop = new FileOutputStream(file);
			byte[] contentInBytes = content.getBytes();
			
			fop.write(contentInBytes);
			fop.flush();


			if (!file.exists()) {
				file.createNewFile();
			}
		}
			
			catch (IOException e) {
			e.printStackTrace();
		}
	}

		@Override
		protected void execute() {
			try {
				byte[] contentInBytes = content.getBytes();
				fop.write(contentInBytes);
				
				/*VictorSP motorR = RobotMap.motorR1;
				VictorSP motorL = RobotMap.motorR2;
				VictorSP motorRL = RobotMap.motorL1;
				VictorSP motorLR = RobotMap.motorL2;
				
				content = ("motorR = " + motorR.get());
				content = ("motorL = " + motorL.get());
				content = ("motorRL = " + motorRL.get());
				content = ("motorLR = " + motorLR.get());*/
				
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