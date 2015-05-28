package org.usfirst.frc.team578.robot.commands.autonomous;

import org.usfirst.frc.team578.robot.commands.SpinEjectCommand;
import org.usfirst.frc.team578.robot.commands.SpinIntakeCommand;
import org.usfirst.frc.team578.robot.commands.SpinStopCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class AutonomousSingleCanGroup extends CommandGroup {

	public AutonomousSingleCanGroup()
	{
		addSequential(new SpinIntakeCommand());
		addSequential(new WaitCommand(1.5));
		addSequential(new SpinStopCommand());
		//Drive back 1.75 sec:
		addSequential(new AutonomousDriveCommand(-.75, -.75, -.75, -.75, 1.75)); 
		addSequential(new AutonomousDriveCommand(0,0,0,0)); //Stop
		addSequential(new SpinEjectCommand());
		addSequential(new WaitCommand(1.5));
		addSequential(new SpinStopCommand());
	}
}
