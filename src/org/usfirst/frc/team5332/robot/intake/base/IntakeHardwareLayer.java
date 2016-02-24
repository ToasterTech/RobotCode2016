package org.usfirst.frc.team5332.robot.intake.base;

import subsystem.BaseLayer;

public abstract class IntakeHardwareLayer implements BaseLayer {
	
	public abstract void runIntakeMotor(double speed);
	public abstract void extendPiston();
	public abstract void retractPiston();
	public abstract boolean isPistonExtended();
	public abstract boolean isPistonRetracted();
	public abstract double getIntakeSpeed();
	public abstract double getCurrent();

}
