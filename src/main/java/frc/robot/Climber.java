package frc.robot;
import edu.wpi.first.wpilibj.Spark;

class Climber{

    private Spark climbMotor;

    Climber(){

        climbMotor = new Spark(8);

    }

    void setSpeed(double speed){

        climbMotor.set(speed);

    }

}