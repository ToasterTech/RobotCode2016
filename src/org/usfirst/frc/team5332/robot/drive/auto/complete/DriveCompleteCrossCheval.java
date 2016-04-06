package org.usfirst.frc.team5332.robot.drive.auto.complete;

import org.usfirst.frc.team5332.robot.drive.auto.DriveAutoNothing;
import org.usfirst.frc.team5332.robot.drive.auto.crossing.DriveCrossingCheval;
import org.usfirst.frc.team5332.robot.drive.auto.crossing.DriveCrossingCheval2;
import org.usfirst.frc.team5332.robot.drive.auto.queue.DriveAutoQueue;
import org.usfirst.frc.team5332.robot.drive.base.DriveCommandLayer;

public class DriveCompleteCrossCheval extends DriveCommandLayer {
	
	protected DriveAutoQueue queue;
	@Override
	public void robotInit() {
		queue = new DriveAutoQueue();
		queue.addAutoLayer(new DriveAutoNothing());
		queue.addAutoLayer(new DriveCrossingCheval());
		queue.addAutoLayer(new DriveAutoNothing());
		queue.addAutoLayer(new DriveCrossingCheval2());

		queue.setChild(this.systemLayer);
		queue.robotInit();
	}

	@Override
	public String getName() {
		return "CrossCheval";
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
