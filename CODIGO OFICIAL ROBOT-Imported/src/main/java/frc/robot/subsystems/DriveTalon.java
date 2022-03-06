package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.math.filter.SlewRateLimiter;
import frc.robot.hardware.*;
import frc.robot.Robot;



public class DriveTalon {
double Xposition;
double Ypostition;

    TalonSRX Tdr1 = new TalonSRX(9);
    TalonSRX Tdr2 = new TalonSRX(11);
    TalonSRX Tdl1 = new TalonSRX(12);
    TalonSRX Tdl2 = new TalonSRX(13);

    SlewRateLimiter LeftJoystick;
    SlewRateLimiter RightJoystick;

    

    public void DriveTrainTank(){

        LeftJoystick = new SlewRateLimiter(1.75);
        RightJoystick = new SlewRateLimiter(1.75);
double drive = Robot.control.readPS4Axis(Constantes.XB_LJ_Y);
double turn = Robot.control.readPS4Axis(Constantes.XB_RJ_X);


        double leftDrive = drive - turn;
        double rightDrive = drive + turn;

        Tdr1.set(ControlMode.PercentOutput,  rightDrive);
        Tdr2.set(ControlMode.PercentOutput,  rightDrive);
        Tdl1.set(ControlMode.PercentOutput, - leftDrive);
        Tdl2.set(ControlMode.PercentOutput, - leftDrive);
    }

}
