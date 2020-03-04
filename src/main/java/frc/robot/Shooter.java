package frc.robot;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Spark;

class Shooter{

private TalonSRX shooterWheel;
private TalonSRX angler;
private Spark elevator;

    Shooter(){

        shooterWheel = new TalonSRX(CAN.SHOOTER_WHEEL);
        angler = new TalonSRX(CAN.ANGLER);
        elevator = new Spark(CAN.ELEVATOR);

    }

    /**
     * enables the wheel at full speed
     */
    void enable(){
        
        shooterWheel.set(TalonSRXControlMode.PercentOutput, 1);

    }

    /**
     * Sets the speed of the wheel
     * @param speed the speed to set the wheel to (-1 - 1)
     */
    void setWheelSpeed(double speed){

        shooterWheel.set(TalonSRXControlMode.PercentOutput, speed);

    }

    void elevateUp(){

        elevator.set(1);

    }

    void elevateDown(){

        elevator.set(-1);

    }

    void angleUp(){

        angler.set(TalonSRXControlMode.PercentOutput, 1);

    }

    void angleDown(){

        angler.set(TalonSRXControlMode.PercentOutput, -1);

    }

}