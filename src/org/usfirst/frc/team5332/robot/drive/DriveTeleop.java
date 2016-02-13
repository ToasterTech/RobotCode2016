package org.usfirst.frc.team5332.robot.drive;

import org.usfirst.frc.team5332.robot.Gamepad;
import org.usfirst.frc.team5332.robot.drive.base.DriveCommandLayer;
import org.usfirst.frc.team5332.robot.drive.base.DriveSystemLayer;

public class DriveTeleop extends DriveCommandLayer {
	private DriveSystemLayer systemLayer;
	private Gamepad driveGamepad;
	public DriveTeleop(){
		driveGamepad = new Gamepad(0);
	}
	@Override
	public void runPeriodic() {
		// TODO Auto-generated method stub
		systemLayer.setDriveHardwareLeft(driveGamepad.getYLeft());
		systemLayer.setDriveHardwareRight(driveGamepad.getYRight());
	}

	@Override
	public void setChild(DriveSystemLayer c) {
		// TODO Auto-generated method stub
		systemLayer=c;
	}

}
