package org.usfirst.frc.team578.robot.subsystems;

import org.usfirst.frc.team578.robot.RobotMap;
import org.usfirst.frc.team578.robot.commands.ReadToteCommand;

import edu.wpi.first.wpilibj.DigitalInput;

public class ToteDetectionSubsystem extends SubsystemBase {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	private DigitalInput dio;

	public ToteDetectionSubsystem(boolean enable)
	{
		super(enable);

		if(!enabled)
			return;

		dio = new DigitalInput(RobotMap.TOTE_SENSOR);
	}

	public void initDefaultCommand()
	{
		setDefaultCommand(new ReadToteCommand());
	}

	/**
	 * Gets the state of the tote detection sensor or false if not enabled.
	 * @return
	 */
	public boolean get(){
		if (!enabled)
			return false;

		return dio.get();
	}


}

