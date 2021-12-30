// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.AnalogInput;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
// PWM ports for build team
	public static final int LEFT_FRONT = 0;
	public static final int LEFT_BACK = 1;
	public static final int RIGHT_FRONT = 2;
	public static final int RIGHT_BACK = 3;
	public static final int SHOOTER = 4; //Shooter motor

// Axes for controller stick    
	public static final int XBOX_LEFT_Y_AXIS = 1;
    public static final int XBOX_LEFT_X_AXIS = 0;
    
    
	public static final double DRIVETRAINSPEED = 0.7;
	public static final double DRIVE_FORWARD_TIME = 2.0;
	public static final double AUTONOMOUS_SPEED = 0.4;

	//USE ONE OR THE OTHER OF FOLLOWING
	//public static final int JOYSTICK1_NUMBER = 1;
	public static final int JOYSTICK_NUMBER = 0;
	public static final int SHOOTER_BUTTON_NUMBER = 2;
	public static final int PISTON_CLAW_BUTTON_NUMBER = 3;
	public static final int PISTON_ARM_BUTTON_NUMBER = 7;

	public static final double SHOOTER_SPEED = 0.5;

	//PCM port for piston
	public static final int PISTON1_PORT_FORWARD = 0;
	public static final int PISTON1_PORT_REVERSE = 1;
	public static final int PISTON2_PORT_FORWARD = 2;
	public static final int PISTON2_PORT_REVERSE = 3;

	//gyro
	public static final int GYRO_PORT_NUMBER = 0;	//must be either 0 or 1
	private static final double ANGLE_SET_POINT = 0.0;	//may want to move to DriveTrain and make it changeable (not final)
	private static final double PROPORTIONAL_TURNING_CONSTANT = 0.005; // propotional turning constant

  // gyro calibration constant, may need to be adjusted;
  // gyro value of 360 is set to correspond to one full revolution
  private static final double VOLTS_PER_DEGREE_PER_SECOND = 0.0128;


	


}
