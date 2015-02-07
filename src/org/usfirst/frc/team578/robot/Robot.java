package org.usfirst.frc.team578.robot;

import org.usfirst.frc.team578.robot.commands.autonomous.AutonomousCanGroup;
import org.usfirst.frc.team578.robot.commands.autonomous.AutonomousDriveStraightGroup;
import org.usfirst.frc.team578.robot.commands.autonomous.AutonomousStackGroup;
import org.usfirst.frc.team578.robot.commands.autonomous.AutonomousToteGroup;
import org.usfirst.frc.team578.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team578.robot.subsystems.ElevatorSubsystem;
import org.usfirst.frc.team578.robot.subsystems.FibinacciSubsystem;
import org.usfirst.frc.team578.robot.subsystems.IntakeSubsystem;
import org.usfirst.frc.team578.robot.subsystems.PIDDrive;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final DriveSubsystem driveSubsystem = new DriveSubsystem();
	public static final PIDDrive pidDrive = new PIDDrive();
	public static final ElevatorSubsystem elevatorSubsystem = new ElevatorSubsystem();
	public static final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
	public static final FibinacciSubsystem fibinacciSubsystem = new FibinacciSubsystem();
	public static OI oi;
	private static long startTime;
	
    Command autonomousCommand;
    SendableChooser autonomousChooser;

   
    public static long getElapsedTime()
    {
    	return (System.currentTimeMillis() - startTime) / 1000;
    }
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
		initializeAutonomousChooser();
        
        startTime = System.currentTimeMillis();
        
        CameraServer server = CameraServer.getInstance();
        server.setQuality(50);
        server.startAutomaticCapture("cam0");
    }

	private void initializeAutonomousChooser() {
		autonomousChooser = new SendableChooser();
        autonomousChooser.addDefault("Drive Straight", new AutonomousDriveStraightGroup());
        autonomousChooser.addObject("Triple Stack", new AutonomousStackGroup());
        autonomousChooser.addObject("Single Tote", new AutonomousToteGroup());
        autonomousChooser.addObject("Single Can", new AutonomousCanGroup());
        SmartDashboard.putData("Autonomous Strategy", autonomousChooser);
	}
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
    	autonomousCommand = (Command) autonomousChooser.getSelected();
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
