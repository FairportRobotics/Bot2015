package org.usfirst.frc.team578.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousDriveStraightGroup extends CommandGroup {
	
	public AutonomousDriveStraightGroup()
	{
		addSequential(new AutonomousDriveCommand(.5, .5, .5, .5), 3);
		addSequential(new AutonomousDriveCommand(0, 0, 0, 0), 0.1);
	}

}
