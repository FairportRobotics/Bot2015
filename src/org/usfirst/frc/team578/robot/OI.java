package org.usfirst.frc.team578.robot;

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
	Joystick gamePad = new Joystick(RobotMap.GAMEPAD); 
    Button buttonOne = new JoystickButton(gamePad, RobotMap.CONTROLLER_B1);
    Button buttonTwo = new JoystickButton(gamePad, RobotMap.CONTROLLER_B2);
    Button buttonThree = new JoystickButton(gamePad, RobotMap.CONTROLLER_B3);
    Button buttonFour = new JoystickButton(gamePad, RobotMap.CONTROLLER_B4);
	
    public OI()
    {
    	buttonOne.whenPressed(new ElevatorCommand(1));
    	buttonTwo.whenPressed(new ElevatorCommand(2));
    	buttonThree.whenPressed(new ElevatorCommand(3));
    	buttonFour.whenPressed(new ElevatorCommand(4));
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
	
	public Button getButtonOne()
	{
		return buttonOne;
	}
	
	public Button getButtonTwo()
	{
		return buttonTwo;
	}
	
	public Button getButtonThree()
	{
		return buttonThree;
	}
	
	public Button getButtonFour()
	{
		return buttonFour;
	}
}

