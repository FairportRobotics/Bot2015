package org.usfirst.frc.team578.robot.commands.autonomous;

import org.usfirst.frc.team578.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutonomousIntakeCommand extends Command {

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		Robot.intakeSubsystem.spinIntake();
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}

}
