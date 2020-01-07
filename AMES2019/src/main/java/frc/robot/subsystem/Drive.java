package frc.robot.subsystem;
import frc.robot.biblioteca.RoboBaseClass;

abstract class Drive extends RoboBaseClass {
    protected double m_forward;
    protected double m_twist;
    protected double m_strafe;
    private double m_xVel;
    private double m_yVel;
    private double m_heading;
    private double m_xLoc;
    private double m_yLoc;
    private double m_rotVel;
    private boolean m_invertForward;
    private boolean m_invertStrafe;
    private boolean m_invertTwist;
    public Drive() {
        super();
    }
    @Override
    abstract public void doActions();
    @Override
    abstract public void gatherInfo();
    public void setForward(double forward) {
        if(m_invertForward){
            m_forward = -forward;
        }else{
            m_forward = forward;
        }
    }
    public void setTwist(double twist) {
        if(m_invertTwist){
            m_twist = -twist;
        }else{
            m_twist = twist;
        }
    }
    public void setStrafe(double strafe){
        if(m_invertStrafe){
            m_strafe = -strafe;
        }else{
            m_strafe = strafe;
        }
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
    public void invertTwist(boolean twist){
        m_invertTwist = twist;
    }
    public void invertStrafe(boolean strafe){
        m_invertStrafe = strafe;
    }
    public void invertForward(boolean forward){
        m_invertForward = forward;
    }

}
