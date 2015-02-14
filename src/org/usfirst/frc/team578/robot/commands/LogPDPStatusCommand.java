package org.usfirst.frc.team578.robot.commands;

import java.util.logging.Level;

import org.usfirst.frc.team578.robot.Robot;
import org.usfirst.frc.team578.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class LogPDPStatusCommand extends Command{

	private long lastLogTime;
	
	public LogPDPStatusCommand() {
		requires(Robot.pdpSubystem);
	}
	
	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		if (System.currentTimeMillis() - lastLogTime > RobotMap.LOG_VOLTAGE_INTERVAL)
		{
			lastLogTime = System.currentTimeMillis();
			Robot.log.write(Level.INFO, "Voltage: " + Robot.pdpSubystem.getInputVoltage() 
					+ " | Current: " + Robot.pdpSubystem.getTotalCurrent() 
					+ " | Temp: " + Robot.pdpSubystem.getTemperature());
		}
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		
	}

	@Override
	protected void interrupted() {
		
	}

}
