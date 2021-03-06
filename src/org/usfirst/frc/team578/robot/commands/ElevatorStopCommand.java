package org.usfirst.frc.team578.robot.commands;

import org.usfirst.frc.team578.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Stops the elevator at its current position.
 *
 */
public class ElevatorStopCommand extends Command {

	public ElevatorStopCommand() {
		requires(Robot.elevatorSubsystem);
	}
	
	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		Robot.elevatorSubsystem.stop();
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
