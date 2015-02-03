package org.usfirst.frc.team578.robot.subsystems;

import org.usfirst.frc.team578.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.ControlMode;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ElevatorSubsystem extends Subsystem {

	//	DigitalInput levelOne = new DigitalInput(RobotMap.ELEVATOR_LEVEL_ONE_SWITCH);
	DigitalInput levelTwo = new DigitalInput(RobotMap.ELEVATOR_LEVEL_TWO_SWITCH);
	//DigitalInput levelThree = new DigitalInput(RobotMap.ELEVATOR_LEVEL_THREE_SWITCH);
	DigitalInput levelThree = levelTwo;
	//	DigitalInput levelFour = new DigitalInput(RobotMap.ELEVATOR_LEVEL_FOUR_SWITCH);

	//Reverse limit switch is the top
	//Forward limit switch is the bottom

	CANTalon elevatorTalon = new CANTalon(RobotMap.ELEVATOR_TALON);

	int currLevel = 1;

	public ElevatorSubsystem() {
		// TODO Auto-generated constructor stub
		elevatorTalon.ConfigFwdLimitSwitchNormallyOpen(false);
		elevatorTalon.ConfigRevLimitSwitchNormallyOpen(false);
		elevatorTalon.changeControlMode(ControlMode.PercentVbus);
	}

	public void writeStatus()
	{
		SmartDashboard.putBoolean("Fwd Closed", elevatorTalon.isFwdLimitSwitchClosed());
		SmartDashboard.putBoolean("Rev Closed", elevatorTalon.isRevLimitSwitchClosed());
		SmartDashboard.putNumber("curr level", currLevel);
	}

	@Override
	protected void initDefaultCommand() {

	}

	public int getCurrentLevel(){
		return currLevel;
	}

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
