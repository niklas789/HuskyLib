package frc.robot.biblioteca;

public class PID {
    private double m_P;
    private double m_I;
    private double m_D;
    private double m_errorSum;
    private double m_error;
    private double m_tolerance;
    private double m_maxError;
    private double m_maxOutput;
    private double m_minOutput;
    private double m_lastPosition;

    public double getP() {
        return m_P;
    }

    public void setP(double m_P) {
        this.m_P = m_P;
    }

    public double getI() {
        return m_I;
    }

    public void setI(double m_I) {
        this.m_I = m_I;
    }

    public double getD() {
        return m_D;
    }

    public void setD(double m_D) {
        this.m_D = m_D;
    }

    public double gettolerance() {
        return m_tolerance;
    }

    public void settolerance(double m_tolerance) {
        this.m_tolerance = m_tolerance;
    }
    public PID() {

    }
    public double calculateError(double position, double target) {
        double output = 0;
        m_error = target - position;
        m_errorSum += m_error;
        output += m_error * m_P;
        output += m_errorSum * m_I;
        output -= m_error - m_lastPosition * m_D;
        if(Math.abs(m_errorSum) > m_maxError)
        if(output > m_maxOutput){
            output = m_maxOutput;
        }
        if(output < m_minOutput){
            output = m_minOutput;
        }
        return output;
    }
}
