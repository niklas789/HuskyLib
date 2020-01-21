package wpilibjmock;

public class TimedRobot extends IterativeRobotBase {
    public static final double kDefaultPeriod = 0.5;

    protected TimedRobot()
    {
        this(kDefaultPeriod);
        System.out.print("RobotGameMock.TimedRobotMock Default Constructor\n");

    }   // default constructor

    protected TimedRobot(double period)
    {
        super(period);
        System.out.print("RobotGameMock.TimedRobotMock Base Constructor\n");
    }   // constructor

    @Override protected void finalize() {}
    double getPeriod() { return m_period; }
    public void startCompetition() {}
}
