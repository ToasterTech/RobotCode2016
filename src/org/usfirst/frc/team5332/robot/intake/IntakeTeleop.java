package org.usfirst.frc.team5332.robot.intake;

import org.usfirst.frc.team5332.robot.Gamepad;
import org.usfirst.frc.team5332.robot.intake.base.IntakeCommandLayer;
import org.usfirst.frc.team5332.robot.intake.base.IntakeSystemLayer;

public class IntakeTeleop extends IntakeCommandLayer{
	
	private IntakeSystemLayer systemLayer;
	private Gamepad gamepad;
	
	@Override
	public void setChild(IntakeSystemLayer c) {
		 systemLayer = c;
	}

	@Override
	public void runPeriodic() {
		if(gamepad.getButton(1)) // These are generic button values and should probably not be kept. Ever.
			systemLayer.dropIntake();
		if(gamepad.getButton(2))
			systemLayer.raiseIntake();
		if(gamepad.getButton(3))
			systemLayer.runIntake();
		if(gamepad.getButton(4))
			systemLayer.stopIntake();
		if(gamepad.getButton(5))
			systemLayer.runOuttake();
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
