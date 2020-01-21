package RobotGameDevelop;

enum GameState
{
    Initializing, Idling, StartAutonomous, DoAutonomous, StartTeleop, DoTeleop, StartTesting, DoTesting, Done
}

public class RobotThreadCom {

    GameState m_CurGameState = GameState.Initializing;

    public synchronized void SetGameState(GameState NewGameState)
    {
        System.out.print("Set State to: " + NewGameState.name() + "\n");

        m_CurGameState = NewGameState;
    }

    public synchronized GameState GetGameState()
    {
        return m_CurGameState;
    }

    public synchronized void ThreadWait(long WaitMillis)
    {
        try
        {
            wait(WaitMillis);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

}
