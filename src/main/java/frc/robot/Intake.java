package frc.robot;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

class Intake extends Spark{

    private DoubleSolenoid intakeSolenoid;
    private Spark intake;

    Intake(){

        super(CAN.INTAKE);
        intake = new Spark(CAN.INTAKE);
        intakeSolenoid = new DoubleSolenoid(0, 1);
   
    }

    //Makes balls go in
    void ballIn() {

        intake.set(1);

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