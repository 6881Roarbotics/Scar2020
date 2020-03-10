package frc.robot;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

class Intake extends Spark{

    private DoubleSolenoid intakeSolenoid;
    private CANSparkMax intake;

    Intake(){

        super(CAN.INTAKE);
        intake = new CANSparkMax(CAN.INTAKE, MotorType.kBrushed);
        intakeSolenoid = new DoubleSolenoid(0, 1);
   
    }

    //Makes balls go in
    void ballIn(double power) {

        intake.set(power);

    }

    void ballOut(double power) {

        intake.set(-power);

    }

    //Toggles the intake solenoid
    void toggleSolenoid() {

        if(intakeSolenoid.get() == Value.kForward) {
            intakeSolenoid.set(Value.kReverse);
        }
        else {
            intakeSolenoid.set(Value.kForward);
        }

    }

    //Sets the intake solenoid to a specific value
    void setSolenoid(DoubleSolenoid.Value value) {

        intakeSolenoid.set(value);

    }

}