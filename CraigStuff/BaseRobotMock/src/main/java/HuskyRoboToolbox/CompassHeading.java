package HuskyRoboToolbox;

public class CompassHeading {

    static final public double HEADING_MAX = 180.0;
    static final public double HEADING_MIN = -180.0;
    static final public double DEGREES_IN_CIRCLE = 360.0;
    static final private double CLOSE_ENOUGH_THRESHOLD = 1.5;

    private double _CurValue = 0.0;

    public CompassHeading()
    {
        this(0.0);
    }

    public CompassHeading(double InitialValue)
    {
        SetValue(InitialValue);
    }

    public void SetValue(double NewValue)
    {
        _CurValue = ClipValue(NewValue);
    }

    public static double ClipValue(double HeadingCheck)
    {
        double RetVal = HeadingCheck;

        while(RetVal >= HEADING_MAX){
            RetVal -= DEGREES_IN_CIRCLE;
        }

        while (RetVal < HEADING_MIN){
            RetVal += DEGREES_IN_CIRCLE;
        }

        return RetVal;
    }

    public double GetValue()
    {
        return _CurValue;
    }

    public static double AngleDifference(double Value1, double Value2)
    {
        return (ClipValue(Value1 - Value2));
    }

    public double AngleDifference(CompassHeading OtherOne)
    {
        return AngleDifference(GetValue(), OtherOne.GetValue());
    }

    public boolean IsClockWiseFrom(CompassHeading OtherOne)
    {
        return (AngleDifference(OtherOne) >= 0.0);
    }

    public boolean EssentiallyEquals(CompassHeading OtherOne)
    {
        return EssentiallyEquals(OtherOne.GetValue());
    }

    public boolean EssentiallyEquals(double CompareHeading)
    {
        double Difference = ClipValue(GetValue() - CompareHeading);
        return (Math.abs(Difference) < CLOSE_ENOUGH_THRESHOLD);
    }
}
