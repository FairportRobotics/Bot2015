package org.usfirst.frc.team578.robot.commands.autonomous;

import org.usfirst.frc.team578.robot.commands.EjectTotesCommand;
import org.usfirst.frc.team578.robot.commands.ElevatorCommand;
import org.usfirst.frc.team578.robot.commands.SpinEjectCommand;
import org.usfirst.frc.team578.robot.commands.SpinStopCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousStackGroup extends CommandGroup {
	
	public AutonomousStackGroup()
	{
		//addSequential(new AutonomousDriveCommand(.5,.5,.5,.5));
		addParallel(new AutonomousIntakeCommand(), 2);
		addSequential(new AutonomousDriveCommand(0.75, 0.75, 0.75, 0.75, 0.25));
		addSequential(new AutonomousDriveCommand(0, 0, 0, 0));
		addSequential(new SpinStopCommand());
		addSequential(new ElevatorCommand(4));
		addSequential(new ElevatorCommand(1));
		addParallel(new AutonomousIntakeCommand(), 3);
		addSequential(new AutonomousDriveCommand(0.75, 0.75, 0.75, 0.75, 2));
		addSequential(new AutonomousDriveCommand(0, 0, 0, 0));
		addSequential(new SpinStopCommand());
		addSequential(new ElevatorCommand(4));
		addSequential(new ElevatorCommand(1));
		addParallel(new AutonomousIntakeCommand(), 3);
		addSequential(new AutonomousDriveCommand(0.75, 0.75, 0.75, 0.75, 2));
		addSequential(new AutonomousDriveCommand(0,0,0,0, 0.25));
		addSequential(new SpinStopCommand());
		addSequential(new ElevatorCommand(4));
		addSequential(new ElevatorCommand(1));
		addSequential(new AutonomousDriveCommand(1, 1, -1, -1, 3));
		addSequential(new AutonomousDriveCommand(0, 0, 0, 0));
		addParallel(new SpinEjectCommand());
		addSequential(new EjectTotesCommand());
	}

}
