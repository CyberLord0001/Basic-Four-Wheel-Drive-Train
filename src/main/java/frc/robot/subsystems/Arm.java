package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import frc.robot.RobotMap;

public class Arm {
    private Talon m_armMotor = new Talon(RobotMap.kArmMotorId);
    public void spinForwards(){
        m_armMotor.set(RobotMap.kArmSpeed);
    }
    public void spinBackwards(){
        m_armMotor.set(-RobotMap.kArmSpeed);
    }
    public void stop(){
        m_armMotor.set(0);
    }
}
