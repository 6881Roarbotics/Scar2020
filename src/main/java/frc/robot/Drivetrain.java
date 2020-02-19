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

    /**
     * Setting power to the left side of the drivetrain
     * @param power The power (-1 - 1) to be sent to the motors
     */
    void setLeft(double power){
        //Find out which motor needs to be negative
        leftDrive1.set(power);
        leftDrive2.set(-power);

    }

    /**
     * Setting power to the right side of the drivetrain
     * @param power The power (-1 - 1) to be sent to the motors
     */
    void setRight(double power){
        //Find out which motor needs to be negative
        rightDrive1.set(power);
        rightDrive2.set(-power);

    }

}