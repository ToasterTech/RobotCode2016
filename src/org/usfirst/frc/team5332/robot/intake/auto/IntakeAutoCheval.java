package org.usfirst.frc.team5332.robot.intake.auto;

import org.usfirst.frc.team5332.robot.SubsystemCoordinator;
import org.usfirst.frc.team5332.robot.intake.base.IntakeCommandLayer;
import org.usfirst.frc.team5332.robot.intake.base.IntakeSystemLayer;

import edu.wpi.first.wpilibj.Timer;

public class IntakeAutoCheval extends IntakeCommandLayer {
	
	private Timer timer;
	private boolean timerStarted;
	private int state;
	private boolean timeToDrop;
	
	private final int WAITING_TO_DROP = 0;
	private final int DROPPED = 1;
	private final int WAITING_TO_RAISE = 2;
	private final int RAISED = 3;
	private final double raiseTime = 2;
	
	public IntakeAutoCheval(){
		state = WAITING_TO_DROP;
		timer = new Timer();
		timeToDrop = false;
	}
	
	@Override
	public void runPeriodic() {
		switch(state){
			case WAITING_TO_DROP:
				systemLayer.raiseIntake();
				if(timeToDrop)
					state = DROPPED;
				break;
			case DROPPED:
				systemLayer.dropIntake();
				state = WAITING_TO_RAISE;
				timer.start();
				break;
			case WAITING_TO_RAISE:
				systemLayer.dropIntake();
				if(timer.get()>=raiseTime)
					state = RAISED;
				break;
			case RAISED:
				systemLayer.raiseIntake();
				break;
		}
	}

	@Override
	public void robotInit() {
		systemLayer.raiseIntake();
	}

	@Override
	public String getName() {
		return "IntakeChevalDeFrise";
	}

}
