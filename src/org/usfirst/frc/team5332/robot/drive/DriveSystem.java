package org.usfirst.frc.team5332.robot.drive;

import org.usfirst.frc.team5332.robot.PID;
import org.usfirst.frc.team5332.robot.drive.base.DriveHardwareLayer;
import org.usfirst.frc.team5332.robot.drive.base.DriveSystemLayer;

public class DriveSystem extends DriveSystemLayer {
	private DriveHardwareLayer hardwareLayer;
	private double l;
	private double r;
	private PID gyroControllerL;
	private PID gyroControllerR;
	
	public DriveSystem (){
		gyroControllerL = new PID(1,1);
		gyroControllerR = new PID(1,1);
	}
	
	@Override
	public void runPeriodic() {
		// TODO Auto-generated method stub
		hardwareLayer.setDriveLeft(l);
		hardwareLayer.setDriveRight(r);
	}
	@Override
	public void setChild(DriveHardwareLayer c) {
		// TODO Auto-generated method stub
		hardwareLayer=c;
	}
	public void setDriveHardwareLeft(double LArg){
		l = LArg;
	}
	public void setDriveHardwareRight(double RArg){
		r = RArg;
	}
	@Override
	public void robotInit() {
		// TODO Auto-generated method stub
	}
	@Override
	public void gyroCorrectedDriveStraight() {
		double angle=hardwareLayer.getAngle();
		this.setDriveHardwareRight(this.gyroControllerR.calculate(0.0, angle));
		this.setDriveHardwareLeft(this.gyroControllerL.calculate(0.0, angle));
	}

	@Override
	public double getDistanceForward() {
		double lEncoderCounts = hardwareLayer.getEncoderCountsL();
		double rEncoderCounts = hardwareLayer.getEncoderCountsR();
		double averageDistance = (lEncoderCounts + rEncoderCounts)/2;
		return ((averageDistance*(Math.PI*6))/hardwareLayer.getTicksPerRevolution());
	}
	

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void gyroReset() {
		// TODO Auto-generated method stub
		this.hardwareLayer.resetGyro();
	}
}
