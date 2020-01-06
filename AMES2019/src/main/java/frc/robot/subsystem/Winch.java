package frc.robot.subsystem;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.*;
import frc.robot.biblioteca.*;

class Winch extends RoboBaseClass {
    public TalonSRX winchMotor;
    private double speed;
    public Winch(int winchMotorPort) {
        super();
        winchMotor = new TalonSRX(winchMotorPort);
    }
    @Override
    public void gatherInfo() {
    }
    @Override
    public void doActions() {
        winchMotor.set(ControlMode.PercentOutput, speed);
    }
    public void setSpeed(double s) {
        speed = s;
    }
}