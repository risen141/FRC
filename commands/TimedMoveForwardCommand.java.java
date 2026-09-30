package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.DrivetrainConstants;
import frc.robot.subsystems.DrivetrainSubsystem;

public class TimedMoveForwardCommand extends Command {
  DrivetrainSubsystem drivetrainSubsystem;

  double executionTime;
  double startTime;
  double currentTime;
  double elapsedTime;

  public TimedMoveForwardCommand(DrivetrainSubsystem drivetrainSubsystem, double moveDuration) {
    this.drivetrainSubsystem = drivetrainSubsystem;
    this.executionTime = moveDuration;

    this.addRequirements(drivetrainSubsystem);
  }

  @Override
  public void initialize() {
    this.drivetrainSubsystem.setSpeeds(0);
    this.startTime = Timer.getFPGATimestamp();
  }

  @Override
  public void execute() {
    this.drivetrainSubsystem.setSpeeds(0.5);
    this.currentTime = Timer.getFPGATimestamp();
    this.elapsedTime = this.currentTime - this.startTime;
  }

  @Override
  public void end(boolean interrupted) {
    this.drivetrainSubsystem.setSpeeds(0);
  }

  @Override
  public boolean isFinished() {
    if (this.elapsedTime > this.executionTime ){
      return true;
    }
    else {
      return false;
    }
  }
}