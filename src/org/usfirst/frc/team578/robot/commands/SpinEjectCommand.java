package org.usfirst.frc.team578.robot.commands;
import org.usfirst.frc.team578.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class SpinEjectCommand extends Command {
	
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
		Robot.intakeSubsystem.spinOutput();
	}

	/**
	 * 
	 */
	@Override
	protected boolean isFinished() {
		return true;
	}

	/**
	 * 
	 */
	@Override
	protected void end() {
		// TODO Auto-generated method stub
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