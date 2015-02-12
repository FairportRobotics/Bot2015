package org.usfirst.frc.team578.robot.commands;

import org.usfirst.frc.team578.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ReadToteCommand extends Command {

	public ReadToteCommand() {
		requires(Robot.toteDetectionSubsystem);
	}
	
	@Override
	protected void initialize() {

	}

	/**
	 * Writes whether or not a tote is detected in the robot to the SmartDashboard
	 */
	@Override
	protected void execute() {
		SmartDashboard.putBoolean("Tote Sensor", Robot.toteDetectionSubsystem.get());
	}

	/**
	 * Is never finished
	 */
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
