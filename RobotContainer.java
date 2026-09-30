package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants.DrivetrainConstants;
import frc.robot.Constants.OperatorConstants;
import frc.robot.Constants.ShooterConstants;
import frc.robot.commands.auto.TimedShootCommand;
import frc.robot.commands.auto.TimedMoveForwardCommand;
import frc.robot.commands.teleop.TeleopDriveCommand;
import frc.robot.commands.teleop.TeleopShootCommand;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class RobotContainer {
  
  private final CommandXboxController controller;

  private final Trigger xTrigger;
  private final Trigger aTrigger;
  private final Trigger bTrigger;
  private final Trigger yTrigger;

  private final DrivetrainSubsystem drivetrainSubsystem;
  private final ShooterSubsystem shooterSubsystem;

  private final TeleopDriveCommand teleopDriveCommand;
  private final TeleopShootCommand teleopShootCommand;

  private final TimedShootCommand autoShootCommand;
  private final TimedMoveForwardCommand autoMoveForwardCommand;

  private final TimedShootCommand shootCommand1;
  private final TimedShootCommand shootCommand2;
  private final TimedShootCommand shootCommand3;

  public RobotContainer() {
    this.controller = new CommandXboxController(OperatorConstants.driverControllerID);

    this.xTrigger = controller.x();
    this.aTrigger = controller.a();
    this.bTrigger = controller.b();
    this.yTrigger = controller.y();

    this.drivetrainSubsystem = new DrivetrainSubsystem();
    this.shooterSubsystem = new ShooterSubsystem();

    this.teleopDriveCommand = new TeleopDriveCommand(this.drivetrainSubsystem, this.controller::getLeftY, this.controller::getRightX);
    this.teleopShootCommand = new TeleopShootCommand(this.shooterSubsystem);

    this.autoShootCommand = new TimedShootCommand(this.shooterSubsystem, ShooterConstants.autoShootDuration);
    this.autoMoveForwardCommand = new TimedMoveForwardCommand(this.drivetrainSubsystem, DrivetrainConstants.autoMoveDuration);
    
    this.shootCommand1 = new TimedShootCommand(this.shooterSubsystem, 2);
    this.shootCommand2 = new TimedShootCommand(this.shooterSubsystem, 5);
    this.shootCommand3 = new TimedShootCommand(this.shooterSubsystem, 8);
    
    this.configureBindings();
  }

  private void configureBindings() {
    this.xTrigger.whileTrue(this.teleopShootCommand);

    this.aTrigger.onTrue(this.shootCommand1);
    this.bTrigger.onTrue(this.shootCommand2);
    this.yTrigger.onTrue(this.shootCommand3);

    this.drivetrainSubsystem.setDefaultCommand(this.teleopDriveCommand);
  }

  public Command getAutonomousCommand() {
    return Commands.sequence(
      this.autoShootCommand,
      this.autoMoveForwardCommand
    );
  }
}