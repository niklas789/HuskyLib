package frc.robot.subsystem;
import frc.robot.biblioteca.*;

class Intake extends roboBaseClass {
    public victorSPX m_motor;
    private double m_speed;
    public Intake(int motorPort) {
        super();
        m_motor = new victorSPX(motorPort);
        m_speed = 0;
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