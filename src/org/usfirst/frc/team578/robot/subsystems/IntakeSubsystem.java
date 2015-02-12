package org.usfirst.frc.team578.robot.subsystems;
import org.usfirst.frc.team578.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class IntakeSubsystem extends Subsystem {
	
	private CANTalon leftIntakeTalon;
	private CANTalon rightIntakeTalon;
	
	public final boolean enabled;
	
	public IntakeSubsystem(boolean enable)
	{
		this.enabled = enable;
		
		if(!enabled)
			return;
		
		leftIntakeTalon = new CANTalon(RobotMap.LEFT_INTAKE_TALON);
		rightIntakeTalon = new CANTalon(RobotMap.RIGHT_INTAKE_TALON);
	}

	
	/**
	 * Nothing Happening Here!
	 */
	@Override
	protected void initDefaultCommand() {
		
	}
	
	/**
	 * Gets the speed setting of the left intake Talon. Returns 0 if not enabled.
	 * @return the speed setting 0 if not enabled.
	 */
	public double getSpeed()
	{
		if (!enabled)
			return 0;
		
		return leftIntakeTalon.get();
	}
	
	/**
	 * The Speed of the intake Talons / wheels is being set!
	 */
	public void spinIntake() {
		if (!enabled)
			return;
		
		leftIntakeTalon.set(1);
		rightIntakeTalon.set(-1);
	}
	
	/**
	 * The Speed of the output Talons / wheels is being set!
	 */
	public void spinOutput() {
		if (!enabled)
			return;
		
		leftIntakeTalon.set(-1);
		rightIntakeTalon.set(1);
	}
	
	/**
	 * Stops the Talons / wheels from spinning!
	 */
	public void spinStop() {
		if (!enabled)
			return;
		
		leftIntakeTalon.set(0);
		rightIntakeTalon.set(0);
	}
}