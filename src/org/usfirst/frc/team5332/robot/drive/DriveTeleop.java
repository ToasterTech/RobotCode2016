package org.usfirst.frc.team5332.robot.drive;

import org.usfirst.frc.team5332.robot.Gamepad;
import org.usfirst.frc.team5332.robot.drive.base.DriveCommandLayer;
import org.usfirst.frc.team5332.robot.drive.base.DriveSystemLayer;

public class DriveTeleop extends DriveCommandLayer {
	private Gamepad driveGamepad;
	public DriveTeleop(){
		driveGamepad = new Gamepad(0);
	}
	@Override
	public void runPeriodic() {
		// TODO Auto-generated method stub
		systemLayer.setDriveHardwareLeft(driveGamepad.getYLeft());
		systemLayer.setDriveHardwareRight(driveGamepad.getYRight());
//		if(driveGamepad.getButton(0)){
//			systemLayer.gyroReset();
////			if(systemLayer.getDistanceForward()<24){
////				systemLayer.gyroCorrectedDriveStraight();
////			}else{
////				systemLayer.setDriveHardwareLeft(0);
////				systemLayer.setDriveHardwareRight(0);
////			}
//		}
	}

	@Override
	public void setChild(DriveSystemLayer c) {
		// TODO Auto-generated method stub
		systemLayer=c;
	}
	@Override
	public void robotInit() {
		// TODO Auto-generated method stub
		driveGamepad = new Gamepad(0);
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
