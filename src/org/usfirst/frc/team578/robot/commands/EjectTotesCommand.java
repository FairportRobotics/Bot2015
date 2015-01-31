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

public class EjectTotesCommand extends Command {

	private boolean running;
	private boolean offSwitch;
	private static File log = new File("/log.txt");

	public EjectTotesCommand() {
		requires(Robot.fibinacciSubsystem);
		// SmartDashboard.putString("Eject", "true!");
		writeLog2("START");
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		running = false;
		offSwitch = false;
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub

		if (!running)
		{
			OI o = Robot.oi;
			boolean start = o.getButtonNine() && (o.getButtonEight() || o.getButtonSix()) && (o.getLeftTrigger() || o.getRightTrigger());
			
			if (start)
			{
				running = true;
				Robot.fibinacciSubsystem.extendFibinacci();
			}
		}
		
		
		// writeLog2("readSwitch: " + Robot.fibinacciSubsystem.readSwitch() +
		// " offSwitch: " + offSwitch + " running: " + running);
		/*
		 * writeLog2(getButtons());
		 * 
		 * if(running) { if(offSwitch&&Robot.fibinacciSubsystem.readSwitch()) {
		 * Robot.fibinacciSubsystem.stopFibinacci(); offSwitch=false;
		 * running=false; }else{
		 * offSwitch=Robot.fibinacciSubsystem.readSwitch(); }
		 * 
		 * }else{ Robot.oi.getButtonSix().get();
		 * Robot.oi.getButtonEight().get(); Robot.oi.getButtonNine().get();
		 * Robot.oi.getRightTrigger().get(); Robot.oi.getLeftTrigger().get();
		 * 
		 * Robot.messenger.sendMessage(" 6: " + Robot.oi.getButtonSix().get() +
		 * " 8: " + Robot.oi.getButtonEight().get() + " 9: " +
		 * Robot.oi.getButtonNine().get() + " LTrigg: " +
		 * Robot.oi.getLeftTrigger().get() + " RightTrigg: " +
		 * Robot.oi.getRightTrigger().get());
		 * 
		 * if((Robot.oi.getButtonSix().get()||Robot.oi.getButtonEight().get())&&(
		 * Robot
		 * .oi.getRightTrigger().get()||Robot.oi.getLeftTrigger().get())&&Robot
		 * .oi.getButtonNine().get()) {
		 * Robot.fibinacciSubsystem.extendFibinacci(); offSwitch = false;
		 * running = true; Robot.messenger.sendMessage("Extend"); }
		 * 
		 * }
		 */

//		SmartDashboard.putString("ADOIA", "AOIHDA");
//		
//		if (Robot.fibinacciSubsystem.readSwitch()) {
//			Robot.fibinacciSubsystem.extendFibinacci();
//		}
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		/*
		 * boolean ret; if((!running)&&(!Robot.oi.getButtonNine().get())) { ret
		 * = true; Robot.messenger.sendMessage("finish: true"); }else{ ret =
		 * false; } return ret;
		 */

		return !Robot.fibinacciSubsystem.readSwitch();
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		Robot.fibinacciSubsystem.stopFibinacci();
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}

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
			// pw = new PrintWriter(log.getOutputStream());
			pw.write(old + "\n" + Robot.getElapsedTime() + " | " + message);
		} catch (Exception e) {
			e.printStackTrace();
		}

		pw.flush();
		pw.close();
	}

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
