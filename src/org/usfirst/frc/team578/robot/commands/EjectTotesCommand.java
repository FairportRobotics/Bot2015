package org.usfirst.frc.team578.robot.commands;

import org.usfirst.frc.team578.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class EjectTotesCommand extends Command {

	private boolean fibWasFalse = false;
	private boolean running = false;
	//private boolean offSwitch = false;

	public EjectTotesCommand() {
		requires(Robot.fibinacciSubsystem);
	}

	/**
	 * Initializes variables as false
	 */
	@Override
	protected void initialize() {

		running = false;
		//offSwitch = false;
	}

	/**
	 * Ejects the totes
	 */
	@Override
	protected void execute() {

		/*
		 * Has the fibinacci wheel stop after the beam from the sensor has been
		 * broken twice.
		 */

		SmartDashboard.putString("FIB SWITCH",
				Robot.fibinacciSubsystem.readSwitch() + "");

		// TYLER CODE
		// if(!Robot.fibinacciSubsystem.readSwitch()){
		// Robot.fibinacciSubsystem.extendFibinacci();
		// }else{
		// Robot.fibinacciSubsystem.stopFibinacci();
		// }

		if (running == true) {
			if (Robot.fibinacciSubsystem.readSwitch() == false) {
				if (fibWasFalse == true) {
					Robot.fibinacciSubsystem.stopFibinacci();
					running=false;
					//offSwitch = true;
				}
			} else {
				fibWasFalse = true;
			}
		} else {
			Robot.fibinacciSubsystem.extendFibinacci();
			running = true;
		}

		// SmartDashboard.putBoolean("Fibinacci Value", fibWasFalse);
	}

	/**
	 * Returns the off switch as false when the code is finished.
	 */
	@Override
	protected boolean isFinished() {

		boolean ret;
		if ((!running) && (!Robot.oi.getButtonNine())) {
			ret = true;
			//Robot.messenger.sendMessage("finish: true");
		} else {
			ret = false;
		}
		return ret;

		// return Robot.fibinacciSubsystem.readSwitch();
	}

	/**
	 * Has the fibWasFalse set to false when the command is ended.
	 */
	@Override
	protected void end() {

		// /////////////Robot.fibinacciSubsystem.stopFibinacci();
		fibWasFalse = false;
		//offSwitch = false;
	}

	@Override
	protected void interrupted() {

	}
}