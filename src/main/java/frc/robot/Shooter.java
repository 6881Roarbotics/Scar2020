package frc.robot;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;

class Shooter{

private TalonSRX shooterWheel;
private DoubleSolenoid angler;
private TalonSRX elevator;

private double maxWheelSpeed;
private double elevatorSpeed;

    Shooter(){

        shooterWheel = new TalonSRX(CAN.SHOOTER_WHEEL);
        //angler = new TalonSRX(CAN.ANGLER);
        elevator = new TalonSRX(CAN.ELEVATOR);

        maxWheelSpeed = 0.9;
        elevatorSpeed = 0.5;
        //anglerSpeed = 0.5;

    }

    /**
     * enables the wheel at full speed
     */
    void enable(){
        
        shooterWheel.set(TalonSRXControlMode.PercentOutput, -maxWheelSpeed);

    }

    /**
     * disables the wheel
     */
    void disable(){
        
        shooterWheel.set(TalonSRXControlMode.PercentOutput, 0);

    }

    //Sets the wheel to a specific value
    void setWheelSpeed(double speed){

        if(speed > maxWheelSpeed){

            shooterWheel.set(TalonSRXControlMode.PercentOutput, -maxWheelSpeed);

        }
        else{
            
            shooterWheel.set(TalonSRXControlMode.PercentOutput, -speed);

        }
        
    }

    void elevateUp(){

        elevator.set(TalonSRXControlMode.PercentOutput, -elevatorSpeed);

    }

    void elevateDown(){

        elevator.set(TalonSRXControlMode.PercentOutput, elevatorSpeed);

    }

    void stopElevator(){

        elevator.set(TalonSRXControlMode.PercentOutput, 0);

    }

    void angleUp() {

    }

    void angleDown(){

    }



}