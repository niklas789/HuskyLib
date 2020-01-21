package GameRobot;

import HuskyRoboToolbox.HuskyVector2D;
import HuskyRoboToolbox.RobotSystem;

public class FabFlinger extends RobotSystem
{
    private EnergyRayGun _Shooter = new EnergyRayGun();
    private BallHopper _Hopper = new BallHopper();

    public FabFlinger()
    {

    }

    @Override
    public void SystemInit()
    {
        super.SystemInit();
        AddSubsystem(_Shooter);
        AddSubsystem(_Hopper);
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

    public boolean FlingBall()
    {
        boolean RetVal = false;
        if(_Shooter.IsLoaded())
        {
            _Shooter.Shoot();
            RetVal = true;
        }

        return RetVal;
    }

    public boolean TryToLoadBall()
    {
        boolean RetVal = false;

        if(!_Shooter.IsLoaded())
        {
            if(!_Hopper.IsEmpty())
            {
                _Hopper.SendBallToBeLoaded();
                _Shooter.Reload();
                RetVal = true;
            }
        }

        return RetVal;
    }

}
