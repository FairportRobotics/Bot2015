package org.usfirst.frc.team578.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Moves the elevator to position 4 (top), then reverses slightly for 1 second 
 * to let the totes down gently.
 *
 */
public class ElevatorLevel4CommandGroup extends CommandGroup {

	public ElevatorLevel4CommandGroup()
	{
		addSequential(new ElevatorCommand(4));
		addSequential(new ElevatorReverseCommand(1500));//MS
	}
	
}