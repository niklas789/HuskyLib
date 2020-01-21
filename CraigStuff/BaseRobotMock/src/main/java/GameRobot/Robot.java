package GameRobot;

import HuskyRoboToolbox.ATaskChassisMoveTo;

import HuskyRoboToolbox.AutonomousTaskBase;
import HuskyRoboToolbox.GhostController;
import HuskyRoboToolbox.HuskyVector2D;
import wpilibjmock.TimedRobot;

import java.util.ArrayList;
import java.util.List;

public class Robot extends TimedRobot {

    private int autonomousCount;
    private int teleopCount;
    private int testCount;

    //private RoboMainSystem m_MainSystem = new RoboMainSystem();
    private WubbaChassis _Chassis = new WubbaChassis();
    private GhostController _TheGhost = new GhostController();
    private FabFlinger _Flinger = new FabFlinger();

    private List<AutonomousTaskBase> _MasterCommandList = new ArrayList<AutonomousTaskBase>();

    public Robot()
    {
        System.out.print("robot.Robot Constructor\n");

        _MasterCommandList.add(new ATaskChassisMoveTo(_Chassis, new HuskyVector2D(10.0, 0.0)));
        _MasterCommandList.add(new ATaskChassisMoveTo(_Chassis, new HuskyVector2D(10.0, 10.0)));


    }
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit() {
        System.out.print("robot.Robot robotInit\n");
        autonomousCount = 0;
        teleopCount = 0;
        testCount = 0;
        _TheGhost.SetCommandList(_MasterCommandList);
        _Chassis.SystemInit();
        _Flinger.SystemInit();
    }

    /**
     * This function is run once each time the robot enters autonomous mode.
     */
    @Override
    public void autonomousInit() {
        System.out.print("robot.Robot autonomousInit\n");
        autonomousCount = 0;
        _TheGhost.StartCommandSequence();
    }

    /**
     * This function is called periodically during autonomous.
     */
    @Override
    public void autonomousPeriodic()
    {
        System.out.print("robot.Robot autonomousPeriodic: " + ++autonomousCount + "\n");
        _Chassis.GatherInformation();
        _Flinger.GatherInformation();
        _TheGhost.ExecuteCurrentCommand();
        _Chassis.DoActions();
        _Flinger.DoActions();
    }

    /**
     * This function is called once each time the robot enters teleoperated mode.
     */
    @Override
    public void teleopInit() {
        System.out.print("robot.Robot teleopInit\n");
        teleopCount = 0;
        _Chassis.ResetMotion();
    }

    /**
     * This function is called periodically during teleoperated mode.
     */
    @Override
    public void teleopPeriodic()
    {
        System.out.print("robot.Robot teleopPeriodic: " + ++teleopCount + "\n");
        _Chassis.GatherInformation();
        _Flinger.GatherInformation();
        _Chassis.DoActions();
        _Flinger.DoActions();
    }

    /**
     * This function is called periodically during test mode.
     */
    @Override
    public void testPeriodic()
    {
        System.out.print("robot.Robot testPeriodic: " + ++testCount + "\n");
        _Chassis.GatherInformation();
        _Flinger.GatherInformation();
        _Chassis.DoActions();
        _Flinger.DoActions();
    }

}
