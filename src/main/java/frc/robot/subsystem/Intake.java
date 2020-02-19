package frc.robot.subsystem;

import frc.robot.biblioteca.RoboBaseClass;
import edu.wpi.first.wpilibj.Solenoid;

import frc.robot.biblioteca.Motor;
//use HuskyVictor, Solenoid, and LightSensor
public class Intake extends RoboBaseClass {
    private int totalIn;
    private Motor intakeMotor;
    private Solenoid piston;
    public Intake(int channel)
    {
          //instantiate motor, solenoid, and lightsensor
           super();
           intakeMotor = new Motor();
           piston = new Solenoid(channel);
    }
    public void doActions() 
    {
        piston.activatePiston();
    }
    public void intake(double speed) 
    {
      intakeMotor.set(speed);
    }
    public void turnOnIntakeMotor(boolean MotorOn)
    {
        if(MotorOn == false)
        {
            MotorOn = true;
        }
    }
    public void activatePiston(boolean up) 
    {
        if(up == false)
        {
            up = true;
        }
    }
    public int getTotalIn() 
    {
        return totalIn;
    }
}
