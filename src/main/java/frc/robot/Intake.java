package frc.robot;
import edu.wpi.first.wpilibj.Spark;

class Intake{

    private Spark intake;

    Intake(){

        intake = new Spark(7);
   
    }

    void ballIn() {
        intake.set(1);
    }

    void ballOut() {
        intake.set(-1);
    }
}