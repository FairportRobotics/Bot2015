package org.usfirst.frc.team578.robot.commands;
import org.usfirst.frc.team578.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SpinIntakeCommand extends Command {

	/**
	 * Nothing Happening Here!
	 */
	@Override
	protected void initialize() {
		
	}

	/**
	 * The Class calls the subsystem and makes the wheels start spinning!
	 */
	@Override
	protected void execute() {
		Robot.intakeSubsystem.spinIntake();
	}

	/**
	 * Returns true!
	 */
	@Override
	protected boolean isFinished() {
		return true;
	}

	/**
	 * Stops the wheels from spinning!
	 */
	@Override
	protected void end() {

	}

	/**
	 * Nothing Happening Here!
	 */
	@Override
	protected void interrupted() {
		
	}
}