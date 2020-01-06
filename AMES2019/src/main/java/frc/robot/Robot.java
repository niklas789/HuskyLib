/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.biblioteca.*;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Compressor;
import frc.robot.RobotConstants;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  Solenoid piston;
  TalonSRX rightMaster;
  TalonSRX leftMaster;
  //TalonSRX largeIntake;
  //TalonSRX smallIntake;
  VictorSPX rightSlave;
  VictorSPX leftSlave;
  Compressor airCompressor;
  HuskyJoystick driveControl;

  @Override
  public void robotInit() {
    piston = new Solenoid(RobotConstants.defensePistonPort);
    airCompressor = new Compressor();
    driveControl = new HuskyJoystick(RobotConstants.joystickNumber);
    driveControl.setDeadZone(RobotConstants.joystickDeadZone);
    //Motors
    rightMaster = new TalonSRX(RobotConstants.rightMasterPort);
    leftMaster = new TalonSRX(RobotConstants.leftMasterPort);
    rightSlave = new VictorSPX(RobotConstants.rightSlavePort);
    leftSlave = new VictorSPX(RobotConstants.leftSlavePort);
    //largeIntake = new TalonSRX(RobotConstants.largeIntakePort);
    //smallIntake = new TalonSRX(RobotConstants.largeIntakePort);

    rightMaster.setInverted(RobotConstants.rightInvert);
    leftMaster.setInverted(RobotConstants.leftInvert);
    leftSlave.follow(leftMaster);
    rightSlave.follow(rightMaster);
    //largeIntake.setInverted(RobotConstants.largeInvert);
    //smallIntake.setInverted(RobotConstants.smallInvert);
  }
  @Override
  public void robotPeriodic() {
  }
  @Override
  public void autonomousInit() {

  }
  @Override
  public void autonomousPeriodic() {
    airCompressor.start();
    piston.set(true);
  }
  @Override
  public void teleopPeriodic() {
    piston.set(driveControl.getButton(RobotConstants.pistonButton));
    airCompressor.start();
    rightMaster.set(ControlMode.PercentOutput, (driveControl.getAxis(RobotConstants.forwardAxis) - driveControl.getAxis(RobotConstants.twistAxis)));
    leftMaster.set(ControlMode.PercentOutput, (driveControl.getAxis(RobotConstants.forwardAxis) + driveControl.getAxis(RobotConstants.twistAxis)));
    
    /*if(driveControl.getButton(RobotConstants.largeIntakeButton)) {
      largeIntake.set(ControlMode.PercentOutput, RobotConstants.largeIntakeSpeed);
    }
    if(driveControl.getButton(RobotConstants.smallIntakeButton)) {
      smallIntake.set(ControlMode.PercentOutput, RobotConstants.smallIntakeSpeed);
    }*/
    
  }
  @Override
  public void testPeriodic() {
  }
}
