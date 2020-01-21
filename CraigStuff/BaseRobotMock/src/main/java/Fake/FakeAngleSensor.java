package Fake;

import HuskyRoboToolbox.AnalogSensor;

public class FakeAngleSensor extends AnalogSensor
{
    private double _MinAngle = 0.0;
    private double _MaxAngle = 90.0;
    private double _FakeAngle = 0.0;

    public FakeAngleSensor()
    {
    }

    public void SetFakeAngle(double NewAngle)
    {
        _FakeAngle = NewAngle;
        if(_FakeAngle < _MinAngle)
        {
            _FakeAngle = _MinAngle;
        }
        else
        {
            if(_FakeAngle > _MaxAngle)
            {
                _FakeAngle = _MaxAngle;
            }
        }
    }


    public void ReadValue()
    {
        _CurValue = _FakeAngle;
    }
}
