package frc.robot;
import edu.wpi.first.wpilibj.VictorSP;

class Drivetrain {

    private VictorSP leftDrive1;
    private VictorSP leftDrive2;
    private VictorSP rightDrive1;
    private VictorSP rightDrive2;

    Drivetrain(){

        leftDrive1 = new VictorSP(1);
        leftDrive2 = new VictorSP(2);
        rightDrive1 = new VictorSP(3);
        rightDrive2 = new VictorSP(4);
        
    }

    void setLeft(double power){

        leftDrive1.set(power);
        leftDrive2.set(-power);

    }

    void setRight(double power){

        rightDrive1.set(power);
        rightDrive2.set(-power);

    }

}