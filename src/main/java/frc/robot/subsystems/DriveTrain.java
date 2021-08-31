// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */
  // Declare variables
  Spark leftFront;
  Spark leftBack;
  Spark rightFront;
  Spark rightBack;
  SpeedControllerGroup leftMotors;
  SpeedControllerGroup rightMotors;
  DifferentialDrive drive;
  Encoder m_leftEncoder;
  Encoder m_rightEncoder;

  //private final m_leftEncoder m_encoder = new Encoder(1, 2, false, CounterBase.EncodingType.k4X);

//Class constructor(s)
  public DriveTrain() {
    leftFront = new Spark(Constants.LEFT_FRONT);
    leftFront.setInverted(true);
    leftBack = new Spark(Constants.LEFT_BACK);
    leftBack.setInverted(true);
    rightFront = new Spark(Constants.RIGHT_FRONT);
    rightFront.setInverted(true);
    rightBack = new Spark(Constants.RIGHT_BACK);
    rightBack.setInverted(true);

    leftMotors = new SpeedControllerGroup(leftFront, leftBack);
    rightMotors = new SpeedControllerGroup(rightFront, rightBack);
    drive = new DifferentialDrive(leftMotors, rightMotors);

    m_leftEncoder = new Encoder(0, 1, false, CounterBase.EncodingType.k4X);
    m_rightEncoder = new Encoder(2, 3, false, CounterBase.EncodingType.k4X);
    m_leftEncoder.setDistancePerPulse(1.0 / 360.0 * 2.0 * Math.PI * 1.5);
    m_rightEncoder.setDistancePerPulse(1.0 / 360.0 * 2.0 * Math.PI * 1.5);
    m_leftEncoder.setMinRate(1.0);
    m_rightEncoder.setMinRate(1.0);

  }
@Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void driveWithJoysticks(Joystick controller, double speed){
    drive.arcadeDrive(controller.getRawAxis(Constants.XBOX_LEFT_Y_AXIS)*speed, controller.getRawAxis(Constants.XBOX_LEFT_X_AXIS)*speed);
    SmartDashboard.putNumber("Left Encoder Distance", m_leftEncoder.getDistance());
    SmartDashboard.putNumber("Left Encoder Rate", m_leftEncoder.getRate());
    SmartDashboard.putNumber("Right Encoder Distance", m_rightEncoder.getDistance());
    SmartDashboard.putNumber("Right Encoder Rate", m_rightEncoder.getRate());
  }

  public void driveForward(double speed){
    drive.tankDrive(speed, speed);
    SmartDashboard.putNumber("Left Encoder Distance", m_leftEncoder.getDistance());
    SmartDashboard.putNumber("Left Encoder Rate", m_leftEncoder.getRate());
    SmartDashboard.putNumber("Right Encoder Distance", m_rightEncoder.getDistance());
    SmartDashboard.putNumber("Right Encoder Rate", m_rightEncoder.getRate());
  }

  public void stop(){
    drive.stopMotor();
  }
}
