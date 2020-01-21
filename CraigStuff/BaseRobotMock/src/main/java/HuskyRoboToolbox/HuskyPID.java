package HuskyRoboToolbox;

public class HuskyPID
{
    static final private double DEFAULT_P_FAC = 1.0;
    static final private double DEFAULT_I_FAC = 0.0;
    static final private double DEFAULT_D_FAC = 0.0;
    static final private double DEFAULT_MAX_VALUE = 1.0;

    private double _P_Factor = DEFAULT_P_FAC;
    private double _I_Factor = DEFAULT_I_FAC;
    private double _D_Factor = DEFAULT_D_FAC;

    static final int INTEGRATE_ELEMENTS_COUNT = 5;
    private double _IntegrateElements[] = new double[INTEGRATE_ELEMENTS_COUNT];
    private int _IntegrateIndex = 0;
    private double _IntegralTotal = 0.0;

    protected double _TargetValue = 0.0;

    private double _PreviousError = 0.0;
    private double _DeltaError = 0.0;

    private double _MaxReturnValue = DEFAULT_MAX_VALUE;


    public class PID_Tune
    {
        private double _PFac;
        private double _IFac;
        private double _DFac;

		public PID_Tune(double PFac, double IFac, double DFac)
        {
            _PFac = PFac;
            _IFac = IFac;
            _DFac = DFac;
       }

        public double GetP() { return _PFac; }
        public double GetI() { return _IFac; }
        public double GetD() { return _DFac; }

    }

    public HuskyPID(PID_Tune Tune){
        this(Tune.GetP(), Tune.GetI(), Tune.GetD(), DEFAULT_MAX_VALUE);
    }

    public HuskyPID() {
        this(DEFAULT_P_FAC, DEFAULT_I_FAC, DEFAULT_D_FAC, DEFAULT_MAX_VALUE);
    }



    public HuskyPID(double PFac, double IFac, double DFac, double MaxVal){
        _P_Factor = PFac;
        _I_Factor = IFac;
        _D_Factor = DFac;
        _MaxReturnValue = MaxVal;

        PID_Reset();

    }

    public void SetTune(PID_Tune NewTune){
        SetP(NewTune.GetP());
        SetI(NewTune.GetI());
        SetD(NewTune.GetD());
    }

    public void SetP(double NewP){
        _P_Factor = NewP;
    }

    public double GetP(){
        return _P_Factor;
    }

    public void SetI(double NewI){
        _I_Factor = NewI;
    }

    public double GetI(){
        return _I_Factor;
    }

    public void SetD(double NewD){
        _D_Factor = NewD;
    }

    public double GetD(){
        return _D_Factor;
    }

    public void PID_Reset(){
        // zero out all the values in the integrate table
        for(int ie_index = 0; ie_index < INTEGRATE_ELEMENTS_COUNT; ie_index++){
            _IntegrateElements[ie_index] = 0.0;
        }
    }

    public void SetTarget(double NewTarg){
        _TargetValue = NewTarg;
    }

    public double GetTarget(){
        return _TargetValue;
    }

    public void SetMaxValue(double NewMaxVal){
        _MaxReturnValue = NewMaxVal;
    }

    public double GetMaxValue(){
        return _MaxReturnValue;
    }

    public double CalculateError(double CurrentReading){
        return _TargetValue - CurrentReading;
    }

    public double GetControlValue(double CurrentReading){

        double CurrentError = CalculateError(CurrentReading);

        SetDValue(CurrentError);
        SetIValue(CurrentError);

        double RetVal = (CurrentError * _P_Factor) +
                (_IntegralTotal * _I_Factor) +
                (_DeltaError * _D_Factor);

        if(Math.abs(RetVal) > _MaxReturnValue){
            RetVal = (RetVal > 0.0) ? _MaxReturnValue : -_MaxReturnValue;
        }

        return RetVal;
    }


    private void SetDValue(double NewError){
        _DeltaError = NewError - _PreviousError;
        _PreviousError = NewError;
    }


    private void SetIValue(double NewError){
        _IntegrateElements[_IntegrateIndex++] = NewError;
        if(_IntegrateIndex >= INTEGRATE_ELEMENTS_COUNT){
            _IntegrateIndex = 0;
        }

        _IntegralTotal = 0.0;
        for(int ie_index = 0; ie_index < INTEGRATE_ELEMENTS_COUNT; ++ie_index){
            _IntegralTotal += _IntegrateElements[ie_index];
        }
    }

}
