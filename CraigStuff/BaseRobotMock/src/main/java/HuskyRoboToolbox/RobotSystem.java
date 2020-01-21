package HuskyRoboToolbox;

import java.util.ArrayList;
import java.util.List;

public abstract class RobotSystem {

    List<RobotSystem> m_SubSystems = new ArrayList<RobotSystem>();

    public RobotSystem()
    {
    }

    public void AddSubsystem(RobotSystem NewSub)
    {
        m_SubSystems.add(NewSub);
    }
    
    public void RemoveSubSystem(RobotSystem DoomedSub)
    {
        m_SubSystems.remove(DoomedSub);
    }

    public void SystemInit()
    {
        for (RobotSystem CurSystem : m_SubSystems)
        {
            CurSystem.SystemInit();
        }
    }

    public void GatherInformation()
    {
        for (RobotSystem CurSystem : m_SubSystems)
        {
            CurSystem.GatherInformation();
        }
    }

    public void DoActions()
    {
        for (RobotSystem CurSystem : m_SubSystems)
        {
            CurSystem.DoActions();
        }
    }
}
