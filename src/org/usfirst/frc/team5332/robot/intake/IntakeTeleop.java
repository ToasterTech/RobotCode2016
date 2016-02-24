package org.usfirst.frc.team5332.robot.intake;

import org.usfirst.frc.team5332.robot.Gamepad;
import org.usfirst.frc.team5332.robot.intake.base.IntakeCommandLayer;
import org.usfirst.frc.team5332.robot.intake.base.IntakeSystemLayer;

public class IntakeTeleop extends IntakeCommandLayer{
	
	private IntakeSystemLayer systemLayer;
	private Gamepad gamepad;
	private boolean intakeDown;
	private boolean hasBall;
	private boolean intakeLocked;
	
	private boolean lastIntakeState;
	private boolean lastBallState;
	private boolean lastLockState;
	
	public IntakeTeleop(){
		gamepad=new Gamepad(0);
		lastIntakeState=false;
		intakeDown=false;
		lastBallState=false;
		hasBall=false;
	}
	@Override
	public void setChild(IntakeSystemLayer c) {
		 systemLayer = c;
		 
	}

	@Override
	public void runPeriodic() {
		boolean dropIntakeButton=gamepad.getButton(5);
		boolean hasBallButton=gamepad.getButton(6);
		boolean lockIntakeButton=gamepad.getButton(7);
		
		if((dropIntakeButton&&!lastIntakeState)){
			intakeDown=!intakeDown;
		}
		lastIntakeState=dropIntakeButton;
		
		if((hasBallButton&&!lastBallState)){
			hasBall=!hasBall;
		}
		lastBallState=hasBallButton;
		
		if((lockIntakeButton&&!lastLockState)){
			intakeLocked=!intakeLocked;
		}
		lastLockState=lockIntakeButton;
		
		if(intakeDown){
			systemLayer.dropIntake();
		}else
			systemLayer.raiseIntake();
		
//		if(gamepad.getTriggerLeft())
//			if(!intakeDown)
//				if(!intakeLocked)
//					systemLayer.runIntake(); //If the intake is not down BUT not locked, run the intake
//				else{systemLayer.stopIntake();} //If the intake is not down AND locked, do not run the intake
//			else{systemLayer.runIntake();} //If the intake is down, run the intake
		if (gamepad.getTriggerLeft())
			systemLayer.runIntake();
		else if(gamepad.getTriggerRight())
			systemLayer.runOuttake();
		else
			systemLayer.stopIntake();
	}

	@Override
	public void robotInit() {
		lastIntakeState=false;
		intakeDown=false;
		lastBallState=false;
		hasBall=false;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
