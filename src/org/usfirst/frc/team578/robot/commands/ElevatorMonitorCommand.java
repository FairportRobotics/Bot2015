package org.usfirst.frc.team578.robot.commands;

import org.usfirst.frc.team578.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Updates the elevator subsystem loop for monitoring and logging purposes. 
 * Not to be called normally, and never finishes. Is elevator's default command.
 */
public class ElevatorMonitorCommand extends Command {

	public ElevatorMonitorCommand()
	{
		requires(Robot.elevatorSubsystem);
	}
	
	@Override
	protected void initialize() {

	}

	@Override
	protected void execute() {
		Robot.elevatorSubsystem.update();
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
