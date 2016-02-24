package org.usfirst.frc.team5332.robot.intake;

import org.usfirst.frc.team5332.robot.intake.base.IntakeHardwareLayer;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.hal.PDPJNI;

public class IntakeHardwareRoboRio extends IntakeHardwareLayer {

	private TalonSRX intakeMotor;
	private Solenoid intakePiston;
	private Solenoid intakePiston2;
	private PDPJNI PDP;

	private boolean isExtended;
	private double intakeSpeed;
	
	@Override
	public void runPeriodic() {
		intakeMotor.set(intakeSpeed);
		intakePiston.set(isExtended);
		intakePiston2.set(isExtended);
	}

	@Override
	public void robotInit() {
		intakeMotor = new TalonSRX(7);
		intakePiston = new Solenoid(0);
		intakePiston2 = new Solenoid(1);
		isExtended = false;
		intakeSpeed = 0.0;
		PDP = new PDPJNI();
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

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getCurrent() {
		return PDP.getPDPTotalCurrent(0);
	}

}
