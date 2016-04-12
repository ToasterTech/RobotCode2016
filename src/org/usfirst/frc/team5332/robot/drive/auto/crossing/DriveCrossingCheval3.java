package org.usfirst.frc.team5332.robot.drive.auto.crossing;

import org.usfirst.frc.team5332.robot.drive.base.DriveCommandLayer;

import utils.time.ToasterTimer;

public class DriveCrossingCheval3 extends DriveAutoCrossing{
	/*
	 * Set the drive time
	 * Set the drive speed
	 * Rinse
	 * Repeat
	 * 
	 * 
	 * 
	 * Also 3 and 0.75 are not the correct values so we should look into what the actual values are.
	 */
	
	public DriveCrossingCheval3(){
		driveTime = 5;
		driveSpeed=0.9;
	}

	public DriveCrossingCheval3(ToasterTimer timer) {
		super(timer);
		driveTime = 5;
		driveSpeed=0.9;
	}
}
