// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.DriveForwardTimed;
import frc.robot.commands.DriveWithJoysticks;
import frc.robot.commands.ExtendPiston;
import frc.robot.commands.RetractPiston;
import frc.robot.commands.ShootBall;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  //Drivetrain declare
  private final DriveTrain driveTrain;
  private final DriveWithJoysticks driveWithJoysticks;
  private final DriveForwardTimed driveForwardTimed;
  public static Joystick driverOldStyleJoystick;
  //public static XboxController driverJoystick;
  //Shooter declare
  private final Shooter shooter;
  private final ShootBall shootBall;
  //Pneumatics declare
  private final DoubleSolenoid clawPiston;
  private final DoubleSolenoid armPiston;
  private final ExtendPiston extendClawPiston;
  private final RetractPiston retractClawPiston;
  private final ExtendPiston extendArmPiston;
  private final RetractPiston retractArmPiston;
  

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    driveTrain = new DriveTrain();
    driveWithJoysticks = new DriveWithJoysticks(driveTrain);
    driveWithJoysticks.addRequirements(driveTrain);
    driveTrain.setDefaultCommand(driveWithJoysticks);

    driveForwardTimed = new DriveForwardTimed(driveTrain);
    driveForwardTimed.addRequirements(driveTrain);

    driverOldStyleJoystick = new Joystick(Constants.JOYSTICK_NUMBER);
    //Shooter
    shooter = new Shooter();
    shootBall = new ShootBall(shooter);
    shootBall.addRequirements(shooter);
    //Grabber
    clawPiston = new DoubleSolenoid(Constants.PISTON1_PORT_FORWARD, Constants.PISTON1_PORT_REVERSE);
    armPiston = new DoubleSolenoid(Constants.PISTON2_PORT_FORWARD, Constants.PISTON2_PORT_REVERSE);
    extendClawPiston = new ExtendPiston(clawPiston);
    retractClawPiston = new RetractPiston(clawPiston);
    extendArmPiston = new ExtendPiston(armPiston);
    retractArmPiston = new RetractPiston(armPiston);

    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    JoystickButton shootButton = new JoystickButton(driverOldStyleJoystick, Constants.SHOOTER_BUTTON_NUMBER);
    shootButton.whileHeld(new ShootBall(shooter));

    JoystickButton pistonClawButton = new JoystickButton(driverOldStyleJoystick, Constants.PISTON_CLAW_BUTTON_NUMBER);
    pistonClawButton.whileHeld(extendClawPiston);
    pistonClawButton.whenReleased(retractClawPiston);

    JoystickButton pistonArmButton = new JoystickButton(driverOldStyleJoystick, Constants.PISTON_ARM_BUTTON_NUMBER);
    pistonArmButton.whileHeld(extendArmPiston);
    pistonArmButton.whenReleased(retractArmPiston);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return driveForwardTimed;
  }
}
