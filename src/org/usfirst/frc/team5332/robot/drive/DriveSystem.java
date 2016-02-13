package org.usfirst.frc.team5332.robot.drive;

import org.usfirst.frc.team5332.robot.drive.base.DriveHardwareLayer;
import org.usfirst.frc.team5332.robot.drive.base.DriveSystemLayer;

public class DriveSystem extends DriveSystemLayer {
	private DriveHardwareLayer hardwareLayer;
	private double l;
	private double r;
	@Override
	public void runPeriodic() {
		// TODO Auto-generated method stub
		hardwareLayer.setDriveLeft(l);
		hardwareLayer.setDriveRight(r);
	}

	@Override
	public void setChild(DriveHardwareLayer c) {
		// TODO Auto-generated method stub
		hardwareLayer=c;
	}

	public void setDriveHardwareLeft(double LArg){
		l = LArg;
	}
	
	public void setDriveHardwareRight(double RArg){
		r = RArg;
	}
	
}
