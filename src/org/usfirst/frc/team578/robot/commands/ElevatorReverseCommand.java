package org.usfirst.frc.team578.robot.commands;

import org.usfirst.frc.team578.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Moves the elevator in reverse for a specific amount of time. (milliseconds)
 *
 */
public class ElevatorReverseCommand extends Command {

	private long runTime;

	/**
	 * Constructs the command
	 * @param runTime - reverse time in milliseconds
	 */
	public ElevatorReverseCommand(long runTime) {
		requires(Robot.elevatorSubsystem);

		this.runTime = runTime;
	}

	@Override
	protected void initialize() {
		Robot.elevatorSubsystem.reverse(runTime);
	}

	@Override
	protected void execute() {

	}

	@Override
	protected boolean isFinished() {
		return true;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {

	}

}
