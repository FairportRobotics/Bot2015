package org.usfirst.frc.team578.robot.subsystems;

import org.usfirst.frc.team578.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ElevatorSubsystem extends Subsystem {

	DigitalInput levelOne = new DigitalInput(RobotMap.ELEVATOR_LVL_1);
	DigitalInput levelTwo = new DigitalInput(RobotMap.ELEVATOR_LVL_2);
	DigitalInput levelThree = new DigitalInput(RobotMap.ELEVATOR_LVL_3);
	DigitalInput levelFour = new DigitalInput(RobotMap.ELEVATOR_LVL_4);

	CANTalon elevatorTalon = new CANTalon(RobotMap.ELEVATOR_TALON);

	private int currLevel = 1;

	@Override
	protected void initDefaultCommand()
	{
		// TODO Auto-generated method stub
	}

	public void setLevel(int level)
	{
		int offset = currLevel - level;

		if (offset > 0)
		{
			elevatorTalon.set(0.5);
		}
		else if (offset < 0)
		{
			elevatorTalon.set(-0.5);
		}
		
		
		if (level == 1)
		{
			if (levelOne.get())
			{
				elevatorTalon.set(0);
			}
		}
		else if (level == 2)
		{
			if (levelTwo.get())
			{
				elevatorTalon.set(0);
			}
		}
		else if (level == 3)
		{
			if (levelThree.get())
			{
				elevatorTalon.set(0);
			}
		}
		else if (level == 4)
		{
			if (levelFour.get())
			{
				elevatorTalon.set(0);
			}
		}
	}
}
