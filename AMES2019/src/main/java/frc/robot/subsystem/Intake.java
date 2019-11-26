package frc.robot.subsystem;
import frc.robot.biblioteca.roboBaseClass;

class Intake extends roboBaseClass {
    public VictorSPX m_motor;
    private double m_speed;
    public Drive(int motorPort) {
        m_motor = new VictorSPX(motorPort);
        speed = 0;
        super();
    }
    @Override
    public void gatherInfo() {
        
    }
    public void setSpeed(double speed) {
        m_speed = speed;
    }
    @Override
    public void doActions() {
        m_motor.set(m_speed);
    }
}