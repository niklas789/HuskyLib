package wpilibjmock;

public abstract class RobotBase extends Object{

    protected RobotBase()
    {
        System.out.print("RobotGameMock.RobotBaseMock Constructor\n");
    }   // constructor

    public void close() {}
    @Deprecated public void free() {}
    public static boolean getBooleanProperty(String name, boolean defaultValue) { return false; }
    public boolean isAutonomous() { return false; }
    public boolean isDisabled() { return false; }
    public boolean isEnabled() { return !isDisabled(); }
    public boolean isNewDataAvailable() { return false; }
    public boolean isOperatorControl() { return false; }
    public static boolean isReal() { return false; }
    public static boolean isSimulation() { return !isReal(); }
    public boolean isTest() { return false; }
    public abstract void startCompetition();

    // static <T extends RobotBase> startRobot(Supplier<T> robotSupplier)

    public static final long MAIN_THREAD_ID = 101;

    // protected final DriverStation m_ds



}
