package org.usfirst.frc.team578.robot.subsystems;

import org.usfirst.frc.team578.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ElevatorSubsystem extends Subsystem {

//	DigitalInput levelOne = new DigitalInput(RobotMap.ELEVATOR_LEVEL_ONE_SWITCH);
	DigitalInput levelTwo = new DigitalInput(RobotMap.ELEVATOR_LEVEL_TWO_SWITCH);
	DigitalInput levelThree = new DigitalInput(RobotMap.ELEVATOR_LEVEL_THREE_SWITCH);
//	DigitalInput levelFour = new DigitalInput(RobotMap.ELEVATOR_LEVEL_FOUR_SWITCH);

	CANTalon elevatorTalon = new CANTalon(RobotMap.ELEVATOR_TALON);

	int currLevel = 1;

	public ElevatorSubsystem() {
		// TODO Auto-generated constructor stub
		elevatorTalon.enableLimitSwitch(true,true);
	}
	
	@Override
	protected void initDefaultCommand() {
		
	}

	public int getCurrentLevel(){
		return currLevel;
	}
	
	public void setLevel(int level) 
	{
		int offset = currLevel - level;

		if (offset > 0) {
			elevatorTalon.set(0.5);
		} else if (offset < 0) {
			elevatorTalon.set(-0.5);
		}

		if (levelTwo.get()) {
			if (level == 2) {
				elevatorTalon.set(0);
				currLevel = 2;;
			}
		} else if (levelThree.get()) {
			if (level == 3) {
				elevatorTalon.set(0);
				currLevel = 3;
			}
		}
	}

}
