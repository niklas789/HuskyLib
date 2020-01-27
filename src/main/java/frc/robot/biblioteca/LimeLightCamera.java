import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import frc.robot.biblioteca.RoboBaseClass;
public enum CameraMode {
     ROBOTVISION,DRIVERVISION
}
public class LimeLightCamera extends RoboBaseClass {
     private NetworkTable table;
     private NetworkTableEntry m_tx;//Horizontal Offset From Crosshair To Target (-29.8 to 29.8 degrees)
     private NetworkTableEntry m_ty;//Vertical Offset From Crosshair To Target (-24.85 to 24.85 degrees)
     private NetworkTableEntry m_ta;//Target Area (0% of image to 100% of image)
     private double m_xDistance;
     private doube m_yDistance;
     private double m_area;
     private CameraMode m_cameraMode;
     public LimeLightCamera() {
          table = NetworkTableInstance.getDefault().getTable("limelight");
          m_tx = table.getEntry("tx");
          m_ty = table.getEntry("ty");
          m_ta = table.getEntry("ta");
     }
     @Override
     public void gatherInfo() {
          m_xDistance = m_tx.getDouble(0.0);
          m_yDistance = m_ty.getDouble(0.0);
          m_area = m_ta.getDouble(0.0);
     }
     
     public double getXDistance() {
          return xDistance;
     }
     public double getYDistance() {
          return yDistance;
     }
     public double getArea() {
          return area;
     }
     
     public double setCameraMode(CameraMode mode) {
          if(mode == CameraMode.ROBOTVISION) {
               m_cameraMode = 0;
               table.getEntry("camMode").setNuber(0);
          } else {
               m_cameraMode = 1;
               table.getEntry("camMode").setNuber(1);
          }
     }
     public CameraMode getCameraMode() {
          if(m_cameraMode = 0) {
               return CameraMode.ROBOTVISION;
          } else {
               return CameraMode.DRIVERSTATION;
          }
     }
}
