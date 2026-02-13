package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "Robot Manual", group = "Manual")
public class RobotManual extends OpMode
{
   public DcMotor motor;

   public void init() {
      // Give name that is entered in driver station that maps to motor object
      motor = hardwareMap.get(DcMotor.class, "myMotor");

      // Set the directional rotation of motor relative to sign of input
      motor.setDirection((DcMotorSimple.Direction.FORWARD));

      // Set if motor will brake or coast when no input
      motor.setZeroPowerBehavior((DcMotor.ZeroPowerBehavior.BRAKE));

      // For safety, initialize motor power to zero so there is no unintentional movement.
      motor.setPower(0.0);
   }


   public void loop() {
      // Motors accept input from -1 to 1 for full power in either direction
      // Proportional values inbetween product lower power output
      double motorPower = gamepad1.right_stick_y;

      // Use gamepad right_stick_y output is proportional from -1 to 1
      // So we can send right_stick_y output value directly into motor power command
      motor.setPower(motorPower);
   }
}
