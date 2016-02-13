package org.usfirst.frc.team5332.robot.drive.base;

import subsystem.Layer;

public abstract class DriveCommandLayer implements Layer<DriveSystemLayer>{

	@Override
	public abstract void runPeriodic();
	@Override
	public abstract void setChild(DriveSystemLayer c);
}
