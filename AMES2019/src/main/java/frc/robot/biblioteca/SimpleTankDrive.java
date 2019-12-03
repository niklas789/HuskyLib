package frc.robot.biblioteca;
import frc.robot.subsystem.Drive;
import com.ctre.phoenix.motorcontrol.can.*;

class SimpleTankDrve extends Drive{
  private TalonSRX m_leftMaster;
  private TalonSRX m_leftSlave;
  private TalonSRX m_rightMaster;
  private TalonSRX m_rightSlave;
  int twistInv;
  int driveInv;
  SimpleTankDrive(int leftMasterPort, int leftSlavePort, int rightMasterPort, int rightSlavePort){
    m_leftMaster = new TalonSRX(leftMasterPort);
    m_leftSlave = new TalonSRX(leftSlavePort);
    m_rightMaster = new TalonSRX(rightMasterPort);
    m_rightSlave = new TalonSRX(rightSlavePort);
    m_rightSlave.follow(m_rightMaster);
    m_leftSlave.follow(m_leftMaster);
    driveInv = 1;
    super();
  }
  @Overide
  public void invertTwist(boolean twist);
    if(twist == true){
      twistInv = -1;
    }else{
      twistInv = 1; 
    }
  }
  public void invertTwist(boolean drive);
    if(drive == true){
      driveInv = -1;
    }else{
      driveInv = 1; 
    }
  }
  public void gatherInfo(){}
  @Override
  public void doActions(){
    m_leftMaster.set((m_forward * driveInv) - (m_twist * twistInv));
    m_rightMaster.set((m_forward * driveInv) + (m_twist * twistInv));
  }
}
