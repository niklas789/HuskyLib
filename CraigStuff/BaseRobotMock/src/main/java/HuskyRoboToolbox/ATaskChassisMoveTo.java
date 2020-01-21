package HuskyRoboToolbox;

public class ATaskChassisMoveTo extends AutonomousTaskBase {

    private final static double CLOSE_ENOUGH = 3.0;

    private ChassisBase _TheChassis;
    private HuskyVector2D _TargLoc = new HuskyVector2D();

    public ATaskChassisMoveTo(ChassisBase TheChassis, HuskyVector2D TargLoc)
    {
        _TheChassis = TheChassis;
        _TargLoc.SetEqual(TargLoc);
    }

    @Override
    public void StartTask()
    {
    }

    @Override
    public boolean DoTask()
    {
        boolean RetVal = true;
        HuskyVector2D CurLoc = new HuskyVector2D(_TheChassis.GetCurrentLocation());

        if (CurLoc.DistanceTo(_TargLoc) > CLOSE_ENOUGH)
        {
            CompassHeading CurHeading = new CompassHeading(_TheChassis.GetCurrentHeading());
            CompassHeading TargHeading = new CompassHeading(CurLoc.AngleTo(_TargLoc));
            double RotationNeeded = TargHeading.AngleDifference(CurHeading);

            HuskyVector2D AccVec = CurLoc.VectorTo(_TargLoc);

            _TheChassis.SetAcceleration(AccVec);
            _TheChassis.SetRotation(RotationNeeded);

            RetVal = false;
        }
        else
        {
            HuskyVector2D VelStopVec = new HuskyVector2D(_TheChassis.GetCurrentVelocity());
            VelStopVec.Scale(-1.0);
            _TheChassis.SetAcceleration(VelStopVec);
        }

        return RetVal;
    }
}
