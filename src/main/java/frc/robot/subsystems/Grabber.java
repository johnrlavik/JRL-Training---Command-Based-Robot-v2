// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Grabber extends SubsystemBase {
  DoubleSolenoid clawPiston;
  DoubleSolenoid armPiston;
  DoubleSolenoid m_piston;

  /** Creates a new piston. */
  public Grabber() {
    clawPiston = new DoubleSolenoid(Constants.PISTON1_PORT_FORWARD, Constants.PISTON1_PORT_REVERSE);
    armPiston = new DoubleSolenoid(Constants.PISTON2_PORT_FORWARD, Constants.PISTON2_PORT_REVERSE);
  }


    @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }


  public void ExtendPiston(DoubleSolenoid p1){
    m_piston = p1;
    m_piston.set(DoubleSolenoid.Value.kForward);
  }
  public void RetractPiston(DoubleSolenoid p1){
    DoubleSolenoid m_piston = p1;
    m_piston.set(DoubleSolenoid.Value.kReverse);
  }
  public void PistonOff(DoubleSolenoid p1){
    DoubleSolenoid m_piston = p1;
    m_piston.set(DoubleSolenoid.Value.kOff);
  }
}
