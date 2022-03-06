/*----------------------------------------------------------------------------*/
/* Tamán Keet 3933 PrepaTec CSF                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.hardware.Controles;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.Timer;

public class Robot extends TimedRobot {



  public static Controles control;
  public static DriveTalon dTrain;
  public static Intake intake;
  public static Turret turret;
  public static Cameraselect cameras;
  public static Hopper hopper;
 // public static PnuematicArm Pne;
  public static Bishop bishop;
  public static SparkTest spark;
  public static SparkDrive SparkDT;
  public static DriveTalon talonDT;

  @Override// :)
  public void robotInit() {
    dTrain = new DriveTalon();
  //Pne = new PnuematicArm();
    control = new Controles();
    intake = new Intake();
    turret = new Turret();
   cameras = new Cameraselect();
   hopper = new Hopper();
   spark = new SparkTest();
   SparkDT = new SparkDrive();
   talonDT = new DriveTalon();

  



   cameras.CameraSetup();
   //Pne.PSet();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    
  }


   /*
    //  ______           __                                                                 
    // /\  _  \         /\ \__                                                              
    // \ \ \L\ \  __  __\ \ ,_\   ___     ___     ___     ___ ___     ___   __  __    ____  
    //  \ \  __ \/\ \/\ \\ \ \/  / __`\ /' _ `\  / __`\ /' __` __`\  / __`\/\ \/\ \  /',__\ 
    //   \ \ \/\ \ \ \_\ \\ \ \_/\ \L\ \/\ \/\ \/\ \L\ \/\ \/\ \/\ \/\ \L\ \ \ \_\ \/\__, `\
    //    \ \_\ \_\ \____/ \ \__\ \____/\ \_\ \_\ \____/\ \_\ \_\ \_\ \____/\ \____/\/\____/
    //     \/_/\/_/\/___/   \/__/\/___/  \/_/\/_/\/___/  \/_/\/_/\/_/\/___/  \/___/  \/___/                                                                                    
   */
  @Override
  public void autonomousInit() {

  }

  @Override

  public void autonomousPeriodic() {
double current = Timer.getFPGATimestamp();
if(current < 2){
  SparkDT.DriveL1.set(-0.5);
  SparkDT.DriveL2.set(0.5);
  SparkDT.DriveR1.set(0.5);
  SparkDT.DriveR2.set(0.5);
}
else{
  SparkDT.DriveL1.set(0);
  SparkDT.DriveL2.set(0);
  SparkDT.DriveR1.set(0);
  SparkDT.DriveR2.set(0);
}
  }

  
  //  ______   ______     __         ______     ______     ______  
  // /\__  _\ /\  ___\   /\ \       /\  ___\   /\  __ \   /\  == \ 
  // \/_/\ \/ \ \  __\   \ \ \____  \ \  __\   \ \ \/\ \  \ \  _-/ 
  //    \ \_\  \ \_____\  \ \_____\  \ \_____\  \ \_____\  \ \_\   
  //     \/_/   \/_____/   \/_____/   \/_____/   \/_____/   \/_/   
  
  @Override
  public void teleopPeriodic() {
    //Aqui el codigo donde vamos a poner toda la estructura del robot
    intake.IntakeTest();
    turret.turret();
    hopper.HopperTest();
    spark.climb();
    SparkDT.drive();
    //Pne.Control();
talonDT.DriveTrainTank();
  

  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
