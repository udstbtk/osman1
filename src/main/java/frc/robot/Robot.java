package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot { 
  private DifferentialDrive m_robotDrive;
  private XboxController m_cont;

  private final PWMSparkMax m_leftMotor = new PWMSparkMax(0);
  private final PWMSparkMax m_rightMotor = new PWMSparkMax(1);

  @Override
  public void robotInit() {
    SmartDashboard.putNumber("sol joystick ", 0);
    SmartDashboard.putNumber("sağ joystick", 0);
    SmartDashboard.putNumber("sol motor output", 0);
    SmartDashboard.putNumber("sağ motor output", 0);
    
    m_cont = new XboxController(0);
    m_rightMotor.setInverted(true);
    m_robotDrive = new DifferentialDrive(m_leftMotor::set, m_rightMotor::set);
  }

  @Override 
  public void teleopPeriodic() {
    m_robotDrive.tankDrive(-m_cont.getLeftY(), -m_cont.getRightY());
 
    SmartDashboard.putNumber("sol joystick ", m_cont.getLeftY());
    SmartDashboard.putNumber("sağ joystick", m_cont.getRightY());

    SmartDashboard.putNumber("sol motor output", m_leftMotor.get());
    SmartDashboard.putNumber("sağ motor output", m_rightMotor.get());
  }
}
