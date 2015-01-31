package org.usfirst.frc.team578.robot.commands;
import org.usfirst.frc.team578.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class SpinIntakeCommand extends Command {

	/**
	 * 
	 */
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
	}

	/**
	 * 
	 */
	@Override
	protected void execute() {
		Robot.intakeSubsystem.spinIntake();
	}

	/**
	 * 
	 */
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * 
	 */
	@Override
	protected void end() {
		Robot.intakeSubsystem.spinStop();
	}

	/**
	 * 
	 */
	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
	}
}