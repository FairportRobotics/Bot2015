package org.usfirst.frc.team578.robot.commands;

import org.usfirst.frc.team578.robot.Robot; 
import org.usfirst.frc.team578.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Command;

public class ElevatorCommand extends Command {

	
	private int desiredPosition;
	private boolean running;
	
	public ElevatorCommand(int desiredPosition) {
		// TODO Auto-generated constructor stub
        requires(Robot.elevatorSubsystem);
		this.desiredPosition = desiredPosition;
	}
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
        running = false;
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		if(running)
		{
				running = false;
		}
		else
		{
			Robot.elevatorSubsystem.setLevel(desiredPosition);
			running = true;
		}
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		if(!running)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}

}
