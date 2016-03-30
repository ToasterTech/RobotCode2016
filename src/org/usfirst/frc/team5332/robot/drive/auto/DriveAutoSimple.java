package org.usfirst.frc.team5332.robot.drive.auto;

import org.usfirst.frc.team5332.robot.drive.base.DriveCommandLayer;

import edu.wpi.first.wpilibj.Timer;

public class DriveAutoSimple extends DriveCommandLayer{
	private Timer timer;
	private boolean timerStarted;
	private final int runTime=4;
	public DriveAutoSimple(){
		timer=new Timer();
	}
	@Override
	public void robotInit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "DriveSimple";
	}

	@Override
	public void runPeriodic() {
		// TODO Auto-generated method stub
		if(!timerStarted){
			timer.start();
			timerStarted=true;
		}
		if(timer.get()<runTime){
			systemLayer.setDriveHardwareLeft(1);
			systemLayer.setDriveHardwareRight(1);
		}else{
			systemLayer.setDriveHardwareLeft(0);
			systemLayer.setDriveHardwareRight(0);
		}
	}
	@Override
	public boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
