package org.usfirst.frc.team578.robot.commands;
import org.usfirst.frc.team578.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class SpinEjectCommand extends Command {
	
	/**
	 * 
	 */
	@Override
	protected void initialize() {

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
		
	}
	
	/**
	 * 
	 */
	@Override
	protected void interrupted() {

	}
}