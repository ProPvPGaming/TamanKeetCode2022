package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Timer;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.Robot;
import frc.robot.hardware.Constantes;

public class SparkDrive {
    public CANSparkMax DriveR1 = new CANSparkMax(1, MotorType.kBrushless);
    public CANSparkMax DriveR2 = new CANSparkMax(2, MotorType.kBrushless);
    public CANSparkMax DriveL1 = new CANSparkMax(3, MotorType.kBrushless);
    public CANSparkMax DriveL2 = new CANSparkMax(4, MotorType.kBrushless);

    RelativeEncoder EncoderL = DriveL1.getEncoder();
    RelativeEncoder EncoderR = DriveR1.getEncoder();

    public double treshold = 0;
    public Timer timer;

    // bot position
    double positionX = 0;
    double positionY = 0;
    double angle = 0;

    // bot measurements
    double wheelRadius = 0.075;
    double width = 0.61;
    double gearRatio = 5.95;

    // Utils
    boolean switcher = true;
    double lastTime = 0;
    double startEncoderL = EncoderL.getPosition();
    double startEncoderR = - EncoderR.getPosition();

    public void encoderReset(){
        DriveL1.restoreFactoryDefaults();
        DriveR1.restoreFactoryDefaults();
    }

    public void drive(){

        if (Robot.control.readPS4Buttons(Constantes.XB_B_A) &&
            Robot.control.readPS4Buttons(Constantes.XB_B_B) ) {
            switcher = !switcher;
        }

        if (switcher){
            test();
        }
        else {
            UlisesDrive();
        }

        if(Robot.control.readPS4Buttons(Constantes.XB_B_A)){
            DriveL1.set(0);
            DriveL2.set(0);
            DriveR1.set(0);
            DriveR2.set(0);
        }
    }

    public void test(){
       
        double drive =  Robot.control.readPS4Axis(Constantes.XB_LJ_Y);
        double turn  =  Robot.control.readPS4Axis(2) * 0.75;

        double rightPower = drive + turn;
        double leftPower  = drive - turn;

        DriveL1.set(-leftPower);
        DriveL2.set(leftPower);
        DriveR1.set(rightPower);
        DriveR2.set(rightPower);   

        double currentTime = Timer.getFPGATimestamp();

        lastTime = currentTime;

        // double left = EncoderL.getVelocity() / gearRatio * wheelRadius * 2 * 3.14159;
        // double right = EncoderR.getVelocity() / gearRatio * wheelRadius * 2 * 3.14159;
        double left = (EncoderL.getPosition() - startEncoderL) / gearRatio * wheelRadius * 2 * Math.PI;
        double right = (- EncoderR.getPosition() - startEncoderR) / gearRatio * wheelRadius * 2 * Math.PI;


        double deltaX = ((right + left)/2) * Math.cos(angle);
        double deltaY = ((right + left)/2) * Math.sin(angle);

        angle = (right + left) / (right - left) * width / 2;

        positionX = deltaX + positionX;
        positionY = deltaY + positionY;

        // System.out.println("X: " + positionX + " - Y: " + positionY + " - A: " + angle);
        System.out.println("leftL: " + left + "  rightR: " + right + "  angle: " + angle);
    }

    public void UlisesDrive(){
        
        double sensitivity = 0.6;

        DriveL1.set(-Sensitivity( Robot.control.readPS4Axis(Constantes.XB_LJ_Y), sensitivity));
        DriveL2.set(Sensitivity( Robot.control.readPS4Axis(Constantes.XB_LJ_Y), sensitivity));
        DriveR1.set(Sensitivity( Robot.control.readPS4Axis(Constantes.XB_RJ_Y), sensitivity));
        DriveR2.set(Sensitivity( Robot.control.readPS4Axis(Constantes.XB_RJ_Y), sensitivity));   
    }
    
    public double Sensitivity(double X, double a){
       double Power = a*(X*X*X)+(1-a)*X;

       return Power;
    }

    public void autodrive(double power){
        DriveL1.set(-power);
        DriveL2.set(power);
        DriveR1.set(power);
        DriveR2.set(power);
    }
}

