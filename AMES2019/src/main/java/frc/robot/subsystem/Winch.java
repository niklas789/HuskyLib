package frc.robot.subsystem;
import frc.robot.biblioteca.roboBaseClass;

class Winch extends roboBaseClass {
    public TalonSRX winchMotor;
    private double speed;
    public Winch(int winchMotorPort) {
        winchMotor = new TalonSRX(winchMotorPort);
        super();
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