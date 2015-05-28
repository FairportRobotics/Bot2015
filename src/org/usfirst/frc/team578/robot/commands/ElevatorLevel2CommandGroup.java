package org.usfirst.frc.team578.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ElevatorLevel2CommandGroup extends CommandGroup {
	
	public ElevatorLevel2CommandGroup()
	{
		addSequential(new ElevatorCommand(3));
		addSequential(new ElevatorCommand(2));
	}
	
}
