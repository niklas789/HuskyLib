package GameRobot;

import Fake.FakeAngleSensor;
import Fake.FakeLoadedSensor;
import HuskyRoboToolbox.CannonBase;

public class EnergyRayGun extends CannonBase {

    private FakeAngleSensor _AngleSensor = new FakeAngleSensor();
    private FakeLoadedSensor _LoadedSensor = new FakeLoadedSensor();

    public EnergyRayGun()
    {
        SetAngleSensor(_AngleSensor);
        SetLoadedSensor(_LoadedSensor);
    }

    @Override
    public void SystemInit()
    {
        super.SystemInit();
    }

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

    public void Reload()
    {
        _LoadedSensor.FakeSetLoadedFlag(true);
    }

    public void Shoot()
    {
        if(_LoadedSensor.GetValue())
        {
            _LoadedSensor.FakeSetLoadedFlag(false);
        }
    }

    private void ReadSensors()
    {
        _AngleSensor.ReadValue();
        _LoadedSensor.ReadValue();
    }

    public void RaiseAim()
    {
        AdjustAim(1.0);
    }

    public void LowerAim()
    {
        AdjustAim(-1.0);
    }

    public void AdjustAim(double AdjustDegrees)
    {
        _AngleSensor.SetFakeAngle(_AngleSensor.GetValue() + AdjustDegrees);
    }
}
