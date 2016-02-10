package org.usfirst.frc.team360.robot.subsystems;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import org.usfirst.frc.team360.robot.Robot;
import org.usfirst.frc.team360.robot.commands.getCameraValue;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class RaspberryPiServer extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	ServerSocket server;
	Socket clientSocket = null;
	DataOutputStream output = null;
	String responseLine;
	DataInputStream in = null;
	public void startConnection() {
		int portNumber = 1180;

		try {
		    server = new ServerSocket(portNumber);
		    clientSocket = server.accept();
		    output = new DataOutputStream(clientSocket.getOutputStream());
		    in = new DataInputStream(clientSocket.getInputStream());
		    responseLine = "";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("hi");
	}
	public void run() throws IOException{
//		 if ((responseLine = is.readLine()) != null) {
//             System.out.println("Server: " + responseLine);
		output.writeInt(22222222);  
	}
	public int recieved() throws IOException{
		 int bytemask = 0x000000ff; 
		byte a1 = in.readByte();
		return bytemask & a1;


	}
	public void stop(){
		try {
			server.close();
			clientSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());

    }
}

