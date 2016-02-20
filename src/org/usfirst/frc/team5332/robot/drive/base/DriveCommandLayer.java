package org.usfirst.frc.team5332.robot.drive.base;

import subsystem.Layer;

public abstract class DriveCommandLayer implements Layer<DriveSystemLayer>{
	protected DriveSystemLayer systemLayer;

	@Override
	public abstract void runPeriodic();
	@Override
	public void setChild(DriveSystemLayer c){
		systemLayer=c;
	}
}
