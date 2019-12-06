package frc.robot.subsystem;
import frc.robot.biblioteca.*;

class Winch extends roboBaseClass {
    public talonSRX winchMotor;
    private double speed;
    public Winch(int winchMotorPort) {
        super();
        winchMotor = new talonSRX(winchMotorPort);
    }
    @Override
    public void gatherInfo() {
    }
    @Override
    public void doActions() {
        winchMotor.set(speed);
    }
    public void setSpeed(double s) {
        speed = s;
    }
}