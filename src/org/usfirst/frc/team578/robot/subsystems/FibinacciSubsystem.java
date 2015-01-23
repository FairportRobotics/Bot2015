package org.usfirst.frc.team578.robot.subsystems;

import org.usfirst.frc.team578.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class FibinacciSubsystem extends Subsystem {
	

	private DigitalInput fibinacciSwitch = new DigitalInput(RobotMap.FIBINACCI_SWITCH);
	private CANTalon fibinacci = new CANTalon(RobotMap.FIBINACCI_WHEEL);
	private boolean extending = false;

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}
	
	public void extendFibinacci()
	{
		fibinacci.set(0.5);
		extending = true;
	}
	
	public void update()
	{
		//MAY STOP IMMEDIATELY BE PREPARED TO ADD A DELAY
		if(extending)
		{
			if(fibinacciSwitch.get())
			{
				fibinacci.set(0);
				extending = false;
			}
		}
	}


}
