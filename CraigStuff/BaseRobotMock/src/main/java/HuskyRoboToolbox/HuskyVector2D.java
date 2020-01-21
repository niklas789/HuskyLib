package HuskyRoboToolbox;

public class HuskyVector2D
{
    private double _X = 0.0;
    private double _Y = 0.0;

    public HuskyVector2D()
    {
        this(0.0, 0.0);
    }

    public HuskyVector2D(HuskyVector2D CopyVec)
    {
        this(CopyVec.GetX(), CopyVec.GetY());
    }

    public HuskyVector2D(double InitX, double InitY)
    {
        _X = InitX;
        _Y = InitY;
    }

    public void SetX(double NewX)
    {
        _X = NewX;
    }

    public double GetX()
    {
        return _X;
    }

    public void SetY(double NewY)
    {
        _Y = NewY;
    }

    public double GetY()
    {
        return _Y;
    }

    public void SetXY(double NewX, double NewY)
    {
        _X = NewX;
        _Y = NewY;
    }

    public double GetMagnitude()
    {
        return Math.sqrt((_X * _X) + (_Y * _Y));
    }

    public void Scale(double ScaleFactor)
    {
        _X *= ScaleFactor;
        _Y *= ScaleFactor;
    }

    public void Normalize()
    {
        this.Scale(1.0 / this.GetMagnitude());
    }

    public void SetEqual(HuskyVector2D Other)
    {
        _X = Other.GetX();
        _Y = Other.GetY();
    }

    public HuskyVector2D VectorTo(HuskyVector2D Other)
    {
        return new HuskyVector2D(Other.GetX() - _X, Other.GetY() - _Y);
    }

    public double AngleTo(HuskyVector2D Other)
    {
        return Math.toDegrees(Math.atan2(Other.GetX() - _X, Other.GetY() - _Y));
    }

    public double DistanceTo(HuskyVector2D Other)
    {
        double deltaX = Other.GetX() - _X;
        double deltaY = Other.GetY() - _Y;
        return Math.sqrt((deltaX * deltaX) + (deltaY * deltaY));
    }

    public void Add(HuskyVector2D Other)
    {
        _X += Other.GetX();
        _Y += Other.GetY();
    }

}