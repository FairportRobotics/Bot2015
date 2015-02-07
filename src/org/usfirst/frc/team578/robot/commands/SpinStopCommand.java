package org.usfirst.frc.team578.robot.commands;

import org.usfirst.frc.team578.robot.Robot;

import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.command.Command;

public class SpinStopCommand extends Command{

	@Override
	protected void initialize() {
	}

	/**
	 * Sets the spin speeds to zero once the fibinacci wheel speed setting is 
	 * verified to be zero.
	 */
	@Override
	protected void execute() {
		if (Robot.fibinacciSubsystem.getFibinacciStatus() == Value.kOff)
		{
			Robot.intakeSubsystem.spinStop();
		}
	}

	/**
	 * Is finished once the intake speed is set to zero, which 
	 * is only set after the fibinacci wheel has stopped
	 */
	@Override
	protected boolean isFinished() {
		// TODO Does this work?
		return Robot.intakeSubsystem.getSpeed() == 0;
	}

	@Override
	protected void end() {

	}

	@Override
	protected void interrupted() {

	}

}
