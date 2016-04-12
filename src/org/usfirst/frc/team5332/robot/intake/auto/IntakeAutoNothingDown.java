package org.usfirst.frc.team5332.robot.intake.auto;

import org.usfirst.frc.team5332.robot.intake.base.IntakeCommandLayer;

import utils.time.ToasterTimer;
import utils.time.WPITimer;

public class IntakeAutoNothingDown extends IntakeCommandLayer{
	
	private boolean finished;
	private ToasterTimer timer;
	private boolean timerStarted;
	private double nothingTime;
	
	public IntakeAutoNothingDown(){
		timer = new WPITimer();
		nothingTime = 2.0;
	}
	
	public IntakeAutoNothingDown(double time){
		nothingTime = time;
		timer = new WPITimer();
	}
	
	public IntakeAutoNothingDown(ToasterTimer timerArg){
		timer = timerArg;
		nothingTime = 2.0;
	}
	
	public IntakeAutoNothingDown(ToasterTimer timerArg,double time){
		timer = timerArg;
		nothingTime = time;
	}
	
	@Override
	public void runPeriodic() {
		if(!timerStarted){ // Honey, where's my super suit?
			timer.start(); // Get this party started
			timerStarted = true; // I told you I found the batteries
		}
		
		if(timer.get()<nothingTime){ // Bam Bam doesn't sleep. He waits
			systemLayer.dropIntake();
		}else{
			finished = true;
		}
	}

	@Override
	public void robotInit() {
		finished = false;
		timerStarted = false;
	}

	@Override
	public String getName() {
		return "IntakeNothing";
	}

	@Override
	public boolean isFinished() {
		// TODO Auto-generated method stub
		return finished;
	}

}
