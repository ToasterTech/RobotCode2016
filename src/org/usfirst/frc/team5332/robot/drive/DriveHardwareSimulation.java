package org.usfirst.frc.team5332.robot.drive;

import org.usfirst.frc.team5332.robot.drive.base.DriveHardwareLayer;

public class DriveHardwareSimulation extends DriveHardwareLayer{

	private double motorLValue;
	private double motorRValue;
	
	
	@Override
	public void runPeriodic() {
		System.out.println("Motor left side value:"+motorLValue);
		System.out.println("Motor right side value:"+motorRValue);
	}

	@Override
	public void robotInit() {
		motorLValue = 0;
		motorRValue = 0;
	}

	@Override
	public String getName() {
		return "DriveSimulation";
	}

	@Override
	public void setDriveLeft(double leftSide) {
		motorLValue = leftSide;
	}

	@Override
	public void setDriveRight(double rightSide) {
			motorRValue = rightSide;
	}

	@Override
	public void resetGyro() {
		
	}

	@Override
	public double getAngle() {
		return 0;
	}

	@Override
	public double getEncoderCountsL() {
		return 0;
	}

	@Override
	public double getEncoderCountsR() {
		return 0;
	}

	@Override
	public void resetEncoderCountL() {
	}

	@Override
	public void resetEncoderCountR() {
	}

	@Override
	public int getTicksPerRevolution() {
		return 0;
	}

}
