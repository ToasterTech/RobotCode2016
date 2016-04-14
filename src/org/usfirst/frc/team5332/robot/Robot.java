package org.usfirst.frc.team5332.robot;

import org.usfirst.frc.team5332.robot.drive.DriveHardwareRoboRio;
import org.usfirst.frc.team5332.robot.drive.DriveSystem;
import org.usfirst.frc.team5332.robot.drive.DriveTeleop;
import org.usfirst.frc.team5332.robot.drive.auto.DriveAutoConfigurable;
import org.usfirst.frc.team5332.robot.drive.auto.DriveAutoNothing;
import org.usfirst.frc.team5332.robot.drive.auto.DriveAutoSimple;
import org.usfirst.frc.team5332.robot.drive.auto.complete.DriveCompleteCrossCheval;
import org.usfirst.frc.team5332.robot.drive.auto.complete.DriveCompleteCrossLowBar;
import org.usfirst.frc.team5332.robot.drive.auto.complete.DriveCompleteCrossMoat;
import org.usfirst.frc.team5332.robot.drive.auto.complete.DriveCompleteCrossPortcullis;
import org.usfirst.frc.team5332.robot.drive.auto.complete.DriveCompleteCrossRamparts;
import org.usfirst.frc.team5332.robot.drive.auto.complete.DriveCompleteCrossRock;
import org.usfirst.frc.team5332.robot.drive.auto.complete.DriveCompleteCrossRoughTerrain;
import org.usfirst.frc.team5332.robot.drive.base.DriveCommandLayer;
import org.usfirst.frc.team5332.robot.drive.base.DriveHardwareLayer;
import org.usfirst.frc.team5332.robot.drive.base.DriveSystemLayer;
import org.usfirst.frc.team5332.robot.intake.IntakeHardwareRoboRio;
import org.usfirst.frc.team5332.robot.intake.IntakeSystem;
import org.usfirst.frc.team5332.robot.intake.IntakeTeleop;
import org.usfirst.frc.team5332.robot.intake.auto.IntakeAutoConfigurable;
import org.usfirst.frc.team5332.robot.intake.auto.IntakeAutoNothing;
import org.usfirst.frc.team5332.robot.intake.auto.IntakeAutoSimple;
import org.usfirst.frc.team5332.robot.intake.auto.complete.IntakeCompleteCrossCheval;
import org.usfirst.frc.team5332.robot.intake.auto.complete.IntakeCompleteCrossLowBar;
import org.usfirst.frc.team5332.robot.intake.auto.complete.IntakeCompleteCrossMoat;
import org.usfirst.frc.team5332.robot.intake.auto.complete.IntakeCompleteCrossPortcullis;
import org.usfirst.frc.team5332.robot.intake.auto.complete.IntakeCompleteCrossRamparts;
import org.usfirst.frc.team5332.robot.intake.auto.complete.IntakeCompleteCrossRock;
import org.usfirst.frc.team5332.robot.intake.auto.complete.IntakeCompleteCrossRoughTerrain;
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
    	System.out.println("Initing Robot");
    	
    	// Test datatable initialization
    	LabviewDashboard.getDashboard().init();
    	LabviewDashboard.getDashboard().addData("Status",1000);
    	LabviewDashboard.getDashboard().run();

    	drive=new Subsystem<DriveHardwareLayer,DriveSystemLayer,DriveCommandLayer>(new DriveHardwareRoboRio(),new DriveSystem(),new DriveTeleop());
    	drive.robotInit();
    	compressor=new Compressor();
    	compressor.start();
    	intake=new Subsystem<IntakeHardwareLayer,IntakeSystemLayer,IntakeCommandLayer>(new IntakeHardwareRoboRio(),new IntakeSystem(),new IntakeTeleop());
    	intake.robotInit();
    	try{
	    	CameraServer server = CameraServer.getInstance();
	    	server.setQuality(50);
	    	server.startAutomaticCapture("cam0");
    	}catch(Exception e){
    		System.out.println(e);
    	}
//    	chooser = new SendableChooser();
//        chooser.addDefault("Drive Forward Auto", 0);
//		  chooser.addObject("No Auto", -1);
//        chooser.addObject("Cheval de Frise Auto", 1);
//        chooser.addObject("Low Bar Auto", 2);
//        chooser.addObject("Rough Terrain Auto", 3);
//        SmartDashboard.putData("Auto choices", chooser);
    }
    
    public void autonomousInit() {
    	System.out.println("Running Autonomous");
    	LabviewDashboard.getDashboard().run();

    	/*
    	 * AutoSelector selector=new AutoSelector();
    	 * NetworkInteface networkTable=new NetworkInterface();
    	 * DriveCommandLayer auto=selector.select(networkTable.getAuto());
    	 * drive.setCommandLayer(auto);
    	 */
    	boolean runAuto = LabviewDashboard.getDashboard().getBoolean("RunAuto");
    	String autoMode= LabviewDashboard.getDashboard().getString("AutoMode");
    	AutoSelector selector=new AutoSelector();
    	System.out.println("runAuto: " + runAuto);
    	System.out.println("autoMode: " + autoMode);
    	
/*
 * CASEY LOOK HERE <==========================    	
 */
    	/*
    	 * LowBar
    	 * RoughTerrain
    	 * Rock
    	 * Portcullis
    	 * Ramparts
    	 * Cheval
    	 * Moat
    	 */
	    	LabviewDashboard.getDashboard().addData("Status",4000);
	    	if(runAuto){
		        drive.setCommandLayer(selector.getDriveAuto(autoMode));
		       	intake.setCommandLayer(selector.getIntakeAuto(autoMode));
		       	System.out.println(selector.getDriveAuto(autoMode));
		    	LabviewDashboard.getDashboard().run();
	
	    	}else{
		        drive.setCommandLayer(new DriveAutoNothing());
		       	intake.setCommandLayer(new IntakeAutoNothing());
	    	}
	    	
    }

    public void autonomousPeriodic() {
    	drive.runPeriodic();
    	intake.runPeriodic();
    	LabviewDashboard.getDashboard().run();

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
