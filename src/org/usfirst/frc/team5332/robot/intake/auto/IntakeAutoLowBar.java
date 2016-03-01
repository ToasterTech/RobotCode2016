package org.usfirst.frc.team5332.robot.intake.auto;

import org.usfirst.frc.team5332.robot.intake.base.IntakeCommandLayer;
import org.usfirst.frc.team5332.robot.intake.base.IntakeSystemLayer;

public class IntakeAutoLowBar extends IntakeCommandLayer {
	
	@Override
	public void runPeriodic() {
		// TODO Auto-generated method stub
		systemLayer.dropIntake();
	}

	@Override
	public void robotInit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "IntakeLowBar";
	}

}
