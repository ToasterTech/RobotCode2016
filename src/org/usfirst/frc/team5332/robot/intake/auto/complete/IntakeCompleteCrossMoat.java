package org.usfirst.frc.team5332.robot.intake.auto.complete;

import org.usfirst.frc.team5332.robot.intake.auto.IntakeAutoDown;
import org.usfirst.frc.team5332.robot.intake.auto.IntakeAutoNothing;
import org.usfirst.frc.team5332.robot.intake.auto.IntakeAutoUp;
import org.usfirst.frc.team5332.robot.intake.auto.queue.IntakeAutoQueue;
import org.usfirst.frc.team5332.robot.intake.base.IntakeCommandLayer;

public class IntakeCompleteCrossMoat extends IntakeCommandLayer {
	
	protected IntakeAutoQueue queue;
	
	@Override
	public void robotInit() {
		queue = new IntakeAutoQueue();
		queue.addAutoLayer(new IntakeAutoUp());
		queue.addAutoLayer(new IntakeAutoNothing(1000));
		queue.setChild(this.systemLayer);
		queue.robotInit();
	}

	@Override
	public String getName() {
		return "CrossMoat";
	}

	@Override
	public void runPeriodic() {
		queue.runPeriodic();
	}

	@Override
	public boolean isFinished() {
		return queue.isFinished();
	}

}
