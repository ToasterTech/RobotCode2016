package org.usfirst.frc.team5332.robot;

import edu.wpi.first.wpilibj.Joystick;

public class Gamepad {
	
	private Joystick js;
	
	public Gamepad (int index){
		js = new Joystick(index);
	}
	
	public double getYLeft(){
		return js.getRawAxis(1);
	}
	
	public double getYRight(){
		return js.getRawAxis(2);
	}
	
	public boolean getButton(int type){
		return(true);
	}
}
