package org.usfirst.frc.team5332.robot.drive.auto.crossing;

import org.usfirst.frc.team5332.robot.drive.base.DriveCommandLayer;

import utils.time.ToasterTimer;

public class DriveCrossingLowBar extends DriveAutoCrossing{
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
	
	public DriveCrossingLowBar(){
		driveTime = 3.5;
		driveSpeed = 0.6;
	}

	public DriveCrossingLowBar(ToasterTimer timer) {
		super(timer);
		driveTime = 3.5;
		driveSpeed = 0.6;
	}
}
