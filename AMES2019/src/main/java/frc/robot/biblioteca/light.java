package frc.robot.biblioteca;
import frc.robot.biblioteca.digitalOutput;
import edu.wpi.first.wpilibj.DigitalOutput;

public class light extends digitalOutput {
    private int m_port;
    private DigitalOutput m_l;
    public light(int port) {
        super(false);
        m_port = port;
        m_l = new DigitalOutput(port);
    }
    @Override
    public void doActions() {
        m_l.set(getValue());
    }
}