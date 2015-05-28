package org.usfirst.frc.team578.robot.commands;

import java.util.logging.Level;

import org.usfirst.frc.team578.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Logs PDP values every x period of time.
 *
 */
public class LogPDPStatusCommand extends Command{

	private long lastLogTime;
	private static final int LOG_VOLTAGE_INTERVAL = 1000; //milliseconds

	public LogPDPStatusCommand() {
		requires(Robot.pdpSubystem);
	}

	@Override
	protected void initialize() {

	}

	@Override
	protected void execute() {
		if (System.currentTimeMillis() - lastLogTime > LOG_VOLTAGE_INTERVAL)
		{
			lastLogTime = System.currentTimeMillis();
			if (Robot.pdpSubystem.enabled)
			{
				Robot.log.write(Level.INFO, "Voltage: " + Robot.pdpSubystem.getInputVoltage() 
						+ " | Current: " + Robot.pdpSubystem.getTotalCurrent() 
						+ " | Temp: " + Robot.pdpSubystem.getTemperature());
			}
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
