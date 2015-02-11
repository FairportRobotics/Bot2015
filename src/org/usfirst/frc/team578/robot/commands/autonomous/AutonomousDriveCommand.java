package org.usfirst.frc.team578.robot.commands.autonomous;

import org.usfirst.frc.team578.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutonomousDriveCommand extends Command {
	
	public final double fr,fl,br,bl;
	private final double time;
	
	/**
	 * Drives with the specified values for the specified period of time
	 * @param fr
	 * @param fl
	 * @param br
	 * @param bl
	 * @param time drive time in seconds
	 */
	public AutonomousDriveCommand(double fr, double fl, double br, double bl, double time)
	{
		this.fr = fr;
		this.fl = fl;
		this.br = br;
		this.bl = bl;
		this.time = time;
	}

	@Override
	protected void initialize() {
		

	}

	@Override
	protected void execute() {
		
		//Robot.driveSubsystem.driveMotors(fr,fl,br,bl);
	}

	@Override
	protected boolean isFinished() {
		return (timeSinceInitialized() >= time);
	}

	@Override
	protected void end() {
		//Robot.driveSubsystem.driveMotors(0,0,0,0);
	}

	@Override
	protected void interrupted() {
		

	}

}
