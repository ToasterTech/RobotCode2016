package org.usfirst.frc.team5332.robot;

import org.usfirst.frc.team5332.robot.drive.DriveHardwareRoboRio;
import org.usfirst.frc.team5332.robot.drive.DriveSystem;
import org.usfirst.frc.team5332.robot.drive.DriveTeleop;
import org.usfirst.frc.team5332.robot.drive.auto.DriveAutoSimple;
import org.usfirst.frc.team5332.robot.drive.base.DriveCommandLayer;
import org.usfirst.frc.team5332.robot.drive.base.DriveHardwareLayer;
import org.usfirst.frc.team5332.robot.drive.base.DriveSystemLayer;
import org.usfirst.frc.team5332.robot.intake.IntakeHardwareRoboRio;
import org.usfirst.frc.team5332.robot.intake.IntakeSystem;
import org.usfirst.frc.team5332.robot.intake.IntakeTeleop;
import org.usfirst.frc.team5332.robot.intake.base.IntakeCommandLayer;
import org.usfirst.frc.team5332.robot.intake.base.IntakeHardwareLayer;
import org.usfirst.frc.team5332.robot.intake.base.IntakeSystemLayer;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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
	Subsystem<DriveHardwareLayer,DriveSystemLayer,DriveCommandLayer> drive;
	Subsystem<IntakeHardwareLayer,IntakeSystemLayer,IntakeCommandLayer> intake;
	Compressor compressor;
    String autoSelected;
    SendableChooser chooser;

    public void robotInit() {
    	drive=new Subsystem<DriveHardwareLayer,DriveSystemLayer,DriveCommandLayer>(new DriveHardwareRoboRio(),new DriveSystem(),new DriveTeleop());
    	drive.robotInit();
    	compressor=new Compressor();
    	compressor.start();
    	intake=new Subsystem<IntakeHardwareLayer,IntakeSystemLayer,IntakeCommandLayer>(new IntakeHardwareRoboRio(),new IntakeSystem(),new IntakeTeleop());
    	intake.robotInit();
    	
    	CameraServer server = CameraServer.getInstance();
    	server.setQuality(50);
    	server.startAutomaticCapture("cam0");

//    	chooser = new SendableChooser();
////        chooser.addDefault("Default Auto", defaultAuto);
////        chooser.addObject("My Auto", customAuto);
//        SmartDashboard.putData("Auto choices", chooser);
    }
    
    public void autonomousInit() {
    	/*
    	 * AutoSelector selector=new AutoSelector();
    	 * NetworkInteface networkTable=new NetworkInterface();
    	 * DriveCommandLayer auto=selector.select(networkTable.getAuto());
    	 * drive.setCommandLayer(auto);
    	 */
    	drive.setCommandLayer(new DriveAutoSimple());
    }

    public void autonomousPeriodic() {
    	drive.runPeriodic();
    }
    public void teleopInit(){
    	/*
    	 * Set the command layers for teleop.     	
    	 */
    	drive.setCommandLayer(new DriveTeleop());
    	intake.setCommandLayer(new IntakeTeleop());
    }

    public void teleopPeriodic() {
    	drive.runPeriodic();
    	intake.runPeriodic();
    }
    
    public void testPeriodic() {
    
    }
    
}
