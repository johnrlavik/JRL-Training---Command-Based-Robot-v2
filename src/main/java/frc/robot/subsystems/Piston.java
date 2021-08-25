// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Piston extends SubsystemBase {
  DoubleSolenoid piston1;

  /** Creates a new Piston. */
  public Piston() {
    piston1 = new DoubleSolenoid(Constants.PISTON1_FORWARD, Constants.PISTON1_REVERSE);
  }

    @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  
  public void ExtendPiston(){
    piston1.set(DoubleSolenoid.Value.kForward);
  }
  public void RetractPiston(){
    piston1.set(DoubleSolenoid.Value.kReverse);
  }
  public void PistonOff(){
    piston1.set(DoubleSolenoid.Value.kOff);
  }
}
