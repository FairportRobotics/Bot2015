package org.usfirst.frc.team578.robot.subsystems;
import org.usfirst.frc.team578.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

public class FibinacciSubsystem extends Subsystem {

	private DigitalInput fibinacciSwitch = new DigitalInput(RobotMap.FIBINACCI_SWITCH);
	private Relay fibinacci = new Relay(RobotMap.FIBINACCI_WHEEL);
	private boolean extending = false;
	
	/**
	 * Constructor for the subsystem.
	 */
	public FibinacciSubsystem() {
		setDirection();
	}
	
	/**
	 * 
	 */
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Extends the fibinacci. Sets the relay value to on and sets the value of 
	 * extending to true.
	 */
	public void extendFibinacci() {
		fibinacci.set(Relay.Value.kOn);
		extending = true;
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
		fibinacci.setDirection(Relay.Direction.kForward);
	}
	
	/**
	 * Sets the fibinacci to off and extending to false.
	 */
	public void stopFibinacci() {
		//MAY STOP IMMEDIATELY BE PREPARED TO ADD A DELAY
		fibinacci.set(Relay.Value.kOff);
		extending = false;
	}
}