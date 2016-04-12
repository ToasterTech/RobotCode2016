package org.usfirst.frc.team5332.robot.drive.auto.crossing;

import org.usfirst.frc.team5332.robot.drive.base.DriveCommandLayer;

import utils.time.ToasterTimer;

public class DriveCrossingRamparts extends DriveAutoCrossing{
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
	
	public DriveCrossingRamparts(){
		driveTime = 3;
		driveSpeed = -0.9;
	}

	public DriveCrossingRamparts(ToasterTimer timer) {
		super(timer);
		driveTime = 3;
		driveSpeed = -0.9;
	}
}
