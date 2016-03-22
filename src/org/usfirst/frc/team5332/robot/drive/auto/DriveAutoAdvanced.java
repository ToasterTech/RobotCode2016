package org.usfirst.frc.team5332.robot.drive.auto;

import org.usfirst.frc.team5332.robot.drive.base.DriveCommandLayer;

import edu.wpi.first.wpilibj.Timer;

public class DriveAutoAdvanced extends DriveCommandLayer{
	private Timer timer;
	private boolean timerStarted;
	
	private String robotObstacle;
	private double robotPosition;
	private String robotAction;
	
	public DriveAutoAdvanced(String obstacle, double position, String action){
		timer=new Timer();
		robotObstacle = obstacle;
		robotPosition = position;
		robotAction = action;
		
	}
	@Override
	public void robotInit() {
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "DriveAutoAdvanced";
	}

	@Override
	public void runPeriodic() {
		// TODO Auto-generated method stub
		if(!timerStarted){
			timer.start();
			timerStarted=true;
		}
	}
}
