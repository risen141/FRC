package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.ShooterConstants;
import frc.robot.subsystems.ShooterSubsystem;

public class TimedShootCommand extends Command {

  private final ShooterSubsystem shooterSubsystem;
  private final double executionTime;
  private double startTime;

  public TimedShootCommand(ShooterSubsystem shooterSubsystem, double shotDuration) {
    this.shooterSubsystem = shooterSubsystem;
    this.executionTime = shotDuration;

    this.addRequirements(shooterSubsystem);
  }

  @Override
  public void initialize() {
    this.startTime = Timer.getFPGATimestamp();
    this.shooterSubsystem.setSpeed(0);
  }

  @Override
  public void execute() {
    this.shooterSubsystem.setSpeed(ShooterConstants.shotSpeed);
  }

  @Override
  public void end(boolean interrupted) {
    this.shooterSubsystem.setSpeed(0);
  }

  @Override
  public boolean isFinished() {
    double elapsedTime = Timer.getFPGATimestamp() - this.startTime;
    return elapsedTime >= this.executionTime;
  }
}