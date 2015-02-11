package org.usfirst.frc.team578.robot.subsystems;

import org.usfirst.frc.team578.robot.commands.LogCommand;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Subsystem;

public class PDPSubystem extends Subsystem {

	PowerDistributionPanel pdp;
	
	public PDPSubystem() {
		pdp = new PowerDistributionPanel();
	}
	
	public double getInputVoltage()
	{
		return pdp.getVoltage();
	}
	
	public double getTotalCurrent()
	{
		return pdp.getTotalCurrent();
	}
	
	public double getTemperature()
	{
		return pdp.getTemperature();
	}
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new LogCommand());
	}

}
