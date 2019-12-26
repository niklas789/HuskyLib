package frc.robot.biblioteca;
import frc.robot.biblioteca.*;
import com.ctre.phoenix.motorcontrol.can.*;
public class HuskyTalon extends Motor {
    public HuskyTalon(int port) {
        super(port);
        TalonsSRX talon = new TalonSRX(port);
    }
    @Overide
    public void set(double speed){
        talon.set(speed);
    }
}
