package org.usfirst.frc.team5332.robot;

public class PID {
	
	private double kP;
	private double kD;
	private double previousError;
	private long previousTime;
	private double scale;
	public PID(double kPArg, double kDArg){
		kP = kPArg;
		kD = kDArg;
		scale=1;
	}
	public PID(double kPArg, double kDArg,double s){
		kP = kPArg;
		kD = kDArg;
		scale=s;
	}

	public double calculate(double target, double measure){
		long currentTime=System.currentTimeMillis();
		double error = target - measure;
		double P = kP * error;
		double D = kD * ((previousError - error)/(currentTime - previousTime));
		previousError = error;
		previousTime = currentTime;
		return (P + D)/scale;
	}
	
}
