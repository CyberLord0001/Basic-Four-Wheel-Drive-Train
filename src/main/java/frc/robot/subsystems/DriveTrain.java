package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import frc.robot.RobotMap;

public class DriveTrain {
    private Talon m_left1 = new Talon(RobotMap.kLeftMotorId1);
    private Talon m_left2 = new Talon(RobotMap.kLeftMotorId2);
    private Talon m_right1 = new Talon(RobotMap.kRightMotorId1);
    private Talon m_right2 = new Talon(RobotMap.kRightMotorId2);
    private MotorControllerGroup m_leftMotors = new MotorControllerGroup(m_left1, m_left2);
    private MotorControllerGroup m_rightMotors = new MotorControllerGroup(m_right1, m_right2);
    private DifferentialDrive m_differentialDrive = new DifferentialDrive(m_leftMotors, m_rightMotors);

    public void drive(double forwardsSpeed, double turningSpeed){
        m_differentialDrive.arcadeDrive(turningSpeed, forwardsSpeed);
    }
}
