package frc.robot;

class AxisValue{

    private double X = 0.0;
    private double Y = 0.0;

    AxisValue(double X, double Y){

        this.X = X;
        this.Y = Y;

    }

    public double getX(){

        return X;

    }

    public double getY(){

        return Y;

    }

    public void setX(double value){

        X = value;

    }

    public void setY(double value){

        Y = value;

    }

}