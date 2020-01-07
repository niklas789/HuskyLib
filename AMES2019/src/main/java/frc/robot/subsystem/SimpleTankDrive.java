package frc.robot.subsystem;
import frc.robot.subsystem.Drive;
import frc.robot.biblioteca.*;

public class SimpleTankDrive extends Drive{
  private HuskyTalon m_leftMaster;
  private HuskyVictor m_leftSlave;
  private HuskyTalon m_rightMaster;
  private HuskyVictor m_rightSlave;
  int twistInv;
  int driveInv;
  int invertRight;
  int invertLeft;
  public SimpleTankDrive(int leftMasterPort, int leftSlavePort, int rightMasterPort, int rightSlavePort){
    super();
    m_leftMaster = new HuskyTalon(leftMasterPort);
    m_leftSlave = new HuskyVictor(leftSlavePort);
    m_rightMaster = new HuskyTalon(rightMasterPort);
    m_rightSlave = new HuskyVictor(rightSlavePort);
    m_rightSlave.follow(m_rightMaster);
    m_leftSlave.follow(m_leftMaster);
    driveInv = 1;
    twistInv = 1;
    invertLeft = 1;
    invertRight = 1;
  }
  public void invertTwist(boolean twist) {
    if(twist == true){
      twistInv = -1;
    }else{
      twistInv = 1; 
    }
  }
  public void invertDrive(boolean drive) {
    if(drive == true){
      driveInv = -1;
    }else{
      driveInv = 1; 
    }
  }
  public void invertLeft(boolean inv){
    if(inv){
      invertLeft = -1;
    }else{
      invertLeft = 1;
    }
  }
  public void invertRight(boolean inv){
    if(inv){
      invertRight = -1;
    }else{
      invertRight = 1;
    }
  }
  public void fightingLeft(boolean boo){
    m_leftSlave.setInverted(boo);
  }
  public void fightingRight(boolean boo){
    m_rightSlave.setInverted(boo);
  }
  @Override
  public void gatherInfo(){}
  @Override
  public void doActions(){
    m_leftMaster.set(((m_forward * driveInv) - (m_twist * twistInv)) * invertLeft);
    m_rightMaster.set(((m_forward * driveInv) + (m_twist * twistInv)) * invertRight);
  }
}
