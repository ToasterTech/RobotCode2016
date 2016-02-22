package autoselect;

import java.util.ArrayList;
import java.util.HashMap;

import org.usfirst.frc.team5332.robot.drive.auto.DriveAutoHingedRamps;
import org.usfirst.frc.team5332.robot.drive.auto.DriveAutoLowBar;
import org.usfirst.frc.team5332.robot.drive.auto.DriveAutoRoughTerrain;
import org.usfirst.frc.team5332.robot.drive.base.DriveCommandLayer;
import org.usfirst.frc.team5332.robot.intake.base.IntakeCommandLayer;

public class AutoSelector {
	private ArrayList<DriveCommandLayer> driveAutoList;
	private ArrayList<IntakeCommandLayer> intakeAutoList;
	private HashMap<String,DriveCommandLayer> driveAutoMap;
	public AutoSelector (){
//		driveAutoList = new ArrayList<DriveCommandLayer>();
//		intakeAutoList = new ArrayList<IntakeCommandLayer>();
		driveAutoMap=new HashMap<String,DriveCommandLayer>();
//		driveAutoList.add(new DriveAutoLowBar());
//		driveAutoList.add(new DriveAutoRoughTerrain());
//		driveAutoList.add(new DriveAutoHingedRamps());
		DriveCommandLayer auto=new DriveAutoLowBar();
		driveAutoMap.put(auto.getName(), auto);
		auto=new DriveAutoHingedRamps();
		driveAutoMap.put(auto.getName(), auto);
		auto=new DriveAutoRoughTerrain();
		driveAutoMap.put(auto.getName(), auto);

		
	}
	public IntakeCommandLayer getIntakeAuto(String input){
		return null;
	}
	public DriveCommandLayer getDriveAuto(String input){
		return driveAutoMap.get(input);
	}
}
