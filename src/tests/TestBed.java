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

import subsystem.Subsystem;
import utils.time.JavaTimer;

public class TestBed {

	public static void main(String[] args) throws FileNotFoundException {
		PrintStream out = new PrintStream(new FileOutputStream("RobotSimulationLog.txt"));
		System.setOut(out);
		DriveAutoQueue autoStack = new DriveAutoQueue();
		autoStack.addAutoLayer(new DriveAutoNothing(new JavaTimer()));
		autoStack.addAutoLayer(new DriveCrossingRoughTerrain(new JavaTimer()));
		Subsystem<DriveHardwareLayer, DriveSystemLayer, DriveCommandLayer> drive;
		drive= new Subsystem<DriveHardwareLayer,DriveSystemLayer,DriveCommandLayer>(
				new DriveHardwareSimulation(),
				new DriveSystem(),
				autoStack);
		drive.robotInit();
		JavaTimer timer = new JavaTimer();
		timer.start();
		double timerLast = timer.get();
		while(timer.get()<15){
			if((timer.get()-timerLast) > 0.1){
				System.out.println("Current Time:"+timer.get());
				drive.runPeriodic();	
				timerLast=timer.get();
			}
		}
	}
	
}
