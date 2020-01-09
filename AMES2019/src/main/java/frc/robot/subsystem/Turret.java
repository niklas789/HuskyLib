package frc.robot.subsystem;
import frc.robot.biblioteca.RoboBaseClass;
//import PID;

abstract class Turret extends RoboBaseClass {
  private double m_currentAngleX = 0;
  private double m_targetAngleX = 0;
  private double m_xMin = -180;
  private double m_xMax = 180;
  private double m_currentAngleY = 0;
  private double m_targetAngleY = 0;
  private double m_yMin = 0;
  private double m_yMax = 0;
  
  //private PID PIDX;
  //private PID PIDY;
  
  public Turret() {
    super();
    //PIDX = new PID();
    //PIDY = new PID();
  }
  public void setTargetX(double x) {
    m_targetAngleX = max(min(x, m_xMax), m_xMin);//limit input to -360 and 360
  }
  public void setTargetY(double y) {
    m_targetAngleY = max(min(x, m_yMax), m_yMin);//limit input to -360 and 360
  }
  abstract public void shoot();
  abstract private void rotateX(double x);
  abstract private void rotateY(double y);
  @Override
  public void doActions() {
    //PIDX.calculateError(m_currentAngleX, m_targetAngleX);
    //PIDY.calculateError(m_currentAngleY, m_targetAngleY);
    //rotateX(PIDX.get());
    //rotateY(PIDY.get());
  }
}
