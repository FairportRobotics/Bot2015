package org.usfirst.frc.team578.robot.commands.autonomous;

import org.usfirst.frc.team578.robot.commands.ElevatorCommand;
import org.usfirst.frc.team578.robot.commands.SpinIntakeCommand;
import org.usfirst.frc.team578.robot.commands.SpinStopCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousToteGroup extends CommandGroup {
	
	public AutonomousToteGroup()
	{
		addSequential(new AutonomousDriveCommand( .5, .5, .5, .5, .25));
		addSequential(new SpinIntakeCommand(), 2);
		addSequential(new SpinStopCommand());
		addSequential(new ElevatorCommand(4));
		addSequential(new ElevatorCommand(1));
		addSequential(new AutonomousDriveCommand( -.5, .5, -.5, .5, 1));
		addSequential(new AutonomousDriveCommand( .5, .5, .5, .5, 4));
	}

}
