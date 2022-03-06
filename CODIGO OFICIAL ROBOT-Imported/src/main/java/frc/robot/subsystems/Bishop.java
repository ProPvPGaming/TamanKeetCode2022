package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.Timer;


public class Bishop {

public SerialPort arduino;
public Timer timer;
public double Xpos;
public double Ypos;

    public void collect(){
        try {
            arduino = new SerialPort(9600, SerialPort.Port.kUSB);
            System.out.println("Connected on kUSB!");
          } catch (Exception e) {
            System.out.println("Failed to connect on kUSB, trying kUSB 1");
      
            try {
              arduino = new SerialPort(9600, SerialPort.Port.kUSB1);
              System.out.println("Connected on kUSB1!");
            } catch (Exception e1) {
              System.out.println("Failed to connect on kUSB1, trying kUSB 2");
      
              try {
                arduino = new SerialPort(9600, SerialPort.Port.kUSB2);
                System.out.println("Connected on kUSB2!");
              } catch (Exception e2) {
                System.out.println("Failed to connect on kUSB2, all connection attempts failed!");
              }
            }
          }
timer = new Timer();
timer.start();

    }
    
    public void communicate(){
        if(timer.get() > 5) {
            //Output that we wrote to the arduino, write our "trigger byte"
            //to the arduino and reset the timer for next time
            System.out.println("Wrote to Arduino");
            arduino.write(new byte[] {0x12}, 1);
            timer.reset();
          }

          if(arduino.getBytesReceived() > 0) {
            System.out.print(arduino.readString());
          }

    }

    public void calculate(){
        

    }
}
