package HuskyRoboToolbox;

public abstract class HeadingSensor extends HuskySensor
{
    private CompassHeading _CurValue = new CompassHeading();

    protected HeadingSensor()
    {
    }

    public double GetValue()
    {
        return _CurValue.GetValue();
    }

    protected void ClipValue()
    {
        _CurValue.SetValue(CompassHeading.ClipValue(_CurValue.GetValue()));
    }
}
