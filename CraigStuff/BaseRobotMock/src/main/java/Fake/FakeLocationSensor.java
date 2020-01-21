package Fake;

import HuskyRoboToolbox.HuskyVector2D;
import HuskyRoboToolbox.Vector2DSensor;

public class FakeLocationSensor extends Vector2DSensor
{
    private HuskyVector2D _CurFakeLocation = new HuskyVector2D();

    public FakeLocationSensor()
    {
    }

    public void SetFakeLocation(HuskyVector2D NewLoc)
    {
        _CurFakeLocation.SetEqual(NewLoc);
    }

    @Override
    public void ReadValue()
    {
        _CurValue.SetEqual(_CurFakeLocation);
    }


}
