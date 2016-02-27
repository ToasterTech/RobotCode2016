package org.usfirst.frc.team5332.robot;

import edu.wpi.first.wpilibj.Joystick;

public class Gamepad {
	
	private Joystick js;
	
	public Gamepad (int index){
		js = new Joystick(index);
	}
	
	public double getYLeft(){
		return -js.getRawAxis(1);
	}
	
	public double getYRight(){
		return -js.getRawAxis(5);
	}
	public boolean getTriggerLeft(){
		return js.getRawAxis(2)>.3;
	}
	public boolean getTriggerRight(){
		return js.getRawAxis(3)>.3;
	}

	public boolean getButton(int type){
		return(js.getRawButton(type));
	}
	
}
