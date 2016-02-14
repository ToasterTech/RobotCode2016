package org.usfirst.frc.team5332.robot;

import org.usfirst.frc.team5332.robot.drive.DriveHardwareRoboRio;
import org.usfirst.frc.team5332.robot.drive.DriveSystem;
import org.usfirst.frc.team5332.robot.drive.DriveTeleop;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import subsystem.Subsystem;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.Joystick;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	Subsystem drive;

    public void robotInit() {
    	drive=new Subsystem(new DriveHardwareRoboRio(),new DriveSystem(),new DriveTeleop());
    }
    
    public void autonomousInit() {
    }

    public void autonomousPeriodic() {
    }

    public void teleopPeriodic() {
    	drive.runPeriodic();
    }
    
    public void testPeriodic() {
    
    }
    
}
