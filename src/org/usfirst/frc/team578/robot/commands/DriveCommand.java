package org.usfirst.frc.team578.robot.commands;
import org.usfirst.frc.team578.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveCommand extends Command {
	
	/**
	 * Drives the robot based on inputs from the joysticks
	 */
    public DriveCommand() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveSubsystem);
    }

    // Called just before this Command runs the first time
	@Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
	@Override
    protected void execute() {
    	Robot.driveSubsystem.driveTankJoysticks(Robot.oi.getLeftStickX(), Robot.oi.getLeftStickY(), Robot.oi.getRightStickX(), Robot.oi.getRightStickY());
		//Robot.pidDrive.drive(Robot.oi.getLeftStickY());
    }

    /**
     * Never finished
     */
    // Make this return true when this Command no longer needs to run execute()
	@Override
    protected boolean isFinished() {
        return false;
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