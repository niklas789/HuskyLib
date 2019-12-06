package frc.robot.biblioteca;
import frc.robot.biblioteca.roboBaseClass;

class digitalInput extends roboBaseClass {
    private boolean m_currentValue;
    public digitalInput(boolean initValue) {
        super();
        m_currentValue = initValue;
    }
    public boolean getValue() {
        return(m_currentValue);
    }
    protected void setValue(boolean value) {
        m_currentValue = value;
    }
}