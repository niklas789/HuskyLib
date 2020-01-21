package HuskyRoboToolbox;

public abstract class Vector2DSensor extends HuskySensor
{
    protected HuskyVector2D _CurValue = new HuskyVector2D();

    protected Vector2DSensor()
    {
    }

    public HuskyVector2D GetCurrentValue()
    {
        return _CurValue;
    }
}
