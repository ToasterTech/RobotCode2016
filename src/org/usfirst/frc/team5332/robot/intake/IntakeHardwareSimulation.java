package org.usfirst.frc.team5332.robot.intake;

import org.usfirst.frc.team5332.robot.intake.base.IntakeHardwareLayer;

public class IntakeHardwareSimulation extends IntakeHardwareLayer {

	private boolean isExtended;
	private double intakeSpeed;
	
	@Override
	public void runPeriodic() {
		System.out.println("Current intake speed: "+intakeSpeed);
		System.out.println("Is intake extended: "+isExtended);
	}

	@Override
	public void robotInit() {
		isExtended = false;
		intakeSpeed = 0.0;
	}

	@Override
	public void runIntakeMotor(double speed) {
		intakeSpeed = speed;
	}

	@Override
	public void extendPiston() {
		isExtended = true;
	}

	@Override
	public void retractPiston() {
		isExtended = false;
	}

	@Override
	public boolean isPistonExtended() {
		return isExtended;
	}

	@Override
	public boolean isPistonRetracted() {
		return !isExtended;
	}

	@Override
	public double getIntakeSpeed() {
		return intakeSpeed;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getCurrent() {
		return -2.0;
	}

}
