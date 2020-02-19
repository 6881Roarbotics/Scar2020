package frc.robot;
import edu.wpi.first.wpilibj.Talon;

class Shooter{

private Talon topWheel;
private Talon botWheel;

    Shooter(){

        topWheel = new Talon(5);
        botWheel = new Talon(6);

    }

    /**
     * enables both wheels at full speed
     */
    void enable(){
        //check which motor needs to be negative
        topWheel.set(1);
        botWheel.set(-1);

    }

    /**
     * Sets the speed of the bottom wheel
     * @param speed the speed to set the wheel to (-1 - 1)
     */
    void setBotWheelSpeed(double speed){

        botWheel.set(speed);

    }

    /**
     * Sets the speed of the top wheel
     * @param speed the speed to set the wheel to (-1 - 1)
     */
    void setTopWheelSpeed(double speed){

        topWheel.set(speed);

    }
}