package tests;

import org.usfirst.frc.team5332.robot.PID;

public class PIDTest {
	public static void main(String[] agrs){
		PID pid=new PID(1,1,5000);
		double target=5000;
		double measure=0;
		for(int i=0;i<1000;i++){
			double value=pid.calculate(target, measure);
			measure=measure+value*500;
			System.out.println(System.out.format("Value=%f.4,Measure=%f.2", value,measure));
			 try {
				Thread.sleep(15);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
