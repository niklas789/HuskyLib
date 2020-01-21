package HuskyRoboToolbox;


public abstract class ChassisBase extends RobotSystem
{
    private Vector2DSensor _CurLocationSensor = null;
    private Vector2DSensor _CurVelocitySensor = null;
    private HeadingSensor _CurHeadingSensor = null;

    private final HuskyVector2D DEFAULT_LOCATION = new HuskyVector2D(0.0, 0.0);
    private final HuskyVector2D DEFAULT_VELOCITY = new HuskyVector2D(0.0, 0.0);
    private final CompassHeading DEFAULT_HEADING = new CompassHeading(0.0);

    public ChassisBase()
    {
    }

    protected void SetLocationSensor(Vector2DSensor NewLocSensor)
    {
        _CurLocationSensor = NewLocSensor;
    }

    protected void SetVelocitySensor(Vector2DSensor NewVelSensor)
    {
        _CurVelocitySensor = NewVelSensor;
    }

    protected void SetHeadingSensor(HeadingSensor NewHeadSensor)
    {
        _CurHeadingSensor = NewHeadSensor;
    }

    public HuskyVector2D GetCurrentLocation()
    {
        return (_CurLocationSensor != null) ? _CurLocationSensor.GetCurrentValue() : DEFAULT_LOCATION;
    }

    public HuskyVector2D GetCurrentVelocity()
    {
        return (_CurVelocitySensor != null) ? _CurVelocitySensor.GetCurrentValue() : DEFAULT_VELOCITY;
    }

    public double GetCurrentHeading()
    {
        return (_CurHeadingSensor != null) ? _CurHeadingSensor.GetValue() : DEFAULT_HEADING.GetValue();
    }

    public abstract void SetAcceleration(HuskyVector2D AccVec);
    public abstract void SetRotation(double TargRotation);

    @Override
    public void GatherInformation()
    {
        super.GatherInformation();
        ReadSensors();
    }

    @Override
    public void DoActions()
    {
        super.DoActions();
    }

    private void ReadSensors()
    {
        if(_CurLocationSensor != null) { _CurLocationSensor.ReadValue(); }
        if(_CurVelocitySensor != null) { _CurVelocitySensor.ReadValue(); }
        if(_CurHeadingSensor != null) { _CurHeadingSensor.ReadValue(); }
    }

}
