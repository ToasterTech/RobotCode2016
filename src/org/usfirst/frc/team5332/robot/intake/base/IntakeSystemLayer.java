package org.usfirst.frc.team5332.robot.intake.base;

import subsystem.Layer;

public abstract class IntakeSystemLayer implements Layer<IntakeHardwareLayer> {
	
	public abstract void dropIntake();
	public abstract void raiseIntake();
	public abstract void runIntake();
	public abstract void stopIntake();
	public abstract void runOuttake();
	
}
