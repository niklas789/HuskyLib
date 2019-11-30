package frc.robot.subsystem;
import frc.robot.biblioteca.roboBaseClass;

abstract class Drive extends roboBaseClass {
    public TalonSRX m_leftMaster;
    public TalonSRX m_rightMaster;
    public VictorSPX m_leftSlave;
    public VictorSPX m_rightSlave;
    private double m_forward;
    private double m_twist;
    private double m_strafe;
    public Drive(int leftMasterPort, int rightMasterPort, int leftSlavePort, int rightSlavePort) {
        super();
    }
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
    @Override
    abstract public void doActions();
}
