package frc.robot.biblioteca;
import frc.robot.biblioteca.*;
class Motor extends AnalogOutput {
    private Motor m_following;
    private double m_speed;
    private double m_realSpeed;
    public Motor() {
        super(-1, 1);
    }
    public void set(double value) {
        m_Speed = value;
    }
    public void follow(Motor motorFollow) {
        m_following = motorFollow;
    }
    public double getTargetSpeed(){
        return m_speed;
    }
    public double getRealSpeed(){
        return m_realSpeed;
    }
    public void gatherInfo(){
           
    }
}
