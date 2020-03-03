package frc.robot;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

class Shooter{

private TalonSRX topWheel;
private TalonSRX botWheel;

    Shooter(){

        topWheel = new TalonSRX(CAN.SHOOTER_TOP);
        botWheel = new TalonSRX(CAN.SHOOTER_BOTTOM);

    }

    /**
     * enables both wheels at full speed
     */
    void enable(){
        //check which motor needs to be negative
        topWheel.set(TalonSRXControlMode.PercentOutput, 1);
        botWheel.set(TalonSRXControlMode.PercentOutput, -1);

    }

    /**
     * Sets the speed of the bottom wheel
     * @param speed the speed to set the wheel to (-1 - 1)
     */
    void setBotWheelSpeed(double speed){

        botWheel.set(TalonSRXControlMode.PercentOutput, speed);

    }

    /**
     * Sets the speed of the top wheel
     * @param speed the speed to set the wheel to (-1 - 1)
     */
    void setTopWheelSpeed(double speed){

        topWheel.set(TalonSRXControlMode.PercentOutput, speed);

    }
}