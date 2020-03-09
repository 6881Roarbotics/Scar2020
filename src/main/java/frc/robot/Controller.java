package frc.robot;

import edu.wpi.first.wpilibj.XboxController;

class Controller extends XboxController {


    Controller(int port){
        super(port);
    }

    public AxisValue getCleansedAxes(){
        
        double xAxis = getRawAxis(4);
        double yAxis = getRawAxis(1);

        if(Math.abs(xAxis) < 0.1)
            xAxis = 0.0;

        if(Math.abs(yAxis) < 0.1)
            yAxis = 0.0;

            yAxis *= .5;
            xAxis *= .5;

        return new AxisValue(xAxis, -yAxis);
    }

    public AxisValue getCleansedTriggers(){
        
        double lTrigger = getRawAxis(2);
        double rTrigger = getRawAxis(3);

        if(Math.abs(lTrigger) < 0.1)
            lTrigger = 0.0;

        if(Math.abs(rTrigger) < 0.1)
            rTrigger = 0.0;

        return new AxisValue(lTrigger, rTrigger);
    }

}