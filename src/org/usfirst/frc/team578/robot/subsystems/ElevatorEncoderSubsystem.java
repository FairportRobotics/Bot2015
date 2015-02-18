package org.usfirst.frc.team578.robot.subsystems;

import java.util.logging.Level;

import org.usfirst.frc.team578.robot.Robot;
import org.usfirst.frc.team578.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.ControlMode;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ElevatorEncoderSubsystem extends SubsystemBase {

	//Reverse limit switch is the top
	//Forward limit switch is the bottom

	//Should be normally closed?

	private static final double LEVEL_ONE_MIN = 50;
	private static final double LEVEL_ONE_MAX = 60;
	private static final double LEVEL_TWO_MIN = 110;
	private static final double LEVEL_TWO_MAX = 120;
	private static final double LEVEL_THREE_MIN = 185;
	private static final double LEVEL_THREE_MAX = 195;
	private static final double LEVEL_FOUR_MIN = 450;
	private static final double LEVEL_FOUR_MAX = 460;

	private CANTalon elevatorTalon;

	private int currLevel = 1;
	private int desiredLevel = 1;

	private long talonStallTime;

	private static final long TALON_STALL_TIMEOUT = 5000; //milliseconds

	private boolean timedOut = false;
	private boolean timing = false;

	/**
	 * Constructs the subsystem, including 2 digital inputs for switches,
	 * and the Talon for the elevator. 
	 */
	public ElevatorEncoderSubsystem(boolean enable) 
	{
		super(enable);

		if (!enabled)
			return;

		elevatorTalon = initializeTalon(RobotMap.ELEVATOR_TALON);
	}

	/**
	 * Writes the position of the elevator to the SmartDashboard
	 */
	public void writeStatus()
	{
		if (!enabled)
			return;

		//		SmartDashboard.putBoolean("Fwd Closed", elevatorTalon.isFwdLimitSwitchClosed());
		//		SmartDashboard.putBoolean("Rev Closed", elevatorTalon.isRevLimitSwitchClosed());
		//		SmartDashboard.putNumber("curr level", currLevel);

		//SmartDashboard.putString("Limit", "Three:" + levelThree.get() + " Two:" + levelTwo.get());

		switch (currLevel)
		{
		case 1: SmartDashboard.putString("Elevator Level", "1: BOTTOM"); break;
		case 2: SmartDashboard.putString("Elevator Level", "2: LOW"); break;
		case 3: SmartDashboard.putString("Elevator Level", "3: HIGH"); break;
		case 4: SmartDashboard.putString("Elevator Level", "4: TOP"); break;
		}
	}

	@Override
	protected void initDefaultCommand() {

	}

	/**
	 * Gets the current position of the elevator (At switches)
	 * @return
	 */
	public int getCurrentLevel(){
		if (!enabled)
			return -1;

		return currLevel;
	}

	public void stop()
	{
		if (!enabled)
			return;

		elevatorTalon.changeControlMode(ControlMode.Speed);
		elevatorTalon.enableControl();
		elevatorTalon.set(0);
		elevatorTalon.changeControlMode(ControlMode.Position);
		elevatorTalon.enableControl();

		Robot.log.write(Level.WARNING, "Elevator stopped!");
	}

	/**
	 * Sets the level of the elevator to a specific position (1-4)
	 * @param level
	 */
	public void setLevel(int level) 
	{
		if (!enabled)
			return;

		//DRIVING THE TALON WITH A NEGATIVE VALUE
		//MAKES IT GO UP! POSITIVE GOES DOWN!

		desiredLevel = level;
		
		SmartDashboard.putNumber("Desired Level: ", level);
		Robot.log.write(Level.INFO, "SetLevel " + level);

		if (!timedOut)
		{
			switch(level)
			{
			case 1 : elevatorTalon.set((LEVEL_ONE_MIN + LEVEL_ONE_MAX) / 2);
			Robot.log.write(Level.INFO, "Elevator sent to: " + (LEVEL_ONE_MIN + LEVEL_ONE_MAX) / 2);
			break;
			case 2 : elevatorTalon.set((LEVEL_TWO_MIN + LEVEL_TWO_MAX) / 2);
			Robot.log.write(Level.INFO, "Elevator sent to: " + (LEVEL_TWO_MIN + LEVEL_TWO_MAX) / 2);
			break;
			case 3 : elevatorTalon.set((LEVEL_THREE_MIN + LEVEL_THREE_MAX) / 2);
			Robot.log.write(Level.INFO, "Elevator sent to: " + (LEVEL_THREE_MIN + LEVEL_THREE_MAX) / 2);
			break;
			case 4 : elevatorTalon.set((LEVEL_FOUR_MIN + LEVEL_FOUR_MAX) / 2);
			Robot.log.write(Level.INFO, "Elevator sent to: " + (LEVEL_FOUR_MIN + LEVEL_FOUR_MAX) / 2);
			break;
			}
		}

		if (isAtLevel(1))
		{
			currLevel = 1;
			Robot.log.write(Level.INFO, "Elevator detected at level #1");
		}

		if (isAtLevel(2))
		{
			currLevel = 2;
			Robot.log.write(Level.INFO, "Elevator detected at level #2");
		}

		if (isAtLevel(3))
		{
			currLevel = 3;
			Robot.log.write(Level.INFO, "Elevator detected at level #3");
		}

		if (isAtLevel(4))
		{
			currLevel = 4;
			Robot.log.write(Level.INFO, "Elevator detected at level #4");
		}
	}

	public boolean isAtLevel(int level)
	{
		if (!enabled)
			return false;

		double position = elevatorTalon.getPosition();

		boolean atLevel = false;

		switch (level)
		{
		case 1: atLevel = (position >= LEVEL_ONE_MIN && position <= LEVEL_ONE_MAX); break;
		case 2: atLevel = position >= LEVEL_TWO_MIN && position <= LEVEL_TWO_MAX; break;
		case 3: atLevel = position >= LEVEL_THREE_MIN && position <= LEVEL_THREE_MAX; break;
		case 4: atLevel = (position >= LEVEL_FOUR_MIN && position <= LEVEL_FOUR_MAX); break;
		}

		return atLevel;
	}

	public void update() {
		if (!enabled)
			return;
		
		boolean near = Math.abs(elevatorTalon.getPosition() - elevatorTalon.getSetpoint()) <= 20;
		
		if (elevatorTalon.getAnalogInVelocity() == 0 && !isAtLevel(desiredLevel) && !timing)
		{
			timing = true;
			talonStallTime = System.currentTimeMillis();
		}
		else if (elevatorTalon.getAnalogInVelocity() != 0 || isAtLevel(desiredLevel) || near)
		{
			timing = false;
		}

		if (timing && System.currentTimeMillis() - talonStallTime > TALON_STALL_TIMEOUT)
		{
			Robot.log.write(Level.SEVERE, "Elevator has stalled longer than the "
					+ "timeout! Stopping the elevator.");
			timedOut = true;
			stop();
		}
	}

	public void start() {
		if (!enabled)
			return;

		timedOut = false;
	}

	public int getDesiredLevel() {
		if (!enabled)
			return -1;
		
		return desiredLevel;
	}

	private CANTalon initializeTalon(int channel) {
		CANTalon talon = new CANTalon(channel);
		talon.reverseOutput(true);
		talon.ConfigFwdLimitSwitchNormallyOpen(false);
		talon.ConfigRevLimitSwitchNormallyOpen(false);
		talon.changeControlMode(ControlMode.Position);
		talon.setFeedbackDevice(FeedbackDevice.AnalogPot);
		talon.setPID(3, .0001, 0.85, 0, 0, 0, 0);
		//talon.setPID(1, 0.01, 0.85, 1.5, 0, 0, 0); //TUNED VALUES FOR FRONT RIGHT WHEEL
		//talon.setPID(1.23, 0, 0, 1.33, 0, 10, 0); EXACT VALUES FOR OLD TESTBOARD PID DO NOT CHANGE
		talon.enableControl();
		return talon;
	}
}
