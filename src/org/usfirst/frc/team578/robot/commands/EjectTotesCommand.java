package org.usfirst.frc.team578.robot.commands;

import org.usfirst.frc.team578.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class EjectTotesCommand extends Command {

	private boolean fibWasFalse = false;
	private boolean running = false;
	//private long spinStart = 0;
	//private boolean stoppedSpin = false;
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
		
//		if (spinStart != 0 && System.currentTimeMillis() - spinStart > 4000)
//		{
//			Robot.intakeSubsystem.spinStop();
//			stoppedSpin = true;
//		}

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
			int currLevel = Robot.elevatorSubsystem.getCurrentLevel();
			int desired = Robot.elevatorSubsystem.getDesiredLevel();
			if ((currLevel == 1 || currLevel == 2 || currLevel == 3) 
					&& (desired == 1 || desired == 2 || desired == 3))
			{
				//Robot.intakeSubsystem.spinOutput();
				//spinStart = System.currentTimeMillis();
				Robot.fibinacciSubsystem.extendFibinacci();
			}
			running = true;
		}

	}

	/**
	 * Returns the off switch as false when the code is finished.
	 */
	@Override
	protected boolean isFinished() {

		boolean ret;
		if ((!running) && (!Robot.oi.getButtonNine()) /*&& stoppedSpin*/) {
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

		///////////////Robot.fibinacciSubsystem.stopFibinacci();
		fibWasFalse = false;
		//offSwitch = false;
	}

	@Override
	protected void interrupted() {

	}
}