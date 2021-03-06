package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();
  
  private Scar scar;
  private Controller driveController;
  private Controller opController;
  
  private double speedMultiplier = 1;

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);

    driveController = new Controller(0);
    opController = new Controller(1);
    scar = new Scar();

  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to
   * the switch structure below with additional strings. If using the
   * SendableChooser make sure to add them to the chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    // autoSelected = SmartDashboard.getString("Auto Selector",
    // defaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);

    //scar.intake.setSolenoid(Value.kForward);

  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    switch (m_autoSelected) {
      case kCustomAuto:
        // Put custom auto code here
        break;
      case kDefaultAuto:
      default:
        // Put default auto code here
        break;
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {

    

  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
    opControls();
    driveControls();
  }

  void opControls(){

    scar.shooter.setWheelSpeed(opController.getCleansedTriggers().getY());

    if(opController.getPOV() == 0)
      scar.shooter.elevateUp();

    else if(opController.getPOV() == 180)
      scar.shooter.elevateDown();

    else
      scar.shooter.stopElevator();

    if(opController.getAButtonPressed())
      scar.shooter.toggleAngle();

    if(opController.getBButtonPressed())
      scar.intake.toggleSolenoid();

  }

  void driveControls() {
    
    AxisValue axisValues = driveController.getCleansedAxes();
    AxisValue triggerValues = driveController.getCleansedTriggers();

    //Right Bumper - Boost
    if(driveController.getBumper(Hand.kRight)) {

      speedMultiplier = scar.drivetrain.getBoostSpeed();

    //Left Bumper - Crawl
    } else if(driveController.getBumper(Hand.kLeft)) {

      speedMultiplier = scar.drivetrain.getCrawlSpeed();

    } else {

      speedMultiplier = scar.drivetrain.getDefaultSpeed();

    }

    //Left Stick - Drive, Right Stick - Turn
    scar.drivetrain.setMotors(new AxisValue(axisValues.getX() * scar.drivetrain.getDefaultTurnSpeed(), axisValues.getY() * speedMultiplier));

    //B Button - Climber Up
    if(driveController.getBButton()) {

      scar.climber.climb(1);

    } 

    // //A Button - Climber Down
    else if(driveController.getAButton()) {

      scar.climber.climb(-1);

    }

    //Left Trigger - Intake In
      scar.intake.ballIn(triggerValues.getX());

    //Right Trigger - Intake Out
      scar.intake.ballOut(triggerValues.getY());
  }
  
}
