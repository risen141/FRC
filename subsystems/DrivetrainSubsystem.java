package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DrivetrainConstants;

public class DrivetrainSubsystem extends SubsystemBase {

  private final CANSparkMax leftLeader;
  private final CANSparkMax rightLeader;
  private final CANSparkMax leftFollower;
  private final CANSparkMax rightFollower;
  
  private final DifferentialDrive differentialDrive;

  public DrivetrainSubsystem() {

    leftLeader = new CANSparkMax(DrivetrainConstants.kLeftMotorID, DrivetrainConstants.kMotorType);
    rightLeader = new CANSparkMax(DrivetrainConstants.kRightMotorID, DrivetrainConstants.kMotorType);
    leftFollower = new CANSparkMax(DrivetrainConstants.kLeft2MotorID, DrivetrainConstants.kMotorType);
    rightFollower = new CANSparkMax(DrivetrainConstants.kRight2MotorID, DrivetrainConstants.kMotorType);

    leftLeader.restoreFactoryDefaults();
    rightLeader.restoreFactoryDefaults();
    leftFollower.restoreFactoryDefaults();
    rightFollower.restoreFactoryDefaults();

    rightLeader.setInverted(true);
    
    leftFollower.follow(leftLeader, false);
    rightFollower.follow(rightLeader, false);

    leftLeader.burnFlash();
    rightLeader.burnFlash();
    leftFollower.burnFlash();
    rightFollower.burnFlash();

    this.differentialDrive = new DifferentialDrive(leftLeader, rightLeader);
  }

  public void tankDrive(double leftSpeed, double rightSpeed) {
    differentialDrive.tankDrive(leftSpeed, rightSpeed);
  }

  public void arcadeDrive(double speed, double rotation) {
    differentialDrive.arcadeDrive(speed, rotation);
  }

  public void stop() {
    differentialDrive.stopMotor();
  }

  public void driveForward(double speed) {
    differentialDrive.arcadeDrive(speed, 0);
  }

  public void drive(double xSpeed, double rSpeed) {
    differentialDrive.arcadeDrive(xSpeed, rSpeed, DrivetrainConstants.isSquaredInput);
  }

  public void setLeftSpeed(double speed) {
    if (speed > 1) {
      speed = 1;
    } else if (speed < -1) {
      speed = -1;
    }

    leftLeader.set(speed);
  }

  public void setRightSpeed(double speed) {
    if (speed > 1) {
      speed = 1;
    } else if (speed < -1) {
      speed = -1;
    }

    rightLeader.set(speed);
  }

  public void setSpeeds(double speed) {
    setLeftSpeed(speed);
    setRightSpeed(speed);
  }
}
