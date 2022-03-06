package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.hardware.*;
import frc.robot.Robot;
public class Turret {
    static TalonSRX turretTalon = new TalonSRX(6);
    public void turret(){
        if (Robot.control.readJoystickButtons(Constantes.LG_B2)){
        
            turretTalon.set(ControlMode.PercentOutput, -1);  
        }
        else{
            turretTalon.set(ControlMode.PercentOutput, 0);
        }

    }

    public static void autoshoot(double power){
turretTalon.set(ControlMode.PercentOutput, power);
    }
    
    
   
}
