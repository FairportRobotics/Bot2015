package org.usfirst.frc.team578.robot.commands.autonomous;

import org.usfirst.frc.team578.robot.commands.ElevatorCommand;
import org.usfirst.frc.team578.robot.commands.SpinIntakeCommand;
import org.usfirst.frc.team578.robot.commands.SpinStopCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousToteGroup extends CommandGroup {
	
	public AutonomousToteGroup()
	{
		addSequential(new ElevatorCommand(1));
		addSequential(new SpinIntakeCommand());
		addParallel(new AutonomousDriveCommand(.5, .5, .5, .5, .25));
		addParallel(new AutonomousDriveCommand(0, 0, 0, 0));
		addSequential(new SpinStopCommand());
		addSequential(new ElevatorCommand(4));
		addSequential(new ElevatorCommand(1));
		addSequential(new AutonomousDriveCommand( -.25, .25, -.25, .25, 1));
		addSequential(new AutonomousDriveCommand( .5, .5, .5, .5, 3));
	}

}
