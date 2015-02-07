package org.usfirst.frc.team578.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousStackGroup extends CommandGroup {
	
	public AutonomousStackGroup()
	{
		//addSequential(new AutonomousDriveCommand(.5,.5,.5,.5));
		addSequential(new AutonomousIntakeCommand());
	}

}
