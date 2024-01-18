// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.DriveTrain;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private DriveTrain m_driveTrain = new DriveTrain();
  private XboxController m_controller = new XboxController(RobotMap.kControllerPort);
  private Arm m_armMotor = new Arm();
  private Timer m_timer = new Timer();
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {}

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {
    m_timer.start();
    m_timer.reset();
  }

  @Override
  public void autonomousPeriodic() {
    if(m_timer.get()<3){
      m_driveTrain.drive(RobotMap.kSpeedAxisAuto, 0);
    }
    else if(m_timer.get()<6){
      m_driveTrain.drive(0, RobotMap.kSpinAxisAuto);
    }
    else if(m_timer.get()<9){
      m_driveTrain.drive(RobotMap.kSpeedAxisAuto, 0);
    }
    else{
      m_driveTrain.drive(0, 0);
    }
  }

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {
    m_driveTrain.drive(RobotMap.kSpeed*m_controller.getRawAxis(RobotMap.kSpeedAxis), -RobotMap.kSpeed*m_controller.getRawAxis(RobotMap.kSpinAxis));
    if(m_controller.getRawButton(RobotMap.kArmForwardsButton)){
      m_armMotor.spinForwards();
    }
    else if(m_controller.getRawButton(RobotMap.kArmBackwardsButton)){
      m_armMotor.spinBackwards();
    }
    else{
      m_armMotor.stop();
    }
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
