package org.usfirst.frc.team5332.robot;

import org.usfirst.frc.team5332.robot.drive.DriveHardwareRoboRio;
import org.usfirst.frc.team5332.robot.drive.DriveSystem;
import org.usfirst.frc.team5332.robot.drive.DriveTeleop;
import org.usfirst.frc.team5332.robot.drive.auto.DriveAutoConfigurable;
import org.usfirst.frc.team5332.robot.drive.auto.DriveAutoNothing;
import org.usfirst.frc.team5332.robot.drive.auto.DriveAutoSimple;
import org.usfirst.frc.team5332.robot.drive.base.DriveCommandLayer;
import org.usfirst.frc.team5332.robot.drive.base.DriveHardwareLayer;
import org.usfirst.frc.team5332.robot.drive.base.DriveSystemLayer;
import org.usfirst.frc.team5332.robot.intake.IntakeHardwareRoboRio;
import org.usfirst.frc.team5332.robot.intake.IntakeSystem;
import org.usfirst.frc.team5332.robot.intake.IntakeTeleop;
import org.usfirst.frc.team5332.robot.intake.auto.IntakeAutoConfigurable;
import org.usfirst.frc.team5332.robot.intake.auto.IntakeAutoNothing;
import org.usfirst.frc.team5332.robot.intake.auto.IntakeAutoSimple;
import org.usfirst.frc.team5332.robot.intake.base.IntakeCommandLayer;
import org.usfirst.frc.team5332.robot.intake.base.IntakeHardwareLayer;
import org.usfirst.frc.team5332.robot.intake.base.IntakeSystemLayer;

import autoselect.AutoSelector;
import dashboard.LabviewDashboard;
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
    Timer timer;

    public void robotInit() {
    	LabviewDashboard.getDashboard().init();
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
//        chooser.addDefault("Drive Forward Auto", 0);
//		  chooser.addObject("No Auto", -1);
//        chooser.addObject("Cheval de Frise Auto", 1);
//        chooser.addObject("Low Bar Auto", 2);
//        chooser.addObject("Rough Terrain Auto", 3);
//        SmartDashboard.putData("Auto choices", chooser);
    }
    
    public void autonomousInit() {
    	/*
    	 * AutoSelector selector=new AutoSelector();
    	 * NetworkInteface networkTable=new NetworkInterface();
    	 * DriveCommandLayer auto=selector.select(networkTable.getAuto());
    	 * drive.setCommandLayer(auto);
    	 */

    	boolean runAuto = LabviewDashboard.getDashboard().getBoolean("AARun");
    	String autoMode= LabviewDashboard.getDashboard().getString("AutoMode");
    	AutoSelector selector=new AutoSelector();
    	System.out.println(runAuto);
    	System.out.println(autoMode);

    	if(runAuto){
	        drive.setCommandLayer(selector.getDriveAuto(autoMode));
	       	intake.setCommandLayer(selector.getIntakeAuto(autoMode));
    	}else{
	        drive.setCommandLayer(new DriveAutoNothing());
	       	intake.setCommandLayer(new IntakeAutoNothing(15));

    	}
    }

    public void autonomousPeriodic() {
    	drive.runPeriodic();
    	intake.runPeriodic();
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
    	LabviewDashboard.getDashboard().addData("TestConstant",1);
    	LabviewDashboard.getDashboard().run();
    }
    
    public void testPeriodic() {
    
    }
    
}
