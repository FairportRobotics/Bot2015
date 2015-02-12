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

	public final boolean enabled;

	/**
	 * Constructor for the subsystem.
	 */
	public FibinacciSubsystem(boolean enable) {

		this.enabled = enable;

		if (!enabled)
			return;

		fibinacciSwitch = new DigitalInput(RobotMap.FIBINACCI_SWITCH);
		fibinacciRelay = new Relay(RobotMap.FIBINACCI_WHEEL);

		setDirection();
	}

	@Override
	protected void initDefaultCommand() {

	}

	/**
	 * Extends the fibinacci. Sets the relay value to on and sets the value of 
	 * extending to true.
	 */
	public void extendFibinacci() {
		if (!enabled)
			return;
		
		fibinacciRelay.set(Relay.Value.kOn);
	}

	/**
	 * Gets the state of the fibinacci relay. May be
	 * null if subsystem is not enabled!
	 * @return current state or null if not enabled.
	 */
	public Value getFibinacciStatus()
	{
		if (!enabled)
			return null;
		
		return fibinacciRelay.get();
	}

	/**
	 * Returns the fibinacciSwitch state. False if not enabled.
	 * @return
	 */
	public boolean readSwitch() {
		if (!enabled)
			return false;
		
		return fibinacciSwitch.get();
	}

	/**
	 * Has the direction set to forward.
	 */
	public void setDirection() {
		if (!enabled)
			return;
		
		fibinacciRelay.setDirection(Relay.Direction.kForward);
	}

	/**
	 * Sets the fibinacci to off.
	 */
	public void stopFibinacci() {
		if (!enabled)
			return;
		
		//MAY STOP IMMEDIATELY BE PREPARED TO ADD A DELAY
		fibinacciRelay.set(Relay.Value.kOff);
	}
}