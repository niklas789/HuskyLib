package wpilibjmock;

public abstract class IterativeRobotBase extends RobotBase {

    protected IterativeRobotBase(double period)
    {
        System.out.print("RobotGameMock.IterativeRobotBaseMock Constructor\n");

        m_period = period;
    }

    public void autonomousInit() {}
    public void autonomousPeriodic() {}
    public void disabledInit() {}
    public void disabledPeriodic() {}
    protected void loopFunc() {}
    public void robotInit() {}
    public void robotPeriodic() {}
    public abstract void startCompetition();
    public void teleopInit() {}
    public void teleopPeriodic() {}
    public void testInit() {}
    public void testPeriodic() {}

    protected double m_period;
}
