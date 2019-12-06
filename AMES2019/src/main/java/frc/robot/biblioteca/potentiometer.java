package frc.robot.biblioteca;
import frc.robot.biblioteca.analogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;

public class potentiometer extends analogInput {
    private int m_port;
    private AnalogPotentiometer m_p;
    public potentiometer(int port) {
        super(-1, 1);
        m_port = port;
        m_p = new AnalogPotentiometer(port);
    }
    @Override
    public void gatherInfo() {
        setValue(m_p.get());
    };
}