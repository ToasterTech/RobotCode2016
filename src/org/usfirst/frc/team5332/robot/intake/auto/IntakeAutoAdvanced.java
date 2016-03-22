package org.usfirst.frc.team5332.robot.intake.auto;

import org.usfirst.frc.team5332.robot.intake.base.IntakeCommandLayer;
import org.usfirst.frc.team5332.robot.intake.base.IntakeSystemLayer;

import edu.wpi.first.wpilibj.Timer;

public class IntakeAutoAdvanced extends IntakeCommandLayer {

	private boolean timerStarted;
	private Timer timer;
	
	private String robotObstacle;
	private double robotPosition;
	private String robotAction;
	
	public IntakeAutoAdvanced(String obstacle, double position, String action){
		timer = new Timer();
		robotObstacle = obstacle;
		robotPosition = position;
		robotAction = action;
	}
	
	@Override
	public void runPeriodic() {
		// TODO Auto-generated method stub
		systemLayer.raiseIntake();
	}

	@Override
	public void robotInit() {
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "IntakeSimple";
	}

}
