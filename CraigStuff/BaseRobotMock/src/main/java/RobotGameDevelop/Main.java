package RobotGameDevelop;

public class Main {
    public static void main(String[] args)
    {
        System.out.print("Mock main\n");

        RobotThreadCom ComBlock = new RobotThreadCom();
        new WorkerThread(ComBlock);
        new UIThread(ComBlock);

    }

}
