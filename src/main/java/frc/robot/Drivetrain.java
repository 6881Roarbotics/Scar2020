package frc.robot;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

class Drivetrain {

    private VictorSPX leftFrontMotor;
    private VictorSPX leftBackMotor;
    private VictorSPX rightFrontMotor;
    private VictorSPX rightBackMotor;

    private final double defaultSpeed;
    private final double defaultTurnSpeed;
    private final double boostSpeed;
    private final double crawlSpeed;

    Drivetrain(){

        leftFrontMotor = new VictorSPX(CAN.DRIVETRAIN_LEFT_FRONT);
        leftBackMotor = new VictorSPX(CAN.DRIVETRAIN_LEFT_BACK);
        rightFrontMotor = new VictorSPX(CAN.DRIVETRAIN_RIGHT_FRONT);
        rightBackMotor = new VictorSPX(CAN.DRIVETRAIN_RIGHT_BACK);

        defaultSpeed = 0.5;
        defaultTurnSpeed = 0.5;
        boostSpeed = 0.7;
        crawlSpeed = 0.3;
        
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

        double max = Math.abs(Math.pow(values.getY(), 3));

        if(Math.abs(Math.pow(values.getX(), 3)) > max) {
            max = Math.abs(Math.pow(values.getX(), 3));
        }

        double sum = Math.pow(values.getY(), 3) + Math.pow(values.getX(), 3);
        double diff = Math.pow(values.getY(), 3) - Math.pow(values.getX(), 3);

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
    
    double getBoostSpeed(){

        return boostSpeed;

    }

    double getCrawlSpeed(){

        return crawlSpeed;

    }

}