package org.usfirst.frc.team5332.robot.drive.auto;

import org.usfirst.frc.team5332.robot.drive.base.DriveCommandLayer;

import edu.wpi.first.wpilibj.Timer;

public class DriveAutoConfigurable extends DriveCommandLayer{
	private Timer timer;
	private Timer waitTimer;
	private boolean timerStarted;
	private double runTime=4;
	private boolean waitTimerStarted;

// 	 TODO Cheval de Frise auto code variables
//	private double finishTime;
//	private double stopTime;
//	private double stopLength;
//  private boolean doTimedStop;
	
	private double directionConstant = 0;
	private double speed = 0;
	
	public DriveAutoConfigurable(double runtime, boolean invert, double speeda/*,boolean doTS, double stopt, double stopl*/){
		timer = new Timer();
		timerStarted = false;
		waitTimer = new Timer();
		waitTimerStarted = false;
		runTime = runtime;
		speed = speeda;
//		TODO Cheval de Frise auto constructor variable handling
//		doTimedStop = doTS;
//		stopTime = stopt;
//		stopLength = stopl;
		if(invert) // If we want to invert motor direction (Drive backwards instead of forwards)
			directionConstant = -1; // Multiply by -1 to invert
		else
			directionConstant = 1; // Otherwise multiply by 1 to retain value
	}
	@Override
	public void robotInit() {
		directionConstant = 0;
		speed = 0;
	}

	@Override
	public String getName() {
		return "DriveConfigurable";
	}

	@Override
	public void runPeriodic() {
		if(!waitTimerStarted){
			waitTimer.start();
			waitTimerStarted = true;
		}
		if(waitTimer.get()>=2){
				if(!timerStarted){
					timer.start();
					timerStarted=true;
				}
//				TODO Cheval de Frise Auto type handler
				if(timer.get()<runTime /*&& !doTimedStop*/){
					systemLayer.setDriveHardwareLeft(speed*directionConstant);
					systemLayer.setDriveHardwareRight(speed*directionConstant);
				}else{
					systemLayer.setDriveHardwareLeft(0);
					systemLayer.setDriveHardwareRight(0);
				}
				
// TODO Cheval de Frise code for a controlled stop	
//				if(doTimedStop){
//					 if(timer.get() < finishTime && timer.get() < stopTime){
//						 systemLayer.setDriveHardwareLeft(speed*directionConstant);
//						 systemLayer.setDriveHardwareRight(speed*directionConstant);
//					 } else if(timer.get() < finishTime && timer.get() >= stopTime && timer.get() <= (stopTime + stopLength)){
//						 systemLayer.setDriveHardwareLeft(0);
//						 systemLayer.setDriveHardwareRight(0);
//					 } else if(timer.get() < finishTime && timer.get() > (stopTime + stopLength)){
//						 systemLayer.setDriveHardwareLeft(speed*directionConstant);
//						 systemLayer.setDriveHardwareRight(speed*directionConstant);
//					 } else if(timer.get() >= finishTime){
//						 systemLayer.setDriveHardwareLeft(0);
//						 systemLayer.setDriveHardwareRight(0);
//					 }
//			}
		}
	}
	@Override
	public boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
}
