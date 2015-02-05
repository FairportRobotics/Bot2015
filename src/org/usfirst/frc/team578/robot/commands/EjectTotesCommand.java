package org.usfirst.frc.team578.robot.commands;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.Scanner;

import org.usfirst.frc.team578.robot.OI;
import org.usfirst.frc.team578.robot.Robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class EjectTotesCommand extends Command {
	
	private boolean fibWasFalse;
	private boolean running = false;
	private boolean offSwitch;
	private static File log = new File("/log.txt");

	/**
	 * Gets the fibinacci subsystem and writes a log.
	 */
	public EjectTotesCommand() {
		requires(Robot.fibinacciSubsystem);
		// SmartDashboard.putString("Eject", "true!");
		writeLog2("START");
	}

	/**
	 * Returns the variables as false when the program is initialized.
	 */
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		running = false;
		offSwitch = false;
	}

	/**
	 * 
	 */
	@Override
	protected void execute() {
		// TODO Auto-generated method stub

		/*
		 * 
		 * Has the fibinacci wheel stop after the beam from the sensor has been 
		 * broken twice.
		 */
		
		if(running == true)
		{
			if(Robot.fibinacciSubsystem.readSwitch() == false)
			{
				if(fibWasFalse == true)
				{
						Robot.fibinacciSubsystem.stopFibinacci();
						offSwitch = true;
				}
			}
			else
			{
				fibWasFalse = true;
			}
		}
		else
		{
			Robot.fibinacciSubsystem.extendFibinacci();
			running = true;
		}

		SmartDashboard.putBoolean("Fibinacci Value", fibWasFalse);
//		SmartDashboard.putString("ADOIA", "AOIHDA");
//		
//		if (Robot.fibinacciSubsystem.readSwitch()) {
//			Robot.fibinacciSubsystem.extendFibinacci();
//		}
	}

	/**
	 * Returns the off switch as false when the code is finished.
	 */
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		/*
		 * boolean ret; if((!running)&&(!Robot.oi.getButtonNine().get())) { ret
		 * = true; Robot.messenger.sendMessage("finish: true"); }else{ ret =
		 * false; } return ret;
		 */

		return offSwitch;

	}

	/**
	 * Has the fibWasFalse and offSwitch set to false when the command is ended.
	 */
	@Override
	protected void end() {
		// TODO Auto-generated method stub
		///////////////Robot.fibinacciSubsystem.stopFibinacci();
		fibWasFalse = false;
		offSwitch = false;
	}

	/**
	 * 
	 */
	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}

	/**
	 * Writes a log so that we know what is wrong with the command.
	 * @param message
	 */
	private void writeLog(String message) {

		Scanner sc = null;

		try {
			sc = new Scanner(log);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String old = "";
		while (sc.hasNextLine()) {
			old += sc.nextLine() + "\n";
		}

		PrintWriter pw = null;
		try {
			//pw = new PrintWriter(log.getOutputStream());
			pw.write(old + "\n" + Robot.getElapsedTime() + " | " + message);
		} catch (Exception e) {
			e.printStackTrace();
		}

		pw.flush();
		pw.close();
	}

	/**
	 * Writes a message on the file.
	 * @param message
	 */
	public void writeLog2(String message) {
		FileWriter fw = null;

		try {
			fw = new FileWriter("/log.txt", true);

			fw.write(Robot.getElapsedTime() + " | " + message + "\n");
			fw.flush();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * It will look at all the buttons and say whether
	 * the button is true are false and return it in a string.
	 * @return
	 */
	public String getButtons() {
		OI oi = Robot.oi;
		String s = "";

		for (Field f : oi.getClass().getDeclaredFields()) {
			if (f.getType().equals(Button.class)) {
				f.setAccessible(true);
				try {
					s += f.getName() + ": "
							+ ((JoystickButton) f.get(oi)).get() + " ";
				} catch (IllegalArgumentException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return s;
	}
}