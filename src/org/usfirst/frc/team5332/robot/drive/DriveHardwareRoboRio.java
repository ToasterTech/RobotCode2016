package org.usfirst.frc.team5332.robot.drive;

import org.usfirst.frc.team5332.robot.drive.base.DriveHardwareLayer;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.TalonSRX;

public class DriveHardwareRoboRio extends DriveHardwareLayer{
	
	private TalonSRX driveLeft1;
	private TalonSRX driveLeft2;
	private TalonSRX driveRight1;
	private TalonSRX driveRight2;
	private ADXRS450_Gyro gyro;
	private Encoder encoderL;
	private Encoder encoderR;
	private double leftSide;
	private double rightSide;
	private final int ticksPerRevolution = 360;
	
	public DriveHardwareRoboRio () {
		driveLeft1 = new TalonSRX(1);
		driveLeft2 = new TalonSRX(2);
		driveRight1 = new TalonSRX(3);
		driveRight2 = new TalonSRX(4);
		encoderL = new Encoder(0,1);
		encoderR = new Encoder(2,3);
		gyro=new ADXRS450_Gyro();
	}
	
	@Override
	public void runPeriodic() {
		driveLeft1.set(-leftSide);
		driveLeft2.set(-leftSide);
		driveRight1.set(rightSide);
		driveRight2.set(rightSide);
	}

	@Override
	public void setDriveLeft(double leftSide) {
		// TODO Auto-generated method stub
		this.leftSide=leftSide;
	}

	@Override
	public void setDriveRight(double rightSide) {
		// TODO Auto-generated method stub
		this.rightSide=rightSide;
	}
	public void resetGyro(){
		gyro.reset();
	}
	public double getAngle(){
		return gyro.getAngle();
	}

	@Override
	public void robotInit() {
		// TODO Auto-generated method stub
		gyro.calibrate();
	}

	@Override
	public double getEncoderCountsL() {
		return encoderL.get();
	}

	@Override
	public double getEncoderCountsR() {
		return encoderR.get();
	}

	@Override
	public void resetEncoderCountL() {
		encoderL.reset();
	}

	@Override
	public void resetEncoderCountR() {
		encoderR.reset();
	}

	@Override
	public int getTicksPerRevolution() {
		return ticksPerRevolution;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
