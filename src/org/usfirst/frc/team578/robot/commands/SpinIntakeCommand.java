package org.usfirst.frc.team578.robot.commands;
import org.usfirst.frc.team578.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Sets the the intake wheels to spin forward, drawing in a tote. Note: only
 * works if the elevator is not in motion. Finishes instantly.
 */
public class SpinIntakeCommand extends Command {

	@Override
	protected void initialize() {
		//		if (Robot.elevatorSubsystem.isStationary())
		//		{
		Robot.intakeSubsystem.spinIntake();
		//		}
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