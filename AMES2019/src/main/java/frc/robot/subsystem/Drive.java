package frc.robot.subsystem;
import frc.robot.biblioteca.roboBaseClass;

class Drive extends roboBaseClass {
    public TalonSRX m_leftMaster;
    public TalonSRX m_rightMaster;
    public VictorSPX m_leftSlave;
    public VictorSPX m_rightSlave;
    private double m_forward;
    private double m_twist;
    public Drive(int leftMasterPort, int rightMasterPort, int leftSlavePort, int rightSlavePort) {
        super();
    }
    @Override
    public void gatherInfo() {
        
    }
    public void setForward(double forward) {

    }
    public void setTwist(double twist) {

    }
    @Override
    public void doActions() {
        
    }
}