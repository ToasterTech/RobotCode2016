package org.usfirst.frc.team5332.robot.intake;

import org.usfirst.frc.team5332.robot.Gamepad;
import org.usfirst.frc.team5332.robot.intake.base.IntakeCommandLayer;
import org.usfirst.frc.team5332.robot.intake.base.IntakeSystemLayer;

public class IntakeTeleop extends IntakeCommandLayer{
	
	private IntakeSystemLayer systemLayer;
	private Gamepad gamepad;
	private boolean intakeDown;
	private boolean lastButton;
	public IntakeTeleop(){
		gamepad=new Gamepad(0);
		lastButton=false;
		intakeDown=false;
	}
	@Override
	public void setChild(IntakeSystemLayer c) {
		 systemLayer = c;
		 
	}

	@Override
	public void runPeriodic() {
		boolean dropIntakeButton=gamepad.getButton(5);
		if((dropIntakeButton&&!lastButton)){
			intakeDown=!intakeDown;
		}
		lastButton=dropIntakeButton;
		if(intakeDown){
			systemLayer.dropIntake();
		}else
			systemLayer.raiseIntake();
		if(gamepad.getTriggerLeft())
			systemLayer.runIntake();
		else if(gamepad.getTriggerRight())
			systemLayer.runOuttake();
		else
			systemLayer.stopIntake();
	}

	@Override
	public void robotInit() {
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
