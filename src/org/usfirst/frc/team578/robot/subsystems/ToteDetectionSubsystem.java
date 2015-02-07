package org.usfirst.frc.team578.robot.subsystems;

import org.usfirst.frc.team578.robot.RobotMap;
import org.usfirst.frc.team578.robot.commands.ToteDetectionCommand;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ToteDetectionSubsystem extends Subsystem {
	
	DigitalInput toteDetectionSensor;

	public ToteDetectionSubsystem()
	{
		toteDetectionSensor = new DigitalInput(RobotMap.TOTE_DETECTION_SENSOR);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
		setDefaultCommand(new ToteDetectionCommand());

	}

	
	public boolean isToteDetected()
	{
		return toteDetectionSensor.get();
	}
}
