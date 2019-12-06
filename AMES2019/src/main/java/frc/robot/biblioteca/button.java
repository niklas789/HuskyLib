package frc.robot.biblioteca;
import frc.robot.biblioteca.digitalInput;
import edu.wpi.first.wpilibj.DigitalInput;

public class button extends digitalInput {
    private int m_port;
    private DigitalInput m_b;
    public button(int port) {
        super(false);
        m_port = port;
        m_b = new DigitalInput(port);
    }
    @Override
    public void gatherInfo() {
        setValue(m_b.get());
    };
}