package org.usfirst.frc.team5332.robot.drive.auto.complete;

import org.usfirst.frc.team5332.robot.drive.auto.DriveAutoNothing;
import org.usfirst.frc.team5332.robot.drive.auto.crossing.DriveCrossingRamparts;
import org.usfirst.frc.team5332.robot.drive.auto.crossing.DriveCrossingRockWall;
import org.usfirst.frc.team5332.robot.drive.auto.queue.DriveAutoQueue;
import org.usfirst.frc.team5332.robot.drive.base.DriveCommandLayer;

public class DriveCompleteCrossRamparts extends DriveCommandLayer {
	
	protected DriveAutoQueue queue;
	
	@Override
	public void robotInit() {
		queue = new DriveAutoQueue();
		queue.addAutoLayer(new DriveAutoNothing());
		queue.addAutoLayer(new DriveCrossingRamparts());
		queue.setChild(this.systemLayer);
		queue.robotInit();
	}

	@Override
	public String getName() {
		return "CrossRamparts";
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
