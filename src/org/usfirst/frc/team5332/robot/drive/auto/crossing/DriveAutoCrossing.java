package org.usfirst.frc.team5332.robot.drive.auto.crossing;

import org.usfirst.frc.team5332.robot.drive.base.DriveCommandLayer;

import utils.time.ToasterTimer;
import utils.time.WPITimer;

public abstract class DriveAutoCrossing extends DriveCommandLayer{
	
	protected boolean finished;
	protected double driveTime;
	protected double driveSpeed;
	private ToasterTimer timer;
	private boolean timerStarted;
	
	public DriveAutoCrossing(){
		timer = new WPITimer();
	}
	
	public DriveAutoCrossing(ToasterTimer timerArg){
		timer = timerArg;
		
	}
	
	@Override
	public void robotInit() {
		finished = false;
		timerStarted = false;
	}

	@Override
	public String getName() {
		
		return "DriveCrossing";
	}

	@Override
	public void runPeriodic() {
		if(!timerStarted){
			timer.start();
			timerStarted = true;
		}
		if(timer.get()<driveTime){
			systemLayer.setDriveHardwareLeft(driveSpeed);
			systemLayer.setDriveHardwareRight(driveSpeed);
		}else{
			systemLayer.setDriveHardwareLeft(0);
			systemLayer.setDriveHardwareRight(0);
			finished = true;
		}
	}

	@Override
	public boolean isFinished() {
		return finished;
	}

}
