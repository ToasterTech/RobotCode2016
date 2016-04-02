package utils.time;

import edu.wpi.first.wpilibj.Timer;

public class WPITimer implements ToasterTimer{
	
	private Timer timer;
	private boolean timerStarted;
	
	public WPITimer(){
		timer = new Timer();
		timerStarted = false;
	}
	
	@Override
	public void start() {
		if(!timerStarted){
			timer.start();
			timerStarted=true;
		}
	}

	@Override
	public void reset() {
		timer.reset();
	}

	@Override
	public double get() {
		return timer.get();
	}

}
