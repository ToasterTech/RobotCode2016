package org.usfirst.frc.team5332.robot.intake.auto;

import org.usfirst.frc.team5332.robot.intake.base.IntakeCommandLayer;
import org.usfirst.frc.team5332.robot.intake.base.IntakeSystemLayer;

import edu.wpi.first.wpilibj.Timer;

public class IntakeAutoAdvanced extends IntakeCommandLayer {
	
	private int robotPosition;
	private String robotObstacle;
	private String robotAction;
	private Timer timer;
	private boolean timerStarted;
	
	//================
	private boolean doShoot = false;
	private boolean startDown = false;
	private double dropTime = -1.0;
	private double cdfUpTime = 1000.0;
	
	public IntakeAutoAdvanced (int position, String obstacle, String action){
		robotPosition = position;
		if(robotPosition == 0){//1, Low Bar
			robotObstacle = "LowBar";
		}else if (robotPosition == 5){ //6, Spy Zone
			robotObstacle = "SpyZone";
		}else{ //Otherwise
			robotObstacle = obstacle;
		}
		robotAction = action;
		timer = new Timer();
	}
	
	@Override
	public void robotInit() {
		//=====Obstacle=====
		if(robotObstacle.equals("Ramparts") || robotObstacle.equals("Moat") || robotObstacle.equals("Rock") || robotObstacle.equals("Rough") || robotObstacle.equals("Cheval de Frise")){
			startDown = false;
		}else if(robotObstacle.equals("LowBar") || robotObstacle.equals("Portcullis") || robotObstacle.equals("SpyZone")){
			startDown = true;
		}
		
		if(robotObstacle == "Cheval de Frise"){
			dropTime = 3.0;
			cdfUpTime = dropTime + 1.0;
		}
		
		//=====Action=====
		if(robotAction.equals("Cross")|| robotAction.equals("Cross & Return")){
			/*These are not the codes you're looking for*/
		} else if(robotAction.equals("Cross & Shoot") || robotAction.equals("Cross, Shoot & Return")){
			doShoot = true;
		}
	}
 	
	@Override
	public void runPeriodic() {
		if (!timerStarted) {
			timer.start();
			timerStarted = true;
		}
		
		if(startDown = true)
			systemLayer.dropIntake();
		else
			systemLayer.raiseIntake();
	
		if(timer.get()<=dropTime)
			systemLayer.raiseIntake();
		else if(timer.get()>=dropTime && timer.get()<=cdfUpTime){
			systemLayer.dropIntake();
		}
		else if(timer.get()>=dropTime && timer.get()>=cdfUpTime){
			systemLayer.raiseIntake();
		}
		
		if(timer.get()>=12.5){
			systemLayer.runOuttake();
		}
	}

	@Override
	public String getName() {
		return "IntakeAdvanced";
	}

	@Override
	public boolean getFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
