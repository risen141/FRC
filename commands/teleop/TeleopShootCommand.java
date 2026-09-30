package frc.robot.commands.teleop;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.ShooterConstants;
import frc.robot.subsystems.ShooterSubsystem;

public class TeleopShootCommand extends Command {
  
  private final ShooterSubsystem shooterSubsystem;

  public TeleopShootCommand(ShooterSubsystem shooterSubsystem) {
    this.shooterSubsystem = shooterSubsystem;
    this.addRequirements(shooterSubsystem);
  }

  @Override
  public void initialize() {
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
    return false;
  }
}