package org.usfirst.frc.team5332.robot.intake;

import org.usfirst.frc.team5332.robot.intake.base.IntakeHardwareLayer;
import org.usfirst.frc.team5332.robot.intake.base.IntakeSystemLayer;

public class IntakeSystem extends IntakeSystemLayer {
	
	private IntakeHardwareLayer hardwareLayer;
	private final double intakeSpeed = 1.0;
	private final double outtakeSpeed = -1.0;
	private boolean isIntakeDown;
	private boolean isIntaking;
	private boolean isStopped;
	
	@Override
	public void setChild(IntakeHardwareLayer c) {
		hardwareLayer = c;
	}

	@Override
	public void runPeriodic() {
		if(isStopped)
			hardwareLayer.runIntakeMotor(0); //Check this first to make sure that it ends if we are stopped
		else if (isIntaking)
			hardwareLayer.runIntakeMotor(intakeSpeed);
		else if (!isIntaking) // If we are not intaking but not stopped, outtake
			hardwareLayer.runIntakeMotor(outtakeSpeed);
		else hardwareLayer.runIntakeMotor(0); // If stupid things happen, suht down everything
		
		if(isIntakeDown)
			hardwareLayer.extendPiston(); // When the intake is down, the piston should be pushing it out because logic
		else
			hardwareLayer.retractPiston(); // If it isn't down or there is a technical error, it will stay up as well
	}

	@Override
	public void robotInit() {
		isStopped = true; // We should start not running motors
		isIntaking = false; // If it isn't running it also isn't intaking
		isIntakeDown = false; // Our intake is not starting down. That just doesn't make sense.
	}

	@Override
	public void dropIntake() {
		isIntakeDown = true;
	}

	@Override
	public void raiseIntake() {
		isIntakeDown = false;
	}

	@Override
	public void runIntake() {
		isStopped = false;
		isIntaking = true;
	}

	@Override
	public void stopIntake() {
		isStopped = true;
		isIntaking = false;
	}

	@Override
	public void runOuttake(){
		isStopped = false;
		isIntaking = false;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
}
