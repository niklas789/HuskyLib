package Fake;

import HuskyRoboToolbox.AutonomousTaskBase;

public class ATaskNumberDummy extends AutonomousTaskBase
{
    private final static int EndDummyNumber = 7;
    private int _CurDummyNumber;

    public ATaskNumberDummy()
    {
    }

    @Override
    public void StartTask()
    {
        _CurDummyNumber = 0;
    }

    public boolean DoTask()
    {
        System.out.print("ATaskNumberDummy.DoTask: " + ++_CurDummyNumber + "\n");
        return (_CurDummyNumber > EndDummyNumber);
    }

}
