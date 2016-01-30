package org.usfirst.frc.team360.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import java.io.*;
import java.util.ArrayList;

public class usbSave {
	public static void main(String[] arg) {
		
		boolean powerSwitch=true;
		int x=9, y=150, z= 675;
		String name="Galormadron", setting="on", plant="rutabaga";
		ArrayList stuff = new ArrayList();
		stuff.add("One");
		stuff.add("Two");
		stuff.add("Three");
		stuff.add("Four");
		stuff.add("Five");
		
		try{
			FileOutputStream saveFile=new FileOutputStream("u/usbSaveFile.sav");
			
			// Might need to change saveFile to u/usbSaveFile
			ObjectOutputStream save = new ObjectOutputStream(saveFile);

			save.writeObject(powerSwitch);
			save.writeObject(x);
			save.writeObject(y);
			save.writeObject(z);
			save.writeObject(name);
			save.writeObject(setting);
			save.writeObject(plant);
			save.writeObject(stuff);

			save.close();
			}
		
			catch(Exception exc){
			exc.printStackTrace();
		}
	}
}