package frc.robot;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

class Drivetrain {

    private VictorSPX leftFrontMotor;
    private VictorSPX leftBackMotor;
    private VictorSPX rightFrontMotor;
    private VictorSPX rightBackMotor;

    private final double defaultSpeed;
    private final double defaultTurnSpeed;

    Drivetrain(){

        leftFrontMotor = new VictorSPX(CAN.DRIVETRAIN_LEFT_FRONT);
        leftBackMotor = new VictorSPX(CAN.DRIVETRAIN_LEFT_BACK);
        rightFrontMotor = new VictorSPX(CAN.DRIVETRAIN_RIGHT_FRONT);
        rightBackMotor = new VictorSPX(CAN.DRIVETRAIN_RIGHT_BACK);

        defaultSpeed = 0.5;
        defaultTurnSpeed = 0.5;
        
    }

    /**
     * Setting power to the left side of the drivetrain
     * @param power The power (-1 - 1) to be sent to the motors
     */
    void setLeft(double power){

        //Find out which motor needs to be negative
        leftFrontMotor.set(VictorSPXControlMode.PercentOutput, power);
        leftBackMotor.set(VictorSPXControlMode.PercentOutput,   power);

    }

    /**
     * Setting power to the right side of the drivetrain
     * @param power The power (-1 - 1) to be sent to the motors
     */
    void setRight(double power){
        //Find out which motor needs to be negative
        rightFrontMotor.set(VictorSPXControlMode.PercentOutput, -power);
        rightBackMotor.set(VictorSPXControlMode.PercentOutput,   -power);

    }

    void setMotors(AxisValue values){

        double max = Math.abs(values.getY());

        if(Math.abs(values.getX()) > max) {
            max = Math.abs(values.getX());
        }

        double sum = values.getY() + values.getX();
        double diff = values.getY() - values.getX();

        double d = 0;

        if(values.getY() >= 0){

            if(values.getX() >= 0){
                setLeft(max);
                setRight(diff);
            }
            else{
                setLeft(sum);
                setRight(max);
            }

        }
        else{

            if(values.getX() >= 0){
                setLeft(-max);
                setRight(sum);
            }
            else{
                setLeft(diff);
                setRight(-max);
            }

        }

    }

    double getDefaultSpeed(){

        return defaultSpeed;

    }

    double getDefaultTurnSpeed(){

        return defaultTurnSpeed;

    }

}