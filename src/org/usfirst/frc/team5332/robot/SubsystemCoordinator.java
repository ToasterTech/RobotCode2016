package org.usfirst.frc.team5332.robot;

public class SubsystemCoordinator {
	private static SubsystemCoordinator coordinator=null;
	public static  SubsystemCoordinator get(){
		if(coordinator==null){
			coordinator=new SubsystemCoordinator();
		}
		return coordinator;
	}
	 
}
