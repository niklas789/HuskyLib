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
    private Motor m_intakeMotor;
    private Solenoid m_piston;
    public Intake(Motor intakeMotor, Solenoid piston){
          //instantiate motor, solenoid, and lightsensor
          //Hopefully makes sense. hopeful it's not completely bad
           super();
           m_intakeMotor = new VictorSPX();
           m_piston = new Solenoid();
    }
    public void gatherInfo() {
        //check if the light sensor senses things
        //add to total in

    }
    public void doActions() {
    }
    public void intake(double speed) {
      m_intakeMotor.set(speed);
    }
    public void activatePiston(boolean up) {
        m_piston.set(up);
    }
    public int getTotalIn() {
        return totalIn;
    }
}
