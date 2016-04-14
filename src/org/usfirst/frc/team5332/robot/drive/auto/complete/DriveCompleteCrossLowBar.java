package org.usfirst.frc.team5332.robot.drive.auto.complete;

import org.usfirst.frc.team5332.robot.drive.auto.DriveAutoNothing;
import org.usfirst.frc.team5332.robot.drive.auto.crossing.DriveCrossingLowBar;
import org.usfirst.frc.team5332.robot.drive.auto.queue.DriveAutoQueue;
import org.usfirst.frc.team5332.robot.drive.base.DriveCommandLayer;

public class DriveCompleteCrossLowBar extends DriveCommandLayer {
	
	protected DriveAutoQueue queue;
	
	@Override
	public void robotInit() {
		queue = new DriveAutoQueue();
		queue.addAutoLayer(new DriveAutoNothing());
		queue.addAutoLayer(new DriveCrossingLowBar());
		queue.setChild(this.systemLayer);
		queue.robotInit();

	}

	@Override
	public String getName() {
		return "CrossLowBar";
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
