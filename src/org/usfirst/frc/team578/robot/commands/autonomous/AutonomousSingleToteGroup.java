package org.usfirst.frc.team578.robot.commands.autonomous;

import org.usfirst.frc.team578.robot.commands.EjectTotesCommand;
import org.usfirst.frc.team578.robot.commands.ElevatorCommand;
import org.usfirst.frc.team578.robot.commands.SpinEjectCommand;
import org.usfirst.frc.team578.robot.commands.SpinIntakeCommand;
import org.usfirst.frc.team578.robot.commands.SpinStopCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class AutonomousSingleToteGroup extends CommandGroup {
	
	public AutonomousSingleToteGroup()
	{
		addSequential(new ElevatorCommand(1)); //Ensure level 1 for safety
		addSequential(new SpinIntakeCommand());
		//Drive into tote, hopefully intaking it:
		addSequential(new AutonomousDriveCommand(.1, .1, .1, .1, 1.5));
		addSequential(new AutonomousDriveCommand(0, 0, 0, 0)); //Stop driving
		addSequential(new SpinStopCommand());
		addSequential(new ElevatorCommand(2)); //Take the elevator to 2 for driving safety
		addSequential(new AutonomousDriveCommand( 0.9, -0.9, 0.9, -0.9, 0.8)); //Turn right
		addSequential(new AutonomousDriveCommand(0,0,0,0)); //Stop
		addSequential(new AutonomousDriveCommand(.5, .5, .5, .5, 1)); //Drive forward 3 sec
		addSequential(new AutonomousDriveCommand(0,0,0,0)); //Stop
		addSequential(new ElevatorCommand(1)); //Drop to 1 for ejecting
		addSequential(new SpinEjectCommand());
		addSequential(new EjectTotesCommand()); //Eject tote
		addSequential(new WaitCommand(1.5));
		addSequential(new SpinStopCommand());
	}

}
