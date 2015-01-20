
package org.usfirst.frc.team578.robot.subsystems;


import org.usfirst.frc.team578.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	CANTalon frontLeftTalon = new CANTalon(RobotMap.FRONT_LEFT_TALON);
	CANTalon frontRightTalon = new CANTalon(RobotMap.FRONT_RIGHT_TALON);
	CANTalon backLeftTalon = new CANTalon(RobotMap.BACK_LEFT_TALON);
	CANTalon backRightTalon = new CANTalon(RobotMap.BACK_RIGHT_TALON);
	RobotDrive robotDrive; 
	
	public DriveSubsystem(){
		robotDrive = new RobotDrive(frontLeftTalon, backLeftTalon, frontRightTalon, backRightTalon);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void drive(double leftX, double leftY, double rightX, double rightY){
    	if(leftX < 0.3 && leftX > -0.3){
    		frontLeftTalon.set(-leftY);
    		backLeftTalon.set(-leftY);
    	}else{
    		frontLeftTalon.set(leftX);
    		backLeftTalon.set(-leftX);
    	}
    	
    	if(rightX < 0.3 && rightX > -0.3){
    		frontRightTalon.set(rightY);
    		backRightTalon.set(rightY);
    	}else{
    		frontRightTalon.set(rightX);
    		backRightTalon.set(-rightX);
    	}
    }
}

