/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.pidcontroller;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.Constant;

/**
 * Add your docs here.
 */
public class LiftPID extends PIDSubsystem {

  public LiftPID() {
    // Intert a subsystem name and PID values here
    super("LiftPID",1,0,0);
    getPIDController().setContinuous(true);
    setOutputRange(-1, 1);
    setSetpoint(0);
    setAbsoluteTolerance(Constant.liftPIDTolerance);
    // Use these to get going:
    // setSetpoint() - Sets where the PID controller should move the system
    // to
    // enable() - Enables the PID controller.
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  @Override
  protected double returnPIDInput() {
    // Return your input value for the PID loop
    // e.g. a sensor, like a potentiometer:
    // yourPot.getAverageVoltage() / kYourMaxVoltage;
    return RobotMap.liftEncoder.getDistance();
  }

  @Override
  protected void usePIDOutput(double output) {
    // Use output to drive your system, like a motor
    // e.g. yourMotor.set(output);
    Robot.liftSubsystem.operateLift(output);
  }

  @Override
  public void disable() {
    super.disable();
    Robot.liftSubsystem.stopLift();
  }
}