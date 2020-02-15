package frc.robot.subsystem;

import frc.robot.biblioteca.RoboBaseClass;
import edu.wpi.first.wpilibj.Solenoid;
import frc.robot.biblioteca.HuskyVictor;
import frc.robot.biblioteca.LightSensor;
import frc.robot.biblioteca.Motor;;
//use HuskyVictor, Solenoid, and LightSensor
public class Intake extends RoboBaseClass {
    private int totalIn;
    private boolean up;
    public Intake() {
          //instantiate motor, solenoid, and lightsensor
          //Hopefully makes sense. hopeful it's not completely bad
           super();
           //hopefully something like this piston = new Solenoid();  
           //hopefully something like Motor intake = new HuskyVictor();
    }
    public void gatherInfo() {
        //check if the light sensor senses things
        //add to total in

    }
    public void doActions() {
    }
    public void intake(double speed) {
      
        intakeMotor.set(speed);
    }
    public void activatePiston(boolean up) {
        piston.set(up);
    }
    public int getTotalIn() {
        return totalIn;
    }
}
