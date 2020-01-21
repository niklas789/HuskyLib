package HuskyRoboToolbox;

public class HuskyHeadingPID extends HuskyPID
{
    @Override
    public double CalculateError(double CurrentReading){
        return CompassHeading.AngleDifference(_TargetValue, CurrentReading);
    }

}
