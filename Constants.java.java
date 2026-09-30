package frc.robot;

import com.revrobotics.CANSparkLowLevel.MotorType;

public class Constants {

    public static final class DrivetrainConstants {
        public static final MotorType motorType = MotorType.kBrushed; 

        public static final int leftLeader = 1;
        public static final int leftFollower = 2;
        public static final int rightLeader = 3;
        public static final int rightFollower = 4;

        public static final boolean invertLeftMotor = false;
        public static final boolean invertRightMotor = true;

        public static final double maxForwardSpeed = 0.8;
        public static final double maxRotationalSpeed = 0.7;

        public static final boolean isSquaredInput = true;

        public static final double autoSpeed = 0.5;
        public static final double autoMoveDuration = 2.0;
    }
    
    public static final class ShooterConstants {
        public static final MotorType motorType = MotorType.kBrushless; 

        public static final int leftShooterMotorID = 5;
        public static final int rightShooterMotorID = 6;

        public static final double shotSpeed = 0.85;
        public static final double autoShootDuration = 1.5;
    }

    public static final class IntakeConstants {
        public static final MotorType motorType = MotorType.kBrushed;

        public static final int intakeMotorID = 7;

        public static final double intakeSpeed = 0.6;
        public static final double outtakeSpeed = -0.6;
    }

    public static final class OperatorConstants {
        public static final int driverControllerID = 0;
        public static final int operatorControllerID = 1;
    }
}