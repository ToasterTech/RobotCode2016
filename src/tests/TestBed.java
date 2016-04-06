package tests;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import org.usfirst.frc.team5332.robot.drive.DriveHardwareSimulation;
import org.usfirst.frc.team5332.robot.drive.DriveSystem;
import org.usfirst.frc.team5332.robot.drive.DriveTeleop;
import org.usfirst.frc.team5332.robot.drive.auto.DriveAutoNothing;
import org.usfirst.frc.team5332.robot.drive.auto.crossing.DriveCrossingCheval;
import org.usfirst.frc.team5332.robot.drive.auto.crossing.DriveCrossingRoughTerrain;
import org.usfirst.frc.team5332.robot.drive.auto.queue.DriveAutoQueue;
import org.usfirst.frc.team5332.robot.drive.base.DriveCommandLayer;
import org.usfirst.frc.team5332.robot.drive.base.DriveHardwareLayer;
import org.usfirst.frc.team5332.robot.drive.base.DriveSystemLayer;
import org.usfirst.frc.team5332.robot.intake.IntakeHardwareSimulation;
import org.usfirst.frc.team5332.robot.intake.IntakeSystem;
import org.usfirst.frc.team5332.robot.intake.auto.IntakeAutoDown;
import org.usfirst.frc.team5332.robot.intake.auto.IntakeAutoNothing;
import org.usfirst.frc.team5332.robot.intake.auto.queue.IntakeAutoQueue;
import org.usfirst.frc.team5332.robot.intake.base.IntakeCommandLayer;
import org.usfirst.frc.team5332.robot.intake.base.IntakeHardwareLayer;
import org.usfirst.frc.team5332.robot.intake.base.IntakeSystemLayer;

import subsystem.Subsystem;
import utils.time.JavaTimer;

public class TestBed {

	public static void main(String[] args) throws FileNotFoundException {
		PrintStream out = new PrintStream(new FileOutputStream("RobotSimulationLog.txt"));
		System.setOut(out);
		IntakeAutoQueue autoStack = new IntakeAutoQueue();
		autoStack.addAutoLayer(new IntakeAutoNothing(new JavaTimer()));
		autoStack.addAutoLayer(new IntakeAutoDown());
		Subsystem<IntakeHardwareLayer, IntakeSystemLayer, IntakeCommandLayer> intake;
		intake= new Subsystem<IntakeHardwareLayer,IntakeSystemLayer,IntakeCommandLayer>(
				new IntakeHardwareSimulation(),
				new IntakeSystem(),
				autoStack);
		intake.robotInit();
		JavaTimer timer = new JavaTimer();
		timer.start();
		double timerLast = timer.get();
		while(timer.get()<15){
			if((timer.get()-timerLast) > 0.1){
				System.out.println("Current Time:"+timer.get());
				intake.runPeriodic();	
				timerLast=timer.get();
			}
		}
	}
	
}
