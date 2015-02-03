package org.usfirst.frc.team578.robot.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.ControlMode;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.livewindow.LiveWindowSendable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PIDDrive extends Subsystem {

	private CANTalon talon;
	
	public PIDDrive()
	{
		talon = initializeTalon(1);
		LiveWindow.addActuator("PIDDrive", "Talon", (LiveWindowSendable) talon);
	}
	
	public void drive(double val)
	{
		talon.set(val);
	}
	
	public void writeStatus()
	{
		SmartDashboard.putString("TalonStatus: ", "P: " + talon.getP() 
				+ " I: " + talon.getI() 
				+ " D: " + talon.getD() 
				+ " Speed" + talon.getEncVelocity());
	}
	
	@Override
	protected void initDefaultCommand() {

	}
	
	public CANTalon initializeTalon(int channel) {
		CANTalon talon = new CANTalon(channel);
		talon.changeControlMode(ControlMode.Speed);
		talon.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		talon.setPID(2, 0, 0, 0, 0, 10, 0);
		talon.enableControl();
		return talon;
	}

}
