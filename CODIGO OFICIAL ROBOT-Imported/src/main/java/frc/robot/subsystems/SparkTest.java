package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.Robot;
// import frc.robot.hardware.Constantes;

public class SparkTest {
        CANSparkMax Hook = new CANSparkMax(16, MotorType.kBrushless);
        TalonSRX Climb = new TalonSRX(5);
        public void climb(){
            
            if(Robot.control.readJoystickDPad() == 0){
                Climb.set(ControlMode.PercentOutput, 0.55);
            }
            else{
                Climb.set(ControlMode.PercentOutput, 0);
            }
            if(Robot.control.readJoystickDPad() == 90){
                Hook.set(0.6);
            }
            else if (Robot.control.readJoystickDPad() == 270){
                Hook.set(-0.6);
            }
            else{
                Hook.set(0);
            }
        }
}