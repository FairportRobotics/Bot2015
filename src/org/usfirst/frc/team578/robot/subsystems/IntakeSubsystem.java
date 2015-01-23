package org.usfirst.frc.team578.robot.subsystems;

import org.usfirst.frc.team578.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class IntakeSubsystem extends Subsystem {
	
	
	private CANTalon wheel1 = new CANTalon(RobotMap.WHEEL_LEFT);
	private CANTalon wheel2 = new CANTalon(RobotMap.WHEEL_RIGHT);
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}
	
	public void spinIntake()
	{
		wheel1.set(0.5);
		wheel2.set(0.5);
	}
	
	public void spinOutput()
	{
		wheel1.set(-0.5);
		wheel2.set(-0.5);
	}
	
	public void spinStop()
	{
		wheel1.set(0);
		wheel2.set(0);
	}

}
