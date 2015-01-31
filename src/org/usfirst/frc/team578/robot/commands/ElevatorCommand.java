package org.usfirst.frc.team578.robot.commands;
import org.usfirst.frc.team578.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ElevatorCommand extends Command {
	
	private int desiredPosition;

	/**
	 * 
	 * @param desiredPosition
	 */
	public ElevatorCommand(int desiredPosition) {
		// TODO Auto-generated constructor stub
		requires(Robot.elevatorSubsystem);
		this.desiredPosition = desiredPosition;
	}
	
	/**
	 * 
	 */
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		SmartDashboard.putNumber("Elevator Value", 0);
	}

	/**
	 * 
	 */
	@Override
	protected void execute() {
		// TODO Auto-generated method stud
		Robot.elevatorSubsystem.setLevel(desiredPosition);
	}

	/**
	 * 
	 */
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return Robot.elevatorSubsystem.getCurrentLevel() == desiredPosition;
		//TODO: GET RID OF DIS
	}

	/**
	 * 
	 */
	@Override
	protected void end() {
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 */
	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}
}