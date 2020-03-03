package frc.robot;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

class Drivetrain {

    private VictorSPX leftFrontMotor;
    private VictorSPX leftBackMotor;
    private VictorSPX rightFrontMotor;
    private VictorSPX rightBackMotor;

    Drivetrain(){

        leftFrontMotor = new VictorSPX(CAN.DRIVETRAIN_LEFT_FRONT);
        leftBackMotor = new VictorSPX(CAN.DRIVETRAIN_LEFT_BACK);
        rightFrontMotor = new VictorSPX(CAN.DRIVETRAIN_RIGHT_FRONT);
        rightBackMotor = new VictorSPX(CAN.DRIVETRAIN_RIGHT_BACK);
        
    }

    /**
     * Setting power to the left side of the drivetrain
     * @param power The power (-1 - 1) to be sent to the motors
     */
    void setLeft(double power){

        //Find out which motor needs to be negative
        leftFrontMotor.set(VictorSPXControlMode.PercentOutput, -power);
        leftBackMotor.set(VictorSPXControlMode.PercentOutput,   power);

    }

    /**
     * Setting power to the right side of the drivetrain
     * @param power The power (-1 - 1) to be sent to the motors
     */
    void setRight(double power){
        //Find out which motor needs to be negative
        rightFrontMotor.set(VictorSPXControlMode.PercentOutput, -power);
        rightBackMotor.set(VictorSPXControlMode.PercentOutput,   power);

    }

}