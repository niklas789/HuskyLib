package frc.robot.subsystem;
import frc.robot.subsystem.Drive;
import frc.robot.biblioteca.*;

public class SimpleTankDrive extends Drive{
  private talonSRX m_leftMaster;
  private talonSRX m_leftSlave;
  private talonSRX m_rightMaster;
  private talonSRX m_rightSlave;
  int twistInv;
  int driveInv;
  public SimpleTankDrive(int leftMasterPort, int leftSlavePort, int rightMasterPort, int rightSlavePort){
    super();
    m_leftMaster = new talonSRX(leftMasterPort);
    m_leftSlave = new talonSRX(leftSlavePort);
    m_rightMaster = new talonSRX(rightMasterPort);
    m_rightSlave = new talonSRX(rightSlavePort);
    m_rightSlave.follow(m_rightMaster);
    m_leftSlave.follow(m_leftMaster);
    driveInv = 1;
    twistInv = 1;
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
  @Override
  public void gatherInfo(){}
  @Override
  public void doActions(){
    m_leftMaster.set((m_forward * driveInv) - (m_twist * twistInv));
    m_rightMaster.set((m_forward * driveInv) + (m_twist * twistInv));
  }
}
