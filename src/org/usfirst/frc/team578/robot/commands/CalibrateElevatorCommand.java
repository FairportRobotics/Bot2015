package org.usfirst.frc.team578.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Calculates the elevator level positions by driving the elevator to the bottom
 * limit switch and adding offsets to the bottom position.
 *
 */
public class CalibrateElevatorCommand extends CommandGroup {

	public CalibrateElevatorCommand()
	{
		addSequential(new ElevatorCommand(0));
	}

}