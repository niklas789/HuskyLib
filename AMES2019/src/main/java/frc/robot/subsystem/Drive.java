package frc.robot.subsystem;
import frc.robot.biblioteca.roboBaseClass;

class Drive extends roboBaseClass {
    public TalonSRX leftMaster;
    public TalonSRX rightMaster;
    public VictorSPX leftSlave;
    public VictorSPX rightSlave;
    public Drive(int leftMasterPort, int rightMasterPort, int leftSlavePort, int rightSlavePort) {
        super();
    }
    @Override
    public void gatherInfo() {
        
    }
    @Override
    public void doActions() {
        
    }
}