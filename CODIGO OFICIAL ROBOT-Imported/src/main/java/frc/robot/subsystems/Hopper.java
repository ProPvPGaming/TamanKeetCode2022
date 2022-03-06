package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.hardware.*;
import frc.robot.Robot;


public class Hopper {
    static TalonSRX HopperTalon = new TalonSRX(7);

public void HopperTest(){
    if (Robot.control.readJoystickButtons(Constantes.LG_B4)){
        HopperTalon.set(ControlMode.PercentOutput, 0.55);
    }
    else if(Robot.control.readJoystickButtons(Constantes.LG_B5)){
        HopperTalon.set(ControlMode.PercentOutput, -0.55);
    }
    else if(Robot.control.readJoystickButtons(Constantes.LG_B1)){
        HopperTalon.set(ControlMode.PercentOutput, -0.55);
        /*try{
            Thread.sleep(750);
        }
        catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }*/

    }
    else if(Robot.control.readPS4Buttons(6)){
HopperTalon.set(ControlMode.PercentOutput, -0.55);
    }
    else{
        HopperTalon.set(ControlMode.PercentOutput,0.0);
    }

    
}
public static void autoHopper(double power){
    HopperTalon.set(ControlMode.PercentOutput, power);

}
}
