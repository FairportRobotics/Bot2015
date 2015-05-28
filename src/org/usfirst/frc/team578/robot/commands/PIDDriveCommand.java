package org.usfirst.frc.team578.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Drives the robot using PID values (thereby requiring encoders on the drivetrain)
 *
 */
@Deprecated
public class PIDDriveCommand extends Command {

	public PIDDriveCommand() {
		//requires(Robot.pid);
	}
	
	@Override
	protected void initialize() {
	
	}

	@Override
	protected void execute() {
		//SmartDashboard.putNumber("LeftJoy", Robot.oi.getLeftStickY());
		//Robot.pid.drive(Robot.oi.getLeftStickY());
		//Robot.pid.writeStatus();
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
