package org.usfirst.frc.team578.robot.subsystems;

import org.usfirst.frc.team578.robot.RobotMap;
import org.usfirst.frc.team578.robot.commands.DriveCommand;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.ControlMode;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveSubsystem extends Subsystem {

	private CANTalon frontLeftTalon;
	private CANTalon frontRightTalon;
	private CANTalon backLeftTalon;
	private CANTalon backRightTalon;
	public final boolean enabled;

	
	public DriveSubsystem(boolean enable)
	{
		this.enabled = enable;

		if (!enabled)
			return;

		frontLeftTalon = initializeTalon(RobotMap.FRONT_LEFT_TALON);
		frontRightTalon = initializeTalon(RobotMap.FRONT_RIGHT_TALON);
		backLeftTalon = initializeTalon(RobotMap.BACK_LEFT_TALON);
		backRightTalon = initializeTalon(RobotMap.BACK_RIGHT_TALON);
	}

	/**
	 *  Sets the default command to the DriveCommand, so that it will respond
	 *  to joystick input at any time during Teleop.
	 */
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new DriveCommand());
	}

	public void writeStatus()
	{
		if (!enabled)
			return;

		SmartDashboard.putString("BackLeft", backLeftTalon.getSpeed() + " " + backLeftTalon.getEncVelocity());
		SmartDashboard.putString("BackRight", backRightTalon.getSpeed() + " " + backRightTalon.getEncVelocity());
		SmartDashboard.putString("FrontLeft", frontLeftTalon.getSpeed() + " " + frontLeftTalon.getEncVelocity());
		SmartDashboard.putString("FrontRight", frontRightTalon.getSpeed() + " " + frontRightTalon.getEncVelocity());

	}

	/**
	 * <p>
	 * Drives the robot using joystick input values, and is designed for mecanum drive.
	 *  Values will be scaled before being assigned as motor speeds. Use 
	 * {@link #driveMotors(double, double, double, double)}
	 * to set actual motor values. 
	 * </p>
	 * 
	 * <p>
	 * Accepts double values -1 to 1.
	 * </p>
	 * 
	 * @param leftX		left joystick's x value
	 * @param leftY 	left joystick's y value
	 * @param rightX 	right joystick's x value
	 * @param rightY 	right joystick's y value
	 */
	public void driveJoysticks(double leftX, double leftY, double rightX, double rightY) 
	{

		if (!enabled)
			return;
		
		if (leftX < 0.3 && leftX > -0.3) {
			frontLeftTalon.set(leftY * 500);
			backLeftTalon.set(leftY * 500);
		} else {
			frontLeftTalon.set(leftX * 500);
			backLeftTalon.set(-leftX * 500);
		}

		if (rightX < 0.3 && rightX > -0.3) {
			frontRightTalon.set(-rightY * 500);
			backRightTalon.set(-rightY * 500);
		} else {
			frontRightTalon.set(rightX * 500);
			backRightTalon.set(-rightX * 500);
		}
	}

	/**
	 * 
	 * @param channel 	The channel that the Talon will be running on.
	 * @return 		Returns the newly created Talon object.
	 */
	private CANTalon initializeTalon(int channel) {
		CANTalon talon = new CANTalon(channel);
		//talon.changeControlMode(ControlMode.PercentVbus);
		talon.changeControlMode(ControlMode.Speed);
		talon.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		talon.setPID(1, 0.01, 0.85, 1.5, 0, 0, 0);
		talon.enableControl();
		return talon;
	}


	/**
	 * <p>
	 * Sets drive train motor speeds after scaling the values. Use
	 * {@link #driveJoysticks(double, double, double, double)} for joysticks.
	 * </p>
	 * <p>
	 * Accepts double values from -1 to 1.
	 * </p>
	 * 
	 * @param fr
	 * @param fl
	 * @param br
	 * @param bl
	 */
	public void driveMotors(double fr, double fl, double br, double bl) {

		if (!enabled)
			return;

		backLeftTalon.set(bl * 100);
		backRightTalon.set(br * 100);
		frontLeftTalon.set(fl * 100);
		frontRightTalon.set(fr * 100);
	}
}