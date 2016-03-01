package org.usfirst.frc.team5332.robot.drive.auto;

import org.usfirst.frc.team5332.robot.drive.base.DriveCommandLayer;
import org.usfirst.frc.team5332.robot.drive.base.DriveSystemLayer;

public class DriveAutoNone extends DriveCommandLayer {
	
	@Override
	public void robotInit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void runPeriodic() {
		// TODO Auto-generated method stub
		systemLayer.setDriveHardwareLeft(0);
		systemLayer.setDriveHardwareRight(0);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "DriveNone";
	}

}
