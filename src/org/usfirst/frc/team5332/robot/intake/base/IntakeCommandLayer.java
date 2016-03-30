package org.usfirst.frc.team5332.robot.intake.base;

import subsystem.Layer;

public abstract class IntakeCommandLayer implements Layer<IntakeSystemLayer> {
	protected IntakeSystemLayer systemLayer;
	public void setChild(IntakeSystemLayer c){
		systemLayer=c;
	}
	
	public abstract boolean getFinished();
}
