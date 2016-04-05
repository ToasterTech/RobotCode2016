package autoselect;

import java.util.ArrayList;
import java.util.HashMap;

import org.usfirst.frc.team5332.robot.drive.auto.DriveAutoNothing;
import org.usfirst.frc.team5332.robot.drive.auto.complete.DriveCompleteCrossCheval;
import org.usfirst.frc.team5332.robot.drive.auto.complete.DriveCompleteCrossPortcullis;
import org.usfirst.frc.team5332.robot.drive.auto.complete.DriveCompleteCrossRock;
//import org.usfirst.frc.team5332.robot.drive.auto.DriveAutoHingedRamps;
//import org.usfirst.frc.team5332.robot.drive.auto.DriveAutoLowBar;
//import org.usfirst.frc.team5332.robot.drive.auto.DriveAutoRoughTerrain;
import org.usfirst.frc.team5332.robot.drive.base.DriveCommandLayer;
import org.usfirst.frc.team5332.robot.intake.auto.IntakeAutoNothing;
import org.usfirst.frc.team5332.robot.intake.auto.complete.IntakeCompleteCrossCheval;
import org.usfirst.frc.team5332.robot.intake.base.IntakeCommandLayer;

public class AutoSelector {
	private ArrayList<DriveCommandLayer> driveAutoList;
	private ArrayList<IntakeCommandLayer> intakeAutoList;
	private HashMap<String,DriveCommandLayer> driveAutoMap;
	private HashMap<String,IntakeCommandLayer> intakeAutoMap;

	public AutoSelector (){
		driveAutoMap=new HashMap<String,DriveCommandLayer>();
		intakeAutoMap =new HashMap<String,IntakeCommandLayer>();
		DriveCommandLayer auto=new DriveCompleteCrossRock();
		driveAutoMap.put(auto.getName(), auto);
		auto=new DriveCompleteCrossCheval();
		driveAutoMap.put(auto.getName(), auto);
		auto=new DriveCompleteCrossPortcullis();
		driveAutoMap.put(auto.getName(), auto);
		
		IntakeCommandLayer autoIntake=new IntakeCompleteCrossCheval();
		intakeAutoMap.put(autoIntake.getName(), autoIntake);
	}
	public IntakeCommandLayer getIntakeAuto(String input){
		IntakeCommandLayer out=intakeAutoMap.get(input);
		if(out==null)
			return new IntakeAutoNothing();
		return out;
	}
	public DriveCommandLayer getDriveAuto(String input){
		DriveCommandLayer out=driveAutoMap.get(input);
		if(out==null)
			return new DriveAutoNothing();
		return out;
	}
}
