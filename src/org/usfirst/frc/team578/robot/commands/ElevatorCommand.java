package org.usfirst.frc.team578.robot.commands;
import java.util.logging.Level;

import org.usfirst.frc.team578.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Moves the elevator to a specified position.
 *
 */
public class ElevatorCommand extends Command {

	private int desiredPosition;

	/**
	 * Sets the elevator to the specified position. Use 0 to 
	 * calibrate the elevator bottom (home) positions
	 * @param desiredPosition (1-4) or 0 - home/calibrate
	 */
	public ElevatorCommand(int desiredPosition) {
		requires(Robot.elevatorSubsystem);
		this.desiredPosition = desiredPosition;
	}

	@Override
	protected void initialize() {
		//Robot.elevatorSubsystem.start();

		Robot.log.write(Level.WARNING, "Desired elevator position set to " + desiredPosition + "!");
		if (desiredPosition == 0) //For calibration
		{
			Robot.elevatorSubsystem.calibrateElevator();
		}
		else //For normal use
		{
			Robot.elevatorSubsystem.setLevel(desiredPosition);
		}
	}

	/**
	 * Sets the desired position of the elevator
	 */
	@Override
	protected void execute() {
		//Always update!
		Robot.elevatorSubsystem.update();
		Robot.elevatorSubsystem.writeStatus();
	}

	/**
	 * Is finished once the elevator subsystem states that elevator has
	 * reached the specified position
	 */
	@Override
	protected boolean isFinished() {
		return Robot.elevatorSubsystem.isStationary();
//		return true;
	}

	@Override
	protected void end() {
		
	}

	@Override
	protected void interrupted() {


	}
}