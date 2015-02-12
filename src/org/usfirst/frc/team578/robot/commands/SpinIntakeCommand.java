package org.usfirst.frc.team578.robot.commands;
import org.usfirst.frc.team578.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SpinIntakeCommand extends Command {

	@Override
	protected void initialize() {
		
	}

	/**
	 * Sets the the intake wheels to spin forward, drawing in a tote.
	 */
	@Override
	protected void execute() {
		Robot.intakeSubsystem.spinIntake();
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