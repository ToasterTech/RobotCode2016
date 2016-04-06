package org.usfirst.frc.team5332.robot.intake.auto;

import org.usfirst.frc.team5332.robot.intake.base.IntakeCommandLayer;

import edu.wpi.first.wpilibj.Timer;

public class IntakeAutoConfigurable extends IntakeCommandLayer {

	private boolean intakeRaised = true;

	private double dropTime = -1;
	private boolean timerStarted;
	private Timer timer;

	public IntakeAutoConfigurable(boolean intakeUp, double droptime) {
		intakeRaised = intakeUp;
		dropTime = droptime;
		timer = new Timer();
	}

	@Override
	public void runPeriodic() {
		/*
		 * Always check if we're raised or not. Regardless of if we drop later
		 * we need to handle our raised state.
		 */
//		if (intakeRaised)
//			systemLayer.raiseIntake();
//		else
//			systemLayer.dropIntake();

		/*
		 * First, check if we are currently raised Then see if we have a
		 * positive drop time Then handle the timer state Then see if it is time
		 * to drop. If not, don't drop. If do, then set intakeRaised to false so
		 * that we aren't stuck up and then drop the intake
		 */

			if (!timerStarted) {
				timer.start();
				timerStarted = true;
			}
			if(dropTime<0){
				systemLayer.raiseIntake();
			}
			else if (timer.get() >= dropTime) { // If it isn't time to drop
				systemLayer.dropIntake(); // Don't drop
			} else { // Otherwise
				intakeRaised = true; // Don't lock the intake up
				systemLayer.raiseIntake(); // Drop
			}
		}

	@Override
	public void robotInit() {
		// TODO Auto-generated method stub
		systemLayer.raiseIntake();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "IntakeConfigurable";
	}

	@Override
	public boolean getFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
