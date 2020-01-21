package RobotGameDevelop;

public class UIThread implements Runnable{
    RobotThreadCom m_Com;

    public UIThread(RobotThreadCom Com)
    {
        m_Com = Com;
        new Thread(this, "UI Thread").start();
    }

    public void run()
    {
        boolean HaveRunAuto = false;
        boolean HaveRunTeleop = false;
        boolean HaveRunTesting = false;

        GameState CurGameState = m_Com.GetGameState();
        while(CurGameState != GameState.Done) {
            switch (CurGameState) {
                case StartAutonomous:
                case DoAutonomous:
                case StartTeleop:
                case DoTeleop:
                case StartTesting:
                case DoTesting:
                case Done:
                    // do nothing
                    break;

                case Initializing:
                    m_Com.SetGameState(GameState.Idling);
                    break;

                case Idling:
                    if(!HaveRunAuto)
                    {
                        m_Com.SetGameState(GameState.StartAutonomous);
                        HaveRunAuto = true;
                    }
                    else
                    {
                        if(!HaveRunTeleop)
                        {
                            m_Com.SetGameState(GameState.StartTeleop);
                            HaveRunTeleop = true;
                        }
                        else
                        {
                            if(!HaveRunTesting)
                            {
                                m_Com.SetGameState(GameState.StartTesting);
                                HaveRunTesting = true;
                            }
                            else
                            {
                                m_Com.SetGameState(GameState.Done);
                            }
                        }
                    }
                    break;

                default:
                    // throw exception
                    break;

            }

            m_Com.ThreadWait(500);
            CurGameState = m_Com.GetGameState();

        }
    }
}
