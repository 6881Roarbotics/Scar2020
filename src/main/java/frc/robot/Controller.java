package frc.robot;
import edu.wpi.first.wpilibj.XboxController;

class Controller extends XboxController{

    private AxisValue axisValue;

    Controller(){

        super(0);
        axisValue = new AxisValue(0.0, 0.0);

    }

    public AxisValue getCleansedAxis(Hand hand){

        double xAxis = getX(hand);
        double yAxis = getY(hand);

        if(Math.abs(xAxis) > 0.05)
            xAxis = 0.0;

        if(Math.abs(yAxis) > 0.05)
            yAxis = 0.0;

        axisValue.setX(xAxis);
        axisValue.setY(yAxis);

        return axisValue;

    }

}