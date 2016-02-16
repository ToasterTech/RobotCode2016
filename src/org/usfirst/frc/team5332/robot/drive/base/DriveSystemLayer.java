package org.usfirst.frc.team5332.robot.drive.base;

import subsystem.Layer;

public abstract class DriveSystemLayer implements Layer<DriveHardwareLayer>{

	@Override
	public abstract void runPeriodic();

	@Override
	public abstract void setChild(DriveHardwareLayer c);
	public abstract void setDriveHardwareLeft(double LArg);
	public abstract void setDriveHardwareRight(double RArg);
	public abstract void gyroCorrectedDriveStraight();
	public abstract double getDistanceForward();
}
