package org.usfirst.frc.team578.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

@Deprecated
public class PotTestCommand extends Command {

	public PotTestCommand() {
		//requires(Robot.pot);
	}
	
	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		//Robot.pot.writeStatus();
		
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
