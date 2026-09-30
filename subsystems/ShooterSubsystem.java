package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConstants;

public class ShooterSubsystem extends SubsystemBase {

  private final CANSparkMax leftMotor;
  private final CANSparkMax rightMotor;
  
  public ShooterSubsystem() {
    leftMotor = new CANSparkMax(ShooterConstants.leftShooterMotorID, ShooterConstants.motorType);
    rightMotor = new CANSparkMax(ShooterConstants.rightShooterMotorID, ShooterConstants.motorType);
  }

  @Override
  public void periodic() {}

  public void setSpeed(double speed) {
    if (speed > 1) {
      speed = 1;
    } else if (speed < -1) {
      speed = -1;
    }

    leftMotor.set(speed);
    rightMotor.set(speed);
  }
}