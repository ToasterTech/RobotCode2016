package org.usfirst.frc.team5332.robot.drive.base;

import subsystem.BaseLayer;

public abstract class DriveHardwareLayer implements BaseLayer{
	public abstract void setDriveLeft(double leftSide);
	public abstract void setDriveRight(double rightSide);
	public abstract void resetGyro();
	public abstract double getAngle();
	public abstract double getEncoderCountsL();
	public abstract double getEncoderCountsR();
	public abstract void resetEncoderCountL();
	public abstract void resetEncoderCountR();
	public abstract int getTicksPerRevolution();
}
