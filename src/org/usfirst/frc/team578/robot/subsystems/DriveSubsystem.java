package org.usfirst.frc.team578.robot.subsystems;

import org.usfirst.frc.team578.robot.commands.DriveCommand;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.ControlMode;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveSubsystem extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
//	CANTalon frontLeftTalon;
//	CANTalon frontRightTalon;
//	CANTalon backLeftTalon;
//	CANTalon backRightTalon;

	public DriveSubsystem()
	{
//		frontLeftTalon = initializeTalon(RobotMap.FRONT_LEFT_TALON);
//		frontRightTalon = initializeTalon(RobotMap.FRONT_RIGHT_TALON);
//		backLeftTalon = initializeTalon(RobotMap.BACK_LEFT_TALON);
//		backRightTalon = initializeTalon(RobotMap.BACK_RIGHT_TALON);
	}
	
	/**
	 * 
	 */
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new DriveCommand());
	}

	/**
	 * 
	 * @param leftX
	 * @param leftY
	 * @param rightX
	 * @param rightY
	 */
	public void drive(double leftX, double leftY, double rightX, double rightY) {
//		if (leftX < 0.3 && leftX > -0.3) {
//			frontLeftTalon.set(-leftY);
//			backLeftTalon.set(-leftY);
//		} else {
//			frontLeftTalon.set(leftX);
//			backLeftTalon.set(-leftX);
//		}
//
//		if (rightX < 0.3 && rightX > -0.3) {
//			frontRightTalon.set(rightY);
//			backRightTalon.set(rightY);
//		} else {
//			frontRightTalon.set(rightX);
//			backRightTalon.set(-rightX);
//		}
	}

	/**
	 * 
	 * @param channel
	 * @return
	 */
	public CANTalon initializeTalon(int channel) {
		CANTalon talon = new CANTalon(channel);
		talon.changeControlMode(ControlMode.Speed);
		talon.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		talon.setPID(2, 0, 0, 0, 0, 10, 0);
		talon.enableControl();
		return talon;
	}
}