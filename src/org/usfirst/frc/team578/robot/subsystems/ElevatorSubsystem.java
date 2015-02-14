package org.usfirst.frc.team578.robot.subsystems;

import org.usfirst.frc.team578.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.ControlMode;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ElevatorSubsystem extends Subsystem {

	//	DigitalInput levelOne
	private DigitalInput levelTwo;
	//DigitalInput levelThree
	private DigitalInput levelThree;
	//	DigitalInput levelFour

	//Reverse limit switch is the top
	//Forward limit switch is the bottom

	private CANTalon elevatorTalon;

	private int currLevel = 1;

	private long talonStartTime;

	public final boolean enabled;
	private boolean timedOut = false;

	/**
	 * Constructs the subsystem, including 2 digital inputs for switches,
	 * and the Talon for the elevator. 
	 */
	public ElevatorSubsystem(boolean enable) 
	{
		this.enabled = enable;

		if (!enabled)
			return;

		levelTwo = new DigitalInput(RobotMap.ELEVATOR_LEVEL_TWO_SWITCH);
		levelThree = new DigitalInput(RobotMap.ELEVATOR_LEVEL_THREE_SWITCH);

		elevatorTalon = new CANTalon(RobotMap.ELEVATOR_TALON);

		//elevatorTalon.ConfigFwdLimitSwitchNormallyOpen(false);
		//elevatorTalon.ConfigRevLimitSwitchNormallyOpen(false);
		elevatorTalon.changeControlMode(ControlMode.PercentVbus);
	}

	/**
	 * Writes the position of the elevator to the SmartDashboard
	 */
	public void writeStatus()
	{
		if (!enabled)
			return;

		//		SmartDashboard.putBoolean("Fwd Closed", elevatorTalon.isFwdLimitSwitchClosed());
		//		SmartDashboard.putBoolean("Rev Closed", elevatorTalon.isRevLimitSwitchClosed());
		//		SmartDashboard.putNumber("curr level", currLevel);

		SmartDashboard.putString("Limit", "Three:" + levelThree.get() + " Two:" + levelTwo.get());

		switch (currLevel)
		{
		case 1: SmartDashboard.putString("Elevator Level", "1: BOTTOM"); break;
		case 2: SmartDashboard.putString("Elevator Level", "2: LOW"); break;
		case 3: SmartDashboard.putString("Elevator Level", "3: HIGH"); break;
		case 4: SmartDashboard.putString("Elevator Level", "4: TOP"); break;
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

	public void setLevelTest(int level)
	{
		if (!enabled)
			return;

		if (level == 4)
		{
			elevatorTalon.set(0.5);
		}
		else if (level == 1)
		{
			elevatorTalon.set(-0.5);
		}
		else if (level == 2)
		{
			elevatorTalon.set(0);
		}
	}

	/**
	 * Sets the level of the elevator to a specific position (1-4)
	 * @param level
	 */
	public void setLevel(int level) 
	{
		if (!enabled)
			return;

		//DRIVING THE TALON WITH A NEGATIVE VALUE
		//MAKES IT GO UP! POSITIVE GOES DOWN!

		SmartDashboard.putNumber("Desired Level: ", level);

		int offset = currLevel - level;

		if (!timedOut)
		{
			if (offset > 0) {
				elevatorTalon.set(0.5);
			} else if (offset < 0) {
				elevatorTalon.set(-0.5);
			}

			if(level==4)
			{
				elevatorTalon.set(-0.5);
			}
			else if(level==1)
			{
				elevatorTalon.set(0.5);
			}
		}

		//		if (talonStartTime == 0)
		//		{
		//			talonStartTime = System.currentTimeMillis();
		//		}

		//		if (elevatorTalon.isFwdLimitSwitchClosed())
		//		{
		//			if (level == 1)
		//			{
		//				elevatorTalon.set(0);
		//				currLevel = 1;
		//			}
		//		}
		//		else if (!levelTwo.get()) 
		//		{
		//			
		//			if (level == 2) 
		//			{
		//				elevatorTalon.set(0);
		//				currLevel = 2;
		//			}
		//		} 
		//		else if (!levelThree.get()) 
		//		{
		//			
		//
		//			if (level == 3) 
		//			{
		//				elevatorTalon.set(0);
		//				currLevel = 3;
		//			}
		//		} 
		//		else if (elevatorTalon.isRevLimitSwitchClosed())
		//		{
		//
		//			if (level == 4)
		//			{
		//				elevatorTalon.set(0);
		//				currLevel = 4;
		//			}
		//		}

		if (elevatorTalon.isFwdLimitSwitchClosed())
		{
			currLevel = 1;
		}
		
		if (levelTwo.get())
		{
			currLevel = 2;
		}
		
		if (levelThree.get())
		{
			currLevel = 3;
		}
		
		if (elevatorTalon.isRevLimitSwitchClosed())
		{
			currLevel = 4;
		}
		
		if(level == 1){
			if(!elevatorTalon.isFwdLimitSwitchClosed()){
				elevatorTalon.set(0);
			}
		}else if(level == 2){
			if(levelTwo.get()){
				elevatorTalon.set(0);
			}else if(currLevel == level)
			{
				elevatorTalon.set(-0.5);
			}
		}else if(level == 3){
			if(levelThree.get()){
				elevatorTalon.set(0);
			}else if(currLevel == level)
			{
				elevatorTalon.set(-0.5);
			}
		}else if(level == 4){
			if(!elevatorTalon.isRevLimitSwitchClosed()){
				elevatorTalon.set(0);
			}else if(currLevel == level)
			{
				elevatorTalon.set(-0.5);
			}
		}
	}

	public void update() {
		if(System.currentTimeMillis()-talonStartTime>5000)
		{
			timedOut = true;
			elevatorTalon.set(0);
		}
	}

	public void start() {
		timedOut = false;
		talonStartTime = System.currentTimeMillis();
	}
}
