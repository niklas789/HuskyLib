import static org.junit.Assume.assumeTrue;

public class BallCounterSensor{
 
    public BallCounterSensor()
    {
        UVballSensor = new UVsensor();
    }
    public int getCurrentBallcount(int ballCount){
        return ballCount;
    }
    public void addBall(int ballCount)
    {
        if(UVballSensorDectectsSomething == true)
        {
           ballCount++;     
        }
    }
    public void removeBall(int ballCount)
    {
        ballCount--;
    }
}