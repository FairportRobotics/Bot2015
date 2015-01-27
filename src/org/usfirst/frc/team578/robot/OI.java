package org.usfirst.frc.team578.robot;

import org.usfirst.frc.team578.robot.commands.EjectTotesCommand;
import org.usfirst.frc.team578.robot.commands.ElevatorCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
	// Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	
	Joystick leftJoystick = new Joystick(RobotMap.LEFT_JOYSTICK);
	Joystick rightJoystick = new Joystick(RobotMap.RIGHT_JOYSTICK);
    Button buttonONE = new JoystickButton(leftJoystick, 1);
    Button buttonTWO = new JoystickButton(leftJoystick, 2);
    Button buttonTHREE = new JoystickButton(leftJoystick, 3);
    Button buttonFOUR = new JoystickButton(leftJoystick, 4);
    Joystick gamePad = new Joystick(RobotMap.GAMEPAD);
    Button buttonSix = new JoystickButton(gamePad, RobotMap.CONTROLLER_B6);
    Button buttonEight = new JoystickButton(gamePad, RobotMap.CONTROLLER_B6);
    Button buttonNine = new JoystickButton(gamePad, RobotMap.CONTROLLER_B6);
    Button leftTrigger = new JoystickButton(leftJoystick, RobotMap.TRIGGER_LEFT_JOYSTICK);
    Button rightTrigger = new JoystickButton(rightJoystick, RobotMap.TRIGGER_RIGHT_JOYSTICK);
    
    public OI()
    {
    	buttonONE.whenPressed(new ElevatorCommand(1));
    	buttonTWO.whenPressed(new ElevatorCommand(2));
    	buttonTHREE.whenPressed(new ElevatorCommand(3));
    	buttonFOUR.whenPressed(new ElevatorCommand(4));
    	
    	buttonNine.whenPressed(new EjectTotesCommand());
    	
    }
	
	public double getLeftStickY()
	{
		return leftJoystick.getY();
	}
	
	public double getRightStickY()
	{
		return rightJoystick.getY();
	}
	
	public double getLeftStickX()
	{
		return leftJoystick.getX();
	}
	
	public double getRightStickX()
	{
		return rightJoystick.getX();
	}
	
	public Button getButtonSix()
	{
		return buttonSix;
	}
	
	public Button getButtonEight()
	{
		return buttonEight;
	}
	
	public Button getButtonNine()
	{
		return buttonNine;
	}
	
	public Button getLeftTrigger()
	{
		return leftTrigger;
	}
	
	public Button getRightTrigger()
	{
		return rightTrigger;
	}
	
}

