package GameRobot;


import Fake.FakeHeadingSensor;
import Fake.FakeLocationSensor;
import Fake.FakeVelocitySensor;
import HuskyRoboToolbox.*;

public class WubbaChassis extends ChassisBase
{
    private final static double FakeMaxVelocity = 2.0;

    private FakeLocationSensor _LocSensor = new FakeLocationSensor();
    private FakeVelocitySensor _VelSensor = new FakeVelocitySensor();
    private FakeHeadingSensor _HeadSensor = new FakeHeadingSensor();

    private double _RotationAmount = 0.0;
    private HuskyVector2D _AccelerationVec = new HuskyVector2D();

    public WubbaChassis()
    {
        SetLocationSensor(_LocSensor);
        SetVelocitySensor(_VelSensor);
        SetHeadingSensor(_HeadSensor);
    }

    @Override
    public void SystemInit()
    {
        super.SystemInit();
        ResetMotion();
    }

    public void ResetMotion()
    {
        _RotationAmount = 0.0;
        _AccelerationVec.SetXY(0.0, 0.0);
        _VelSensor.SetFakeVelocity(new HuskyVector2D(0.0, 0.0));

    }


    @Override
    public void GatherInformation()
    {
        super.GatherInformation();
    }

    @Override
    public void DoActions()
    {
        super.DoActions();

        HuskyVector2D VelWorkVec = new HuskyVector2D(GetCurrentVelocity());
        VelWorkVec.Add(_AccelerationVec);

        if(VelWorkVec.GetMagnitude() > FakeMaxVelocity)
        {
            VelWorkVec.Normalize();
            VelWorkVec.Scale(FakeMaxVelocity);
        }

        HuskyVector2D LocWorkVec = new HuskyVector2D(GetCurrentLocation());
        LocWorkVec.Add(VelWorkVec);

        _VelSensor.SetFakeVelocity(VelWorkVec);
        _LocSensor.SetFakeLocation(LocWorkVec);

        System.out.print("WubbaChassis.DoActions X: " + GetCurrentLocation().GetX() + "  Y: " + GetCurrentLocation().GetY() + "\n");

        _RotationAmount = 0.0;
        _AccelerationVec.SetXY(0.0, 0.0);
    }

    @Override
    public void SetAcceleration(HuskyVector2D AccVec)
    {
        _AccelerationVec.SetEqual(AccVec);
    }

    @Override
    public void SetRotation(double TargRotation)
    {
        _RotationAmount = TargRotation;
    }
}
