package HuskyRoboToolbox;

public abstract class AutonomousTaskBase
{
    public abstract void StartTask();
    public abstract boolean DoTask();   // return true when the task is done, false if it's still going
}
