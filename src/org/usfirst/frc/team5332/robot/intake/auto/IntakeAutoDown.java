package org.usfirst.frc.team5332.robot.intake.auto;

import org.usfirst.frc.team5332.robot.intake.base.IntakeCommandLayer;

public class IntakeAutoDown extends IntakeCommandLayer{
	
	private boolean finished;
	private boolean intakeDown;
	
	public IntakeAutoDown(){
	
	}
	
	@Override
	public void runPeriodic() {
		if(!intakeDown){
			systemLayer.dropIntake();
			intakeDown = true;
			finished = true;
			}
		}

	@Override
	public void robotInit() {
		finished = false;
		intakeDown = false;
	}

	@Override
	public String getName() {
		return "IntakeDown";
	}

	@Override
	public boolean isFinished() {
		return finished;
	}

}
