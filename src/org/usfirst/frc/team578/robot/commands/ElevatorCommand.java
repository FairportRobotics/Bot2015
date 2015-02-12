package org.usfirst.frc.team578.robot.commands;
import org.usfirst.frc.team578.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ElevatorCommand extends Command {
	
	private int desiredPosition;

	/**
	 * Sets the elevator to the specified position
	 * @param desiredPosition (1-4)
	 */
	public ElevatorCommand(int desiredPosition) {
		requires(Robot.elevatorSubsystem);
		this.desiredPosition = desiredPosition;
	}
	
	@Override
	protected void initialize() {
		
	}

	/**
	 * Sets the desired position of the elevator
	 */
	@Override
	protected void execute() {
		Robot.elevatorSubsystem.writeStatus();
		Robot.elevatorSubsystem.setLevel(desiredPosition);
	}

	/**
	 * Is finished once the elevator subsystem states that elevator has
	 * reached the specified position
	 */
	@Override
	protected boolean isFinished() {
		
		//SmartDashboard.putBoolean("isFinished", Robot.elevatorSubsystem.getCurrentLevel() == desiredPosition);
		//return Robot.elevatorSubsystem.getCurrentLevel() == desiredPosition;
		return false;
	}

	@Override
	protected void end() {
		
	}

	@Override
	protected void interrupted() {
		

	}
}