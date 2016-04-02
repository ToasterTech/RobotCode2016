package org.usfirst.frc.team5332.robot.drive.auto;

import org.usfirst.frc.team5332.robot.drive.base.DriveCommandLayer;

import utils.time.ToasterTimer;
import utils.time.WPITimer;

public class DriveAutoNothing extends DriveCommandLayer{
	
	private ToasterTimer timer;
	private boolean timerStarted;
	protected double nothingTime;
	protected boolean finished;
	
	public DriveAutoNothing(){
		timer = new WPITimer(); // What time is it? I forgot my watch
	}
	
	public DriveAutoNothing(ToasterTimer timerArg){
		timer = timerArg;
	}
	
	@Override
	public void robotInit() {
		timerStarted = false; // Batteries not included
		nothingTime = 2.0; // Power nap
		finished = false; // I'm not done yet
	}

	@Override
	public String getName() {
		return "DriveNothing"; // meh nahme ihs jehff
	}

	@Override
	public void runPeriodic() {
		if(!timerStarted){ // Honey, where's my super suit?
			timer.start(); // Get this party started
			timerStarted = true; // I told you I found the batteries
		}
		
		if(timer.get()<nothingTime){ // Bam Bam doesn't sleep. He waits
			systemLayer.setDriveHardwareLeft(0); // No sudden movements
			systemLayer.setDriveHardwareRight(0);
		}else{
			finished = true;
		}
	}

	@Override
	public boolean isFinished() {
		// TODO Auto-generated method stub
		return finished;
	}
	
}
