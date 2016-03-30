// No, not stacking totes. Thank God.

package org.usfirst.frc.team5332.robot.drive.auto.stack;

import java.util.Queue;
import java.util.Stack;

import org.usfirst.frc.team5332.robot.drive.base.DriveCommandLayer;

public class DriveAutoStack extends DriveCommandLayer{
	
	protected boolean finished;
	protected Queue<DriveCommandLayer> autoQueue;
	private DriveCommandLayer currentlyRunning;
	
	@Override
	public void robotInit() {
		finished = false;
		currentlyRunning = null;
	}

	@Override
	public String getName() {
		return "DriveAutoStack";
	}

	@Override
	public void runPeriodic() {
		if((currentlyRunning == null||currentlyRunning.isFinished())&&!finished){
			if(!autoQueue.isEmpty()){
				currentlyRunning = autoQueue.poll();
				currentlyRunning.setChild(this.systemLayer);
				currentlyRunning.robotInit();
			}else{
				finished = true;
			}
		}
		if(currentlyRunning!=null&&!finished){
			currentlyRunning.runPeriodic();
		}
	}

	@Override
	public boolean isFinished() {
		return finished;
	}

	public void addAutoLayer(DriveCommandLayer mode){
		autoQueue.add(mode);
	}
	
}
