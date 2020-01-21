package GameRobot;

import HuskyRoboToolbox.RobotSystem;

public class BallHopper  extends RobotSystem
{
    private final static int MAX_LOAD_COUNT = 5;
    private int _CurrentLoadCount = 0;

    public BallHopper()
    {

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
    }

    @Override
    public void DoActions()
    {
        super.DoActions();
    }

    public boolean IsEmpty() { return (_CurrentLoadCount == 0); }
    public boolean IsFull() { return (_CurrentLoadCount == MAX_LOAD_COUNT); }

    public boolean PickUpBall()
    {
        boolean RetVal = false;
        if(_CurrentLoadCount < MAX_LOAD_COUNT)
        {
            _CurrentLoadCount++;
            RetVal = true;
        }

        return RetVal;
    }

    public boolean SendBallToBeLoaded()
    {
        boolean RetVal = false;
        if(_CurrentLoadCount > 0)
        {
            _CurrentLoadCount--;
            RetVal = true;
        }

        return RetVal;
    }
}
