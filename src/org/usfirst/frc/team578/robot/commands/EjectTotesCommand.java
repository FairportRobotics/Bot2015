package org.usfirst.frc.team578.robot.commands;

import org.usfirst.frc.team578.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class EjectTotesCommand extends Command {
	
	private boolean running;
	private boolean offSwitch;

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		requires(Robot.fibinacciSubsystem);
		running = false;
		offSwitch = false;
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		
		if(running)
		{
			if(offSwitch&&Robot.fibinacciSubsystem.readSwitch())
			{
				Robot.fibinacciSubsystem.stopFibinacci();
				offSwitch=false;
				running=false;
			}else{
				offSwitch=!Robot.fibinacciSubsystem.readSwitch();
			}
			
		}else{
			Robot.oi.getButtonSix().get();
			Robot.oi.getButtonEight().get();
			Robot.oi.getButtonNine().get();
			Robot.oi.getRightTrigger().get();
			Robot.oi.getLeftTrigger().get();
			
			if((Robot.oi.getButtonSix().get()||Robot.oi.getButtonEight().get())&&(Robot.oi.getRightTrigger().get()||Robot.oi.getLeftTrigger().get())&&Robot.oi.getButtonNine().get())
			{
				Robot.fibinacciSubsystem.extendFibinacci();
				offSwitch = false;
				running = true;
			}
		}
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		boolean ret;
		if((!running)&&(!Robot.oi.getButtonNine().get()))
		{
			ret = true;
		}else{
			ret = false;
		}
		return ret;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}

}
