// No, not stacking totes. Thank God.

package org.usfirst.frc.team5332.robot.intake.auto.queue;

import java.util.ArrayDeque;
import java.util.Queue;
import org.usfirst.frc.team5332.robot.intake.base.IntakeCommandLayer;

public class IntakeAutoQueue extends IntakeCommandLayer{
	
	protected boolean finished;
	protected Queue<IntakeCommandLayer> autoQueue;
	private IntakeCommandLayer currentlyRunning;
	
	public IntakeAutoQueue(){
		autoQueue = new ArrayDeque<IntakeCommandLayer>();
	}
	
	@Override
	public void robotInit() {
		finished = false;
		currentlyRunning = null;
	}

	@Override
	public String getName() {
		return "IntakeAutoStack";
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

	public void addAutoLayer(IntakeCommandLayer mode){
		autoQueue.add(mode);
	}
	
}
