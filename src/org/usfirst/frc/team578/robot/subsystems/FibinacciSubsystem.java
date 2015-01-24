package org.usfirst.frc.team578.robot.subsystems;

import org.usfirst.frc.team578.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

public class FibinacciSubsystem extends Subsystem {
	

	private DigitalInput fibinacciSwitch = new DigitalInput(RobotMap.FIBINACCI_SWITCH);
	private Relay fibinacci = new Relay(RobotMap.FIBINACCI_WHEEL);
	private boolean extending = false;

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}
	
	public void extendFibinacci()
	{
		fibinacci.set(Relay.Value.kOn);
		extending = true;
	}
	
	public boolean readSwitch()
	{
		return fibinacciSwitch.get();
	}
	
	public void setDirection()
	{
		fibinacci.setDirection(Relay.Direction.kForward);
	}
	
	public void stopFibinacci()
	{
		//MAY STOP IMMEDIATELY BE PREPARED TO ADD A DELAY
				fibinacci.set(Relay.Value.kOff);
				extending = false;
	}


}
