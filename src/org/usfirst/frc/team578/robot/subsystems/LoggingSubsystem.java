package org.usfirst.frc.team578.robot.subsystems;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.logging.Level;

import edu.wpi.first.wpilibj.command.Subsystem;

public class LoggingSubsystem extends Subsystem {
	
	public LoggingSubsystem(){

		File logFile = new File("/578-logs/" + getTimestamp() + ".log");
		
		PrintStream p;
		try {
			p = new PrintStream(logFile);
			System.setOut(p);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void initDefaultCommand() {
		
	}

	public void write(Level logLevel, String message) {
		String timeStamp = getTimestamp();

		System.out.println("[" + logLevel.getName() + "] "+ "[" + timeStamp + "]: " + message);
	}

	private String getTimestamp() {
		Calendar c = Calendar.getInstance();

		c.setTimeZone(TimeZone.getTimeZone("US/Eastern"));

		int h = c.get(Calendar.HOUR);
		int m = c.get(Calendar.MINUTE);
		int s = c.get(Calendar.SECOND);
		int p = c.get(Calendar.AM_PM);

		String timeStamp = h + ":" + (m < 10 ? "0" + m : m) + ":"
				+ (s < 10 ? "0" + s : s) + " " + (p == 1 ? "PM" : "AM");
		return timeStamp;
	}
}
