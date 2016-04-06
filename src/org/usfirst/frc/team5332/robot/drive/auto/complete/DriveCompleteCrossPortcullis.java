package org.usfirst.frc.team5332.robot.drive.auto.complete;

import org.usfirst.frc.team5332.robot.drive.auto.DriveAutoNothing;
import org.usfirst.frc.team5332.robot.drive.auto.crossing.DriveCrossingPortcullis;
import org.usfirst.frc.team5332.robot.drive.auto.queue.DriveAutoQueue;
import org.usfirst.frc.team5332.robot.drive.base.DriveCommandLayer;

public class DriveCompleteCrossPortcullis extends DriveCommandLayer {
	
	protected DriveAutoQueue queue;
	
	@Override
	public void robotInit() {
		queue = new DriveAutoQueue();
		queue.addAutoLayer(new DriveAutoNothing());
		queue.addAutoLayer(new DriveCrossingPortcullis());
	}

	@Override
	public String getName() {
		return "CrossPortcullis";
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
