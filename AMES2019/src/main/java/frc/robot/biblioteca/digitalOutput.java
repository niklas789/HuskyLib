package frc.robot.biblioteca;
import frc.robot.biblioteca.roboBaseClass;

class digitalOutput extends roboBaseClass {
    private boolean m_currentValue;
    public digitalOutput(boolean initValue) {
        super();
        m_currentValue = initValue;
    }
    public boolean getValue() {
        return(m_currentValue);
    }
    public void setValue(boolean value) {
        m_currentValue = value;
    }
}