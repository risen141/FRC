package frc.robot.commands.teleop;

import java.util.function.Supplier;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.DrivetrainConstants;
import frc.robot.subsystems.DrivetrainSubsystem;

public class TeleopDriveCommand extends Command {

  private final Supplier<Double> xFunction, rFunction;
  private final DrivetrainSubsystem drivetrainSubsystem;

  public TeleopDriveCommand(
      DrivetrainSubsystem drivetrainSubsystem,
      Supplier<Double> xFunction,
      Supplier<Double> rFunction
  ) {
    this.xFunction = xFunction;
    this.rFunction = rFunction;
    this.drivetrainSubsystem = drivetrainSubsystem;

    addRequirements(drivetrainSubsystem);
  }

  @Override
  public void initialize() {
    drivetrainSubsystem.setSpeeds(0);
  }

  @Override
  public void execute() {
    double xSpeed = xFunction.get() * DrivetrainConstants.maxForwardSpeed;
    double rSpeed = rFunction.get() * DrivetrainConstants.maxRotationalSpeed;

    drivetrainSubsystem.drive(xSpeed, rSpeed);
  }

  @Override
  public void end(boolean interrupted) {
    drivetrainSubsystem.setSpeeds(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
