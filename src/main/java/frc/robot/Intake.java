package frc.robot;
import edu.wpi.first.wpilibj.Spark;

class Intake{

    private Spark intake;

    Intake(){

        intake = new Spark(7);
   
    }
    /**
     *  Makes ball go in.
     */
    void ballIn() {
        intake.set(1);
    }
}