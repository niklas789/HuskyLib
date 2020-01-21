package Fake;

import HuskyRoboToolbox.HuskyVector2D;
import HuskyRoboToolbox.Vector2DSensor;

public class FakeVelocitySensor extends Vector2DSensor
{
    private HuskyVector2D _CurFakeVelocity = new HuskyVector2D();

    public FakeVelocitySensor()
    {
    }

    public void SetFakeVelocity(HuskyVector2D NewVel)
    {
        _CurFakeVelocity.SetEqual(NewVel);
    }

    @Override
    public void ReadValue()
    {
        _CurValue.SetEqual(_CurFakeVelocity);
    }
}
