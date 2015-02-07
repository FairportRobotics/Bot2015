package org.usfirst.frc.team578.robot.commands.autonomous;

import org.usfirst.frc.team578.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutonomousIntakeCommand extends Command {

	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		Robot.intakeSubsystem.spinIntake();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		
	}

	@Override
	protected void interrupted() {

	}

}
