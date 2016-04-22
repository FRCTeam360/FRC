package org.usfirst.frc.team360.robot;

import org.usfirst.frc.team360.robot.commands.*;
import org.usfirst.frc.team360.robot.triggers.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */

public class OI {
	Command boomBoomShootsBoulders = new CameraAim();
    public static Joystick joyR = new Joystick(0);
    public static Joystick joyL = new Joystick(1);
    public static Joystick joyOI = new Joystick(2); 
   // public static Joystick joyDriver = new Joystick(4); 
    //joyK is for the separate "joystick" keyboard device....
    public static Button buttonUp = new JoystickButton(joyR, 1);
    public static Button buttonDown = new JoystickButton(joyL, 1);
  /*  public static Button buttonDriveUp = new JoystickButton(joyDriver, 8);
    public static Button buttonDriveDown = new JoystickButton(joyDriver, 7);*/
    public static Button buttonReset = new JoystickButton(joyL, 2);
    public static Button buttonCamSwitch = new JoystickButton(joyR, 2);
  //  public static Button buttonCamSwitch2 = new JoystickButton(joyOI, 5);
    public static DoubleButton welcomeToTheDangerZone = new DoubleButton(joyOI, 9, 10);
    public static Button buttonIntakeArmUp = new JoystickButton(joyOI, 4);
    public static Button buttonIntakeArmDown = new JoystickButton(joyOI, 2);
    public static Button buttonShoot = new JoystickButton(joyOI, 8);
    public static Button buttonIntakeMotor = new JoystickButton(joyOI, 1);
    public static Button buttonPartialIntake = new JoystickButton(joyOI, 5);
    public static Button buttonIntakeMotorOut = new JoystickButton(joyOI, 3);
    public static Button buttonAutoShoot = new JoystickButton(joyL, 4);
    public OI(){
    	buttonUp.whenPressed(new ShiftUp());
    	buttonDown.whenPressed(new ShiftDown());
    	buttonCamSwitch.whenPressed(new SwitchCamera());
    //	buttonCamSwitch2.whenPressed(new SwitchCamera());
    	/*buttonDriveUp.whenPressed(new ShiftUp());
    	buttonDriveDown.whenPressed(new ShiftDown());*/
    	buttonIntakeArmUp.whenPressed(new IntakeArmUp());
    	buttonIntakeArmDown.whenPressed(new IntakeArmDown());
    	buttonIntakeMotor.whileHeld(new IntakeMotors());
    	buttonIntakeMotorOut.whileHeld(new IntakeMotorsOut());
    	buttonShoot.whenPressed(new Shoot());
    	buttonReset.whenPressed(new ResetEncs());
    //	buttonPartialIntake.whenPressed(new PartialIntake());
    	welcomeToTheDangerZone.whenActive(new WelcomeToTheDangerZone());
    	buttonAutoShoot.whileHeld(boomBoomShootsBoulders);
    }
}


