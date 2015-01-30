package org.usfirst.frc.team578.robot.subsystems;

import org.usfirst.frc.team578.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class IntakeSubsystem extends Subsystem {
	
	
	private CANTalon leftIntakeTalon = new CANTalon(RobotMap.LEFT_INTAKE_TALON);
	private CANTalon rightIntakeTalon = new CANTalon(RobotMap.RIGHT_INTAKE_TALON);
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}
	
	public void spinIntake()
	{
		leftIntakeTalon.set(0.5);
		rightIntakeTalon.set(0.5);
	}
	
	public void spinOutput()
	{
		leftIntakeTalon.set(-0.5);
		rightIntakeTalon.set(-0.5);
	}
	
	public void spinStop()
	{
		leftIntakeTalon.set(0);
		rightIntakeTalon.set(0);
	}

}
