package frc.robot;
import java.io.Console;

import edu.wpi.first.wpilibj.XboxController;

class Controller extends XboxController {


    Controller(){
        super(0);
    }

    public AxisValue getCleansedAxis(Hand hand){
        
        double xAxis = 0;
        double yAxis = 0;

        if(hand == Hand.kLeft) {
            xAxis = getRawAxis(0);
            yAxis = getRawAxis(1); 
        } else if (hand == Hand.kRight) {
            xAxis = getRawAxis(2);
            yAxis = getRawAxis(3); 
        }

        if(Math.abs(xAxis) < 0.05)
            xAxis = 0.0;

        if(Math.abs(yAxis) < 0.05)
            yAxis = 0.0;

        return new AxisValue(xAxis, yAxis);
    }

}