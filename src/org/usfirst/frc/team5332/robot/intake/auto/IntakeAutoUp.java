package org.usfirst.frc.team5332.robot.intake.auto;

import org.usfirst.frc.team5332.robot.intake.base.IntakeCommandLayer;

public class IntakeAutoUp extends IntakeCommandLayer{
	
	private boolean finished;
	private boolean intakeUp;
	
	public IntakeAutoUp(){
	
	}
	
	@Override
	public void runPeriodic() {
		if(!intakeUp){
			systemLayer.raiseIntake();
			intakeUp = true;
			finished = true;
			}
		}

	@Override
	public void robotInit() {
		finished = false;
		intakeUp = false;
	}

	@Override
	public String getName() {
		return "IntakeUp";
	}

	@Override
	public boolean isFinished() {
		return finished;
	}

}
