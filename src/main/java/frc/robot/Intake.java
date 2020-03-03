package frc.robot;
import edu.wpi.first.wpilibj.Spark;

class Intake extends Spark{

    Intake(){

        super(CAN.INTAKE);
   
    }

    /**
     *  Makes ball go in.
     */
    void ballIn() {

        set(1);

    }
    
}