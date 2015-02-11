package org.usfirst.frc.team578.robot.commands;

import org.usfirst.frc.team578.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class EjectTotesCommand extends Command {

	private boolean fibWasFalse = false;
	private boolean running = false;
	private boolean offSwitch = false;

	/**
	 * Gets the fibinacci subsystem and writes a log.
	 */
	public EjectTotesCommand() {
		requires(Robot.fibinacciSubsystem);
		// SmartDashboard.putString("Eject", "true!");
	}

	/**
	 * Returns the variables as false when the program is initialized.
	 */
	@Override
	protected void initialize() {

		running = false;
		offSwitch = false;
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
					offSwitch = true;
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
	 * Has the fibWasFalse and offSwitch set to false when the command is ended.
	 */
	@Override
	protected void end() {

		// /////////////Robot.fibinacciSubsystem.stopFibinacci();
		fibWasFalse = false;
		offSwitch = false;
	}

	/**
	 * 
	 */
	@Override
	protected void interrupted() {

	}

	// /**
	// * Writes a log so that we know what is wrong with the command.
	// * @param message
	// */
	// private void writeLog(String message) {
	//
	// Scanner sc = null;
	//
	// try {
	// sc = new Scanner(log);
	// } catch (FileNotFoundException e1) {
	// e1.printStackTrace();
	// }
	//
	// String old = "";
	// while (sc.hasNextLine()) {
	// old += sc.nextLine() + "\n";
	// }
	//
	// PrintWriter pw = null;
	// try {
	// //pw = new PrintWriter(log.getOutputStream());
	// pw.write(old + "\n" + Robot.getElapsedTime() + " | " + message);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	//
	// pw.flush();
	// pw.close();
	// }

	// /**
	// * Writes a message on the file.
	// * @param message
	// */
	// public void writeLog2(String message) {
	// FileWriter fw = null;
	//
	// try {
	// fw = new FileWriter("/log.txt", true);
	//
	// fw.write(Robot.getElapsedTime() + " | " + message + "\n");
	// fw.flush();
	// fw.close();
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }

	// /**
	// * It will look at all the buttons and say whether
	// * the button is true are false and return it in a string.
	// * @return
	// */
	// public String getButtons() {
	// OI oi = Robot.oi;
	// String s = "";
	//
	// for (Field f : oi.getClass().getDeclaredFields()) {
	// if (f.getType().equals(Button.class)) {
	// f.setAccessible(true);
	// try {
	// s += f.getName() + ": "
	// + ((JoystickButton) f.get(oi)).get() + " ";
	// } catch (IllegalArgumentException | IllegalAccessException e) {
	// e.printStackTrace();
	// }
	// }
	// }
	// return s;
	// }
}