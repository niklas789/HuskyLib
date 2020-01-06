package frc.robot.biblioteca;
class Motor extends AnalogOutput {
    private boolean m_ifFollowing;
    private Motor m_following;
    private double m_speed;
    private double m_realSpeed;
    public Motor() {
        super(-1, 1);
        m_ifFollowing = false;
    }
    public void set(double value) {
        m_speed = value;
    }
    public void follow(Motor motorFollow) {
        m_ifFollowing = true;
        m_following = motorFollow;

    }
    public double getTargetSpeed(){
        return m_speed;
    }
    public double getRealSpeed(){
        return m_realSpeed;
    }
    @Override
    public void gatherInfo(){
        if(m_ifFollowing == true){
            m_speed = m_following.getTargetSpeed();
        }
    }
    @Override
    public void doActions(){

    }
}
