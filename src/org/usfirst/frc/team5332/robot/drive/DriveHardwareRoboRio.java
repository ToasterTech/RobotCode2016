package org.usfirst.frc.team5332.robot.drive;

import org.usfirst.frc.team5332.robot.drive.base.DriveHardwareLayer;
import edu.wpi.first.wpilibj.TalonSRX;

public class DriveHardwareRoboRio extends DriveHardwareLayer{
	
	private TalonSRX driveLeft1;
	private TalonSRX driveLeft2;
	private TalonSRX driveRight1;
	private TalonSRX driveRight2;
	
	private double leftSide;
	private double rightSide;
	
	public DriveHardwareRoboRio () {
		driveLeft1 = new TalonSRX(1);
		driveLeft2 = new TalonSRX(2);
		driveRight1 = new TalonSRX(3);
		driveRight2 = new TalonSRX(4);
	}
	
	@Override
	public void runPeriodic() {
		driveLeft1.set(leftSide);
		driveLeft2.set(leftSide);
		driveRight1.set(rightSide);
		driveRight2.set(rightSide);
	}

	@Override
	public void setDriveLeft(double leftSide) {
		// TODO Auto-generated method stub
		this.leftSide=leftSide;
	}

	@Override
	public void setDriveRight(double rightSide) {
		// TODO Auto-generated method stub
		this.rightSide=rightSide;
	}

	
	
}
