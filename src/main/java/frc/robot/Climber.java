package frc.robot;
import edu.wpi.first.wpilibj.Spark;

class Climber extends Spark{

    Climber(){

        super(CAN.CLIMBER);

    }

    void climb(double speed){

        set(speed);

    }

}