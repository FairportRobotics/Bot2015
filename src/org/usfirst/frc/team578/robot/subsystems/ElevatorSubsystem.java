package org.usfirst.frc.team578.robot.subsystems;

import org.usfirst.frc.team578.robot.RobotMap; 
import org.usfirst.frc.team578.robot.commands.ElevatorCommand;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ElevatorSubsystem extends Subsystem {
	
	DigitalInput levelOne = new DigitalInput(0);
	DigitalInput levelTwo = new DigitalInput(1);
	DigitalInput levelThree = new DigitalInput(2);
	DigitalInput levelFour = new DigitalInput(3);
	
	CANTalon elevatorTalon = new CANTalon(RobotMap.ELEVATOR_TALON);

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub 
	}
	
	
}
