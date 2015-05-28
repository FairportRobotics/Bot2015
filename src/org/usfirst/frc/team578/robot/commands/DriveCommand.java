package org.usfirst.frc.team578.robot.commands;
import org.usfirst.frc.team578.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveCommand extends Command {
	
	/**
	 * Drives the robot based on inputs from the joysticks
	 */
    public DriveCommand() {
        requires(Robot.driveSubsystem);
    }

	@Override
    protected void initialize() {
		
    }

	@Override
    protected void execute() {
    	Robot.driveSubsystem.driveTankJoysticks(Robot.oi.getLeftStickX(), Robot.oi.getLeftStickY(), Robot.oi.getRightStickX(), Robot.oi.getRightStickY());
		//Robot.pidDrive.drive(Robot.oi.getLeftStickY());
    }

	@Override
    protected boolean isFinished() {
        return false; //never finished
    }

    // Called once after isFinished returns true
	@Override
    protected void end() {
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
	@Override
    protected void interrupted() {
    	
    }
}