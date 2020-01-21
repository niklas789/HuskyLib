package HuskyRoboToolbox;

public abstract class CannonBase  extends RobotSystem
{
    private AnalogSensor _CurAngleSensor = null;
    private BooleanSensor _IsLoadedSensor = null;

    public CannonBase()
    {
    }

    protected void SetAngleSensor(AnalogSensor TargAngleSensor)
    {
        _CurAngleSensor = TargAngleSensor;
    }

    protected void SetLoadedSensor(BooleanSensor TargBoolSensor)
    {
        _IsLoadedSensor = TargBoolSensor;
    }

    public double GetCurrentAngle()
    {
        return (_CurAngleSensor != null) ? _CurAngleSensor.GetValue() : 0.0;
    }

    public boolean IsLoaded()
    {
        return (_IsLoadedSensor != null) ? _IsLoadedSensor.GetValue() : false;
    }

    protected abstract void Shoot();

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
        if(_CurAngleSensor != null) { _CurAngleSensor.ReadValue(); }
        if(_IsLoadedSensor != null) { _IsLoadedSensor.ReadValue(); }
    }


}
