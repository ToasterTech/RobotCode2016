package utils.time;

public class JavaTimer implements ToasterTimer{
	
	private boolean timerStarted;
	private long startTime;
	
	public JavaTimer(){
		timerStarted = false;
	}
	
	@Override
	public void start() {
		if(!timerStarted){
			startTime = System.nanoTime();
			timerStarted=true;
		}
	}

	@Override
	public void reset() {
		if(timerStarted){
			startTime = System.nanoTime();
		}
	}

	@Override
	public double get() {
		return (System.nanoTime()-startTime)/Math.pow(10, 9); //In second
	}

}
