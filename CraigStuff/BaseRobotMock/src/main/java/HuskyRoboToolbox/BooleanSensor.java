package HuskyRoboToolbox;

public abstract class BooleanSensor  extends HuskySensor
{
    protected boolean _CurValue = false;
    public BooleanSensor()
    {
    }

    public boolean GetValue()
    {
        return _CurValue;
    }
}
