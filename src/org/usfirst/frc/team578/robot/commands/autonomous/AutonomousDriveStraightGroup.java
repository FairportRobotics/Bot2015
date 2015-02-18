package org.usfirst.frc.team578.robot.commands.autonomous;

import org.usfirst.frc.team578.robot.commands.ElevatorCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousDriveStraightGroup extends CommandGroup {
	
	public AutonomousDriveStraightGroup()
	{
		addSequential(new AutonomousDriveCommand(.25, .25, .25, .25, 3));
		addSequential(new AutonomousDriveCommand(0, 0, 0, 0));
		addSequential(new ElevatorCommand(2));
	}
}
