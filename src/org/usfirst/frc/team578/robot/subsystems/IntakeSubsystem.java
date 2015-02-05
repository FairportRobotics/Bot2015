package org.usfirst.frc.team578.robot.subsystems;
import org.usfirst.frc.team578.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class IntakeSubsystem extends Subsystem {
	
	private CANTalon leftIntakeTalon;
	private CANTalon rightIntakeTalon;
	
	public IntakeSubsystem()
	{
		//leftIntakeTalon = new CANTalon(RobotMap.LEFT_INTAKE_TALON);
		//rightIntakeTalon = new CANTalon(RobotMap.RIGHT_INTAKE_TALON);
	}
	
	/**
	 * Nothing Happening Here!
	 */
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}
	
	/**
	 * The Speed of the intake Talons / wheels is being set!
	 */
	public void spinIntake() {
		leftIntakeTalon.set(0.5);
		rightIntakeTalon.set(0.5);
	}
	
	/**
	 * The Speed of the output Talons / wheels is being set!
	 */
	public void spinOutput() {
		leftIntakeTalon.set(-0.5);
		rightIntakeTalon.set(-0.5);
	}
	
	/**
	 * Stops the Talons / wheels from spinning!
	 */
	public void spinStop() {
		leftIntakeTalon.set(0);
		rightIntakeTalon.set(0);
		
	}
}