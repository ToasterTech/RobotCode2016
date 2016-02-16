package org.usfirst.frc.team5332.robot.intake;

import org.usfirst.frc.team5332.robot.intake.base.IntakeHardwareLayer;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.TalonSRX;

public class IntakeHardwareRoboRio extends IntakeHardwareLayer {

	private TalonSRX intakeMotor;
	private Solenoid intakePiston;
	private boolean isExtended;
	private double intakeSpeed;
	
	@Override
	public void runPeriodic() {
		intakeMotor.set(intakeSpeed);
		intakePiston.set(isExtended);
	}

	@Override
	public void robotInit() {
		intakeMotor = new TalonSRX(5);
		intakePiston = new Solenoid(0);
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
		return intakePiston.get();
	}

	@Override
	public boolean isPistonRetracted() {
		return intakePiston.get();
	}

	@Override
	public double getIntakeSpeed() {
		return intakeMotor.get();
	}

}
