package org.usfirst.frc.team578.robot.subsystems;

import org.usfirst.frc.team578.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.ControlMode;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ElevatorSubsystem extends Subsystem {

	//	DigitalInput levelOne = new DigitalInput(RobotMap.ELEVATOR_LEVEL_ONE_SWITCH);
	private DigitalInput levelTwo;
	//DigitalInput levelThree = new DigitalInput(RobotMap.ELEVATOR_LEVEL_THREE_SWITCH);
	private DigitalInput levelThree;
	//	DigitalInput levelFour = new DigitalInput(RobotMap.ELEVATOR_LEVEL_FOUR_SWITCH);

	//Reverse limit switch is the top
	//Forward limit switch is the bottom

	private CANTalon elevatorTalon;

	private int currLevel = 1;

	/**
	 * Constructs the subsystem, including 2 digital inputs for switches,
	 * and the Talon for the elevator. 
	 */
	public ElevatorSubsystem() 
	{
		levelTwo = new DigitalInput(RobotMap.ELEVATOR_LEVEL_TWO_SWITCH);
		levelThree = new DigitalInput(RobotMap.ELEVATOR_LEVEL_THREE_SWITCH);

		elevatorTalon = new CANTalon(RobotMap.ELEVATOR_TALON);

		elevatorTalon.ConfigFwdLimitSwitchNormallyOpen(false);
		elevatorTalon.ConfigRevLimitSwitchNormallyOpen(false);
		elevatorTalon.changeControlMode(ControlMode.PercentVbus);
	}

	/**
	 * Writes the position of the elevator to the SmartDashboard
	 */
	public void writeStatus()
	{
		//		SmartDashboard.putBoolean("Fwd Closed", elevatorTalon.isFwdLimitSwitchClosed());
		//		SmartDashboard.putBoolean("Rev Closed", elevatorTalon.isRevLimitSwitchClosed());
		//		SmartDashboard.putNumber("curr level", currLevel);

		switch (currLevel)
		{
		case 1: SmartDashboard.putString("Elevator Level", "1: BOTTOM"); break;
		case 2: SmartDashboard.putString("Elevator Level", "2: LOW"); break;
		case 3: SmartDashboard.putString("Elevator Level", "0: HIGH"); break;
		case 4: SmartDashboard.putString("Elevator Level", "0: TOP"); break;
		}
	}

	@Override
	protected void initDefaultCommand() {

	}

	/**
	 * Gets the current position of the elevator (At switches)
	 * @return
	 */
	public int getCurrentLevel(){
		return currLevel;
	}

	/**
	 * Sets the level of the elevator to a specific position (1-4)
	 * @param level
	 */
	public void setLevel(int level) 
	{
		SmartDashboard.putNumber("Desired Level: ", level);

		int offset = currLevel - level;

		if (offset > 0) {
			elevatorTalon.set(0.5);
		} else if (offset < 0) {
			elevatorTalon.set(-0.5);
		}

		if (!elevatorTalon.isFwdLimitSwitchClosed())
		{
			currLevel = 1;

			if (level == 1)
			{
				elevatorTalon.set(0);
			}
		}
		else if (!levelTwo.get()) 
		{
			currLevel = 2;

			if (level == 2) 
			{
				elevatorTalon.set(0);
			}
		} 
		else if (!levelThree.get()) 
		{
			currLevel = 3;

			if (level == 3) 
			{
				elevatorTalon.set(0);
			}
		} 
		else if (!elevatorTalon.isRevLimitSwitchClosed())
		{
			currLevel = 4;

			if (level == 4)
			{
				elevatorTalon.set(0);
			}
		}
	}

}
