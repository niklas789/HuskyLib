package frc.robot.biblioteca;
import java.util.ArrayList;
public class RoboBaseClass {
    private static ArrayList<roboBaseClass> allParts = new ArrayList<roboBaseClass>();
    public RoboBaseClass() {
        roboBaseClass.addPart(this);
    }
    public void gatherInfo() {};
    public void doActions() {};
    public static void addPart(roboBaseClass e) {
        roboBaseClass.allParts.add(e);
    };
    public static ArrayList<roboBaseClass> getParts() {
        return (allParts);
    };
    public static void gatherInfoAll() {
        for ( roboBaseClass r : roboBaseClass.getParts() ) {
            r.gatherInfo();
        }
    };
    public static void doActionsAll() {
        for ( roboBaseClass r : roboBaseClass.getParts() ) {
            r.doActions();
        }
    };
}
