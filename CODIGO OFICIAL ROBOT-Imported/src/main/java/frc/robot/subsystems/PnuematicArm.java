package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import frc.robot.Robot;
import frc.robot.hardware.Constantes;



public class PnuematicArm {
    Compressor c = new Compressor(0, PneumaticsModuleType.CTREPCM);

    DoubleSolenoid exampleDouble = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 1, 2);
    //DoubleSolenoid testDouble = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 2, 4);
    
    
boolean enabled = c.enabled();
boolean pressureSwitch = c.getPressureSwitchValue();
double current = c.getCurrent();
   public void PSet(){
      c.enableDigital();

exampleDouble.set(Value.kOff);
     exampleDouble.set(Value.kForward); 
      

    //testDouble.set(Value.kForward);
    //testDouble.set(Value.kOff);
    

 
   }


    public void Control(){
        

        if (Robot.control.readJoystickButtons(Constantes.LG_B4)) {
            try{
                Thread.sleep(250);
            }
            catch(InterruptedException ex){
                Thread.currentThread().interrupt();
            }
            exampleDouble.toggle();
         }
        /* if (Robot.control.readJoystickButtons(Constantes.LG_B5)) {
            try{
                Thread.sleep(750);
            }
            catch(InterruptedException ex){
                Thread.currentThread().interrupt();
            }
            testDouble.toggle();
         }*/



    }


}
