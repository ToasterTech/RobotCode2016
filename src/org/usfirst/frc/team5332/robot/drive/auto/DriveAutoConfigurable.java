package org.usfirst.frc.team5332.robot.drive.auto;

import org.usfirst.frc.team5332.robot.drive.base.DriveCommandLayer;

import edu.wpi.first.wpilibj.Timer;

public class DriveAutoConfigurable extends DriveCommandLayer{
	private Timer timer;
	private boolean timerStarted;
	private double runTime=4;
	private double directionConstant;
	private double speed;
	public DriveAutoConfigurable(double runtime, boolean invert, double speeda){
		timer=new Timer();
		runTime = runtime;
		speed = speeda;
		if(invert) // If we want to invert motor direction (Drive backwards instead of forwards)
			directionConstant = -1; // Multiply by -1 to invert
		else
			directionConstant = 1; // Otherwise multiply by 1 to retain value
	}
	@Override
	public void robotInit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "DriveConfigurable";
	}

	@Override
	public void runPeriodic() {
		// TODO Auto-generated method stub
		if(!timerStarted){
			timer.start();
			timerStarted=true;
		}
		if(timer.get()<runTime){
			systemLayer.setDriveHardwareLeft(speed*directionConstant);
			systemLayer.setDriveHardwareRight(speed*directionConstant);
		}else{
			systemLayer.setDriveHardwareLeft(0);
			systemLayer.setDriveHardwareRight(0);
		}
	}
	
}
