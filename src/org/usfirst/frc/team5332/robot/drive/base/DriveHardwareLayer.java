package org.usfirst.frc.team5332.robot.drive.base;

import subsystem.BaseLayer;

public abstract class DriveHardwareLayer implements BaseLayer{
	public abstract void setDriveLeft(double leftSide);
	public abstract void setDriveRight(double rightSide);
	@Override
	public void runPeriodic() {
	
		
	}
	
}
