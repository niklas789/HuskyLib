package frc.robot.biblioteca;
import frc.robot.biblioteca.DigitalInput;
import edu.wpi.first.wpilibj.DigitalInput;

public class Button extends DigitalInput {
    private int m_port;
    private DigitalInput m_b;
    public Button(int port) {
        super(false);
        m_port = port;
        m_b = new DigitalInput(port);
    }
    @Override
    public void gatherInfo() {
        setValue(m_b.get());
    };
}
