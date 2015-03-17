package org.usfirst.frc.team578.robot.commands;
import java.util.logging.Level;

import org.usfirst.frc.team578.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ElevatorCommand extends Command {

	private boolean goingTo2 = false;
	private long commandStartTime;
	private int desiredPosition;

	/**
	 * Sets the elevator to the specified position
	 * @param desiredPosition (1-4)
	 */
	public ElevatorCommand(int desiredPosition) {
		requires(Robot.elevatorSubsystem);
		this.desiredPosition = desiredPosition;
		goingTo2 = desiredPosition == 2;
		commandStartTime = System.currentTimeMillis();
	}

	@Override
	protected void initialize() {
		Robot.elevatorSubsystem.start();
		Robot.log.write(Level.WARNING, "Desired elevator position set to " + desiredPosition + "!");
	}

	/**
	 * Sets the desired position of the elevator
	 */
	@Override
	protected void execute() {
		
		SmartDashboard.putNumber("Runtime", System.currentTimeMillis() - commandStartTime);
		
		if (goingTo2)
		{
			Robot.elevatorSubsystem.setLevel(3);
			if (System.currentTimeMillis() - commandStartTime > 1000)
			{
				goingTo2 = false;
			}
		}else
		{
			Robot.elevatorSubsystem.setLevel(desiredPosition);
		}
		Robot.elevatorSubsystem.update();
		Robot.elevatorSubsystem.writeStatus();

	}

	/**
	 * Is finished once the elevator subsystem states that elevator has
	 * reached the specified position
	 */
	@Override
	protected boolean isFinished() {

		//SmartDashboard.putBoolean("isFinished", Robot.elevatorSubsystem.getCurrentLevel() == desiredPosition);
		//return Robot.elevatorSubsystem.getCurrentLevel() == desiredPosition;
		return false;
	}

	@Override
	protected void end() {

	}

	@Override
	protected void interrupted() {


	}
}