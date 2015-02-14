package org.usfirst.frc.team578.robot.subsystems;

import org.usfirst.frc.team578.robot.commands.LogPDPStatusCommand;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Subsystem;

public class PDPSubystem extends Subsystem {

	private PowerDistributionPanel pdp;
	public final boolean enabled;

	public PDPSubystem(boolean enable) {
		this.enabled = enable;

		if (!enabled)
			return;

		pdp = new PowerDistributionPanel();
	}

	public double getInputVoltage()
	{
		if (!enabled)
			return -1;
		
		return pdp.getVoltage();
	}

	public double getTotalCurrent()
	{
		if (!enabled)
			return -1;
		
		return pdp.getTotalCurrent();
	}

	public double getTemperature()
	{
		if (!enabled)
			return -1;
		
		return pdp.getTemperature();
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new LogPDPStatusCommand());
	}

}
