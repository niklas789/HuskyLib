package frc.robot.subsystem;
import frc.robot.biblioteca.roboBaseClass;
import com.ctre.phoenix.motorcontrol.can.*;

abstract class Drive extends roboBaseClass {
    protected double m_forward;
    protected double m_twist;
    protected double m_strafe;
    private double m_xVel;
    private double m_yVel;
    private double m_heading;
    private double m_xLoc;
    private double m_yLoc;
    private double m_rotVel;
    public Drive() {
        super();
    }
    @Override
    abstract public void doActions();
    @Override
    abstract public void gatherInfo();
    public void setForward(double forward) {
        m_forward = forward;
    }
    public void setTwist(double twist) {
        m_twist = twist;
    }
    public void setStrafe(double strafe){
        m_strafe = strafe;
    }
    public double getxLoc(){
        return m_xLoc;   
    }
    public double getyLoc(){
        return m_yLoc;   
    }
    public double getxVel(){
        return m_xVel; 
    }
    public double getyVel(){
        return m_yVel;   
    }
    public double getHeading(){
        return m_heading;   
    }
    public double getRotVel(){
        return m_rotVel;   
    }
}
