package org.usfirst.frc.team5332.robot.drive.teleop;

import org.usfirst.frc.team5332.robot.Gamepad;
import org.usfirst.frc.team5332.robot.drive.base.DriveCommandLayer;
import org.usfirst.frc.team5332.robot.drive.base.DriveSystemLayer;


public class DriveTeleopRunStraight extends DriveCommandLayer {

	private Gamepad controller;
	
	public DriveTeleopRunStraight(Gamepad pad){
		controller = pad;
	}
	@Override
	public void runPeriodic() {
		systemLayer.setDriveHardwareLeft(controller.getYLeft());
		systemLayer.setDriveHardwareRight(controller.getYLeft());
	}

	@Override
	public void setChild(DriveSystemLayer c) {
		// TODO Auto-generated method stub
		systemLayer=c;
	}
	@Override
	public void robotInit() {
		// TODO Auto-generated method stub
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
