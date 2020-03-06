package frc.robot;
import java.io.Console;

import edu.wpi.first.wpilibj.XboxController;

class Controller extends XboxController {


    Controller(){
        super(0);
    }

    public AxisValue getCleansedAxes(){
        
        double xAxis = getRawAxis(2);
        double yAxis = getRawAxis(1);

        if(Math.abs(xAxis) < 0.05)
            xAxis = 0.0;

        if(Math.abs(yAxis) < 0.05)
            yAxis = 0.0;

            yAxis *= .5;
            xAxis *= .5;

        return new AxisValue(xAxis, -yAxis);
    }

}