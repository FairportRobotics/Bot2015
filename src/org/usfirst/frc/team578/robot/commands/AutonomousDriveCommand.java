package org.usfirst.frc.team578.robot.commands;

import org.usfirst.frc.team578.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutonomousDriveCommand extends Command {
	
	public final double fr,fl,br,bl;
	
	public AutonomousDriveCommand(double fr, double fl, double br, double bl)
	{
		this.fr = fr;
		this.fl = fl;
		this.br = br;
		this.bl = bl;
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		
		Robot.driveSubsystem.driveMotors(fr,fl,br,bl);
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
