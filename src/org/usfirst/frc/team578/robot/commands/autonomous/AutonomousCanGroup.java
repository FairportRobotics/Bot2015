package org.usfirst.frc.team578.robot.commands.autonomous;

import org.usfirst.frc.team578.robot.commands.SpinStopCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;
/**
 * Grabs a can and drives backwards into the zone.
 *
 */
public class AutonomousCanGroup extends CommandGroup {
	
	public AutonomousCanGroup()
	{
		addSequential(new AutonomousIntakeCommand(),4);
		addParallel(new AutonomousDriveCommand( -.25, -.25, -.25, -.25, 5));
		addSequential(new SpinStopCommand());
		addSequential(new AutonomousDriveCommand(0,0,0,0));
		//addSequential(new ElevatorCommand(4));
		//addSequential(new ElevatorCommand(1));
		//addSequential(new AutonomousDriveCommand( -.5, -.5, -.5, -.5, 1));
		//addSequential(new AutonomousDriveCommand( .5, -.5, .5, -.5, 1));
		//addSequential(new AutonomousDriveCommand(.5, .5, .5, .5, 4));
	}

}
