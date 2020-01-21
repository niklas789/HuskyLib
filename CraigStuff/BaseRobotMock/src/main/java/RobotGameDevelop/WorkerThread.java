package RobotGameDevelop;

public class WorkerThread implements Runnable {

    static final int kAutonomousCyclesMax = 25;
    static final int kTeleopCyclesMax = 10;
    static final int kTestingCycleMax = 15;


    RobotThreadCom m_Com;
    GameRobot.Robot m_MasterRobot = new GameRobot.Robot();

    public WorkerThread(RobotThreadCom Com)
    {
        m_Com = Com;
        m_MasterRobot = new GameRobot.Robot();
        new Thread(this, "Worker Thread").start();
    }

    public void run()
    {
        m_MasterRobot.robotInit();
        int LoopCount = 0;
        int AutonomousCycles = 0;
        int TeleopCycles = 0;
        int TestingCycles = 0;

        GameState CurGameState = m_Com.GetGameState();
        while(CurGameState != GameState.Done)
        {
            LoopCount++;
            System.out.print("Worker Thread Loop: " + LoopCount + "\n");

            switch(CurGameState)
            {
                case Initializing:
                case Idling:
                case Done:
                    // do nothing
                    break;

                case StartAutonomous:
                    AutonomousCycles = 0;
                    m_MasterRobot.autonomousInit();
                    m_Com.SetGameState(GameState.DoAutonomous);
                    break;

                case DoAutonomous:
                    m_MasterRobot.autonomousPeriodic();
                    if(AutonomousCycles++ >= kAutonomousCyclesMax)
                    {
                        m_Com.SetGameState(GameState.Idling);
                    }
                    break;

                case StartTeleop:
                    TeleopCycles = 0;
                    m_MasterRobot.teleopInit();
                    m_Com.SetGameState(GameState.DoTeleop);
                    break;

                case DoTeleop:
                    m_MasterRobot.teleopPeriodic();
                    if(TeleopCycles++ >= kTeleopCyclesMax)
                    {
                        m_Com.SetGameState(GameState.Idling);
                    }
                    break;

                case StartTesting:
                    TestingCycles = 0;
                    m_Com.SetGameState(GameState.DoTesting);
                    break;

                case DoTesting:
                    m_MasterRobot.testPeriodic();
                    if(TestingCycles++ >= kTestingCycleMax)
                    {
                        m_Com.SetGameState(GameState.Idling);
                    }
                    break;

                default:
                    // throw exception
                    break;

            }

            m_Com.ThreadWait(1000);

            CurGameState = m_Com.GetGameState();
        }
    }
}
