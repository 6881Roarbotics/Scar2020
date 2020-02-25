package frc.robot;
import edu.wpi.first.wpilibj.Spark;

class Climber extends Spark{

    Climber(){

        super(8);

    }

    void setMotor(double speed){

        set(speed);

    }

}