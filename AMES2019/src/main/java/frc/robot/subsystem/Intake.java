package frc.robot.subsystem;
import frc.robot.biblioteca.*;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

class Intake extends RoboBaseClass {
    public VictorSPX m_motor;
    private double m_speed;
    public Intake(int motorPort) {
        super();
        m_motor = new VictorSPX(motorPort);
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
        m_motor.set(ControlMode.PercentOutput, m_speed);
    }
}