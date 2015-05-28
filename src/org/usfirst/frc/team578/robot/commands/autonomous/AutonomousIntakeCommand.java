package org.usfirst.frc.team578.robot.commands.autonomous;

import org.usfirst.frc.team578.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**<p>
 * Sets the intake to spin forward, taking in a tote.</p><p> isFinished() is never true,
 * so use a timeout in a CommandGroup. This allows you to easily add a sequential SpinStopCommand which
 * will stop the spinning after the scheduler timeout ends this command.</p>
 *
 */
public class AutonomousIntakeCommand extends Command {

	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		Robot.intakeSubsystem.spinIntake();
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
