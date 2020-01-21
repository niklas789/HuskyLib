package Fake;
import java.util.*;

import HuskyRoboToolbox.AutonomousTaskBase;

public class ATaskLetterDummy extends AutonomousTaskBase
{
    private ArrayList al = new ArrayList();
    private Iterator<String> _CurrentLetterItr;

    public ATaskLetterDummy()
    {
        // add elements to the array list
        al.add("A");
        al.add("B");
        al.add("C");
        al.add("D");
        al.add("E");
        al.add("F");
    }

    @Override
    public void StartTask()
    {
        _CurrentLetterItr = al.iterator();
    }

    public boolean DoTask()
    {
        boolean RetVal = true;
        if(_CurrentLetterItr.hasNext()) {
            System.out.print("ATaskNumberDummy.DoTask: " + _CurrentLetterItr.next() + "\n");
            RetVal = false;
        }
        return (RetVal);
    }

}
