package Fake;

import HuskyRoboToolbox.BooleanSensor;

public class FakeLoadedSensor extends BooleanSensor
{
    private boolean _IsLoadedFlag = false;

    public FakeLoadedSensor()
    {

    }

    public void FakeSetLoadedFlag(boolean NewVal)
    {
        _IsLoadedFlag = NewVal;
    }


    @Override
    public void ReadValue()
    {
        _CurValue = _IsLoadedFlag;
    }

}
