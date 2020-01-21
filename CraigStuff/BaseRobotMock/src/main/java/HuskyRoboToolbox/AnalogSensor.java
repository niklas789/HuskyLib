package HuskyRoboToolbox;

public abstract class AnalogSensor extends HuskySensor
{
    protected double _CurValue = 0.0;

    protected AnalogSensor()
    {
    }

    public double GetValue()
    {
        return _CurValue;
    }

}
