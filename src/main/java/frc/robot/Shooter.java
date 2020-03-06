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
        
        shooterWheel.set(TalonSRXControlMode.PercentOutput, -1);

    }

    /**
     * enables the wheel at full speed
     */
    void disable(){
        
        shooterWheel.set(TalonSRXControlMode.PercentOutput, 0);

    }

    void elevateUp(){

        elevator.set(-0.5);

    }

    void elevateDown(){

        elevator.set(0.5);

    }

    void stopElevator(){

        elevator.set(0);

    }

    void angleUp(){

        angler.set(TalonSRXControlMode.PercentOutput, 1);

    }

    void angleDown(){

        angler.set(TalonSRXControlMode.PercentOutput, -1);

    }

}