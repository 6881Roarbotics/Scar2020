class Scar {

    Drivetrain drivetrain;
    Shooter shooter;
    Intake intake;
    Climber climber;
    Controller controller;

    Scar(){

        drivetrain = new Drivetrain();
        shooter = new Shooter();
        intake = new Intake();
        climber = new Climber();
        controller = new Controller();
        
    }

}