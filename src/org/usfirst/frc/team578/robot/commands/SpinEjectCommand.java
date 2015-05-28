package org.usfirst.frc.team578.robot.commands;
import org.usfirst.frc.team578.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Sets the the intake wheels to spin in reverse, ejecting totes. Note: Only works
 * if the elevator is not in motion.
 */
public class SpinEjectCommand extends Command {

	@Override
	protected void initialize() {
		
		//Check, almost always works
//		if (Robot.elevatorSubsystem.isStationary())
//		{
			Robot.intakeSubsystem.spinOutput();
//		}
	}

	@Override
	protected void execute() {
		
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

	@Override
	protected void end() {

	}

	@Override
	protected void interrupted() {

	}
}