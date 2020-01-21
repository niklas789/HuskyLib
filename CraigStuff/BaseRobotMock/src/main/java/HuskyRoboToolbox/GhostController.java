package HuskyRoboToolbox;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GhostController
{
    private List<AutonomousTaskBase> _CurrentCommandList;
    private Iterator<AutonomousTaskBase> _CurrentCommandItr;
    private AutonomousTaskBase _CurrentCommand;
    private boolean _ListNotCompleted;

    public GhostController()
    {

    }

    public void Initialize()
    {

    }

    public void SetCommandList(List<AutonomousTaskBase> NewCommandList)
    {
        _CurrentCommandList = NewCommandList;
    }

    public void StartCommandSequence()
    {
        _CurrentCommandItr = _CurrentCommandList.iterator();
        AdvanceCommandSequence();
    }

    private void AdvanceCommandSequence()
    {
        if(_CurrentCommandItr.hasNext())
        {
            _CurrentCommand = _CurrentCommandItr.next();
            _CurrentCommand.StartTask();
            _ListNotCompleted = true;
        }
        else
        {
            _ListNotCompleted = false;
        }

    }

    public boolean ExecuteCurrentCommand()
    {
        if(_ListNotCompleted)
        {
            if(_CurrentCommand.DoTask())
            {
                // current task finished
                AdvanceCommandSequence();
            }
        }

        return (_ListNotCompleted);
    }

}
