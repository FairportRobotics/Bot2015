package org.usfirst.frc.team578.robot.commands.autonomous;

import org.usfirst.frc.team578.robot.commands.ElevatorCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousDriveStraightGroup extends CommandGroup {
	
	public AutonomousDriveStraightGroup()
	{
		addParallel(new ElevatorCommand(1));
		addSequential(new AutonomousDriveCommand(.25, .25, .25, .25, 3.5));
		addSequential(new AutonomousDriveCommand(0, 0, 0, 0));
	}
}
