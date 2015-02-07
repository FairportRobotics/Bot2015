package org.usfirst.frc.team578.robot.subsystems;
import org.usfirst.frc.team578.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public class FibinacciSubsystem extends Subsystem {

	private DigitalInput fibinacciSwitch;
	private Relay fibinacciRelay;
	//private boolean extending = false;
	
	/**
	 * Constructor for the subsystem.
	 */
	public FibinacciSubsystem() {
		
		fibinacciSwitch = new DigitalInput(RobotMap.FIBINACCI_SWITCH);
		fibinacciRelay = new Relay(RobotMap.FIBINACCI_WHEEL);
		
		setDirection();
	}
	
	/**
	 * 
	 */
	@Override
	protected void initDefaultCommand() {

	}
	
	/**
	 * Extends the fibinacci. Sets the relay value to on and sets the value of 
	 * extending to true.
	 */
	public void extendFibinacci() {
		fibinacciRelay.set(Relay.Value.kOn);
	}
	
	/**
	 * Gets the state of the fibinacci relay
	 * @return current state
	 */
	public Value getFibinacciStatus()
	{
		return fibinacciRelay.get();
	}
	
	/**
	 * Returns the fibinacciSwitch.
	 * @return
	 */
	public boolean readSwitch() {
		return fibinacciSwitch.get();
	}
	
	/**
	 * Has the direction set to forward.
	 */
	public void setDirection() {
		fibinacciRelay.setDirection(Relay.Direction.kForward);
	}
	
	/**
	 * Sets the fibinacci to off and extending to false.
	 */
	public void stopFibinacci() {
		//MAY STOP IMMEDIATELY BE PREPARED TO ADD A DELAY
		fibinacciRelay.set(Relay.Value.kOff);
	}
}