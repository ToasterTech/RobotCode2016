package org.usfirst.frc.team5332.robot.drive.auto.crossing;

import org.usfirst.frc.team5332.robot.drive.base.DriveCommandLayer;

import utils.time.ToasterTimer;

public class DriveCrossingPortcullis2 extends DriveAutoCrossing{
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
	
	public DriveCrossingPortcullis2(){
		driveTime = 3;
		driveSpeed = 0.9;
	}

	public DriveCrossingPortcullis2(ToasterTimer timer) {
		super(timer);
		driveTime = 3;
		driveSpeed = 0.9;
	}
}
