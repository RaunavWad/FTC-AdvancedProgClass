package org.firstinspires.ftc.teamcode.opModes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.robot.Robot;
import org.firstinspires.ftc.teamcode.utils.myTelemetry;

@TeleOp(name = "Main Teleop")
public class mainTeleOp extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        myTelemetry.init(telemetry);
        Robot robot = new Robot(hardwareMap);


        waitForStart();

        while (opModeIsActive()) {
            //--------------GP1--------------
            myTelemetry.addLine("---GP1---");

            //gp1 buttons
            if (gamepad1.a) myTelemetry.addLine("GP1 A");
            if (gamepad1.b) myTelemetry.addLine("GP1 B");
            if (gamepad1.x) myTelemetry.addLine("GP1 X");
            if (gamepad1.y) myTelemetry.addLine("GP1 Y");

            //gp1 bumpers
            if (gamepad1.left_bumper) myTelemetry.addLine("GP1 LB");
            if (gamepad1.right_bumper) myTelemetry.addLine("GP1 RB");

            //gp1 triggers
            if (gamepad1.left_trigger > 0.05)
                myTelemetry.addLine("GP1 LT: " + gamepad1.left_trigger);
            if (gamepad1.right_trigger > 0.05)
                myTelemetry.addLine("GP1 RT: " + gamepad1.right_trigger);

            //gp1 DPAD
            if (gamepad1.dpad_up) myTelemetry.addLine("GP1 DPAD UP");
            if (gamepad1.dpad_down) myTelemetry.addLine("GP1 DPAD DOWN");
            if (gamepad1.dpad_left) myTelemetry.addLine("GP1 DPAD LEFT");
            if (gamepad1.dpad_right) myTelemetry.addLine("GP1 DPAD RIGHT");

            myTelemetry.addLine();

            //--------------GP2--------------
            myTelemetry.addLine("---GP2---");

            //gp2 buttons
            if (gamepad2.a) myTelemetry.addLine("GP2 A");
            if (gamepad2.b) myTelemetry.addLine("GP2 B");
            if (gamepad2.x) myTelemetry.addLine("GP2 X");
            if (gamepad2.y) myTelemetry.addLine("GP2 Y");

            //gp2 bumpers
            if (gamepad2.left_bumper) myTelemetry.addLine("GP2 LB");
            if (gamepad2.right_bumper) myTelemetry.addLine("GP2 RB");

            //gp2 triggers
            if (gamepad2.left_trigger > 0.05)
                myTelemetry.addLine("GP2 LT: " + gamepad2.left_trigger);

            if (gamepad2.right_trigger > 0.05)
                myTelemetry.addLine("GP2 RT: " + gamepad2.right_trigger);

            //gp2 DPAD
            if (gamepad2.dpad_up) myTelemetry.addLine("GP2 DPAD UP");
            if (gamepad2.dpad_down) myTelemetry.addLine("GP2 DPAD DOWN");
            if (gamepad2.dpad_left) myTelemetry.addLine("GP2 DPAD LEFT");
            if (gamepad2.dpad_right) myTelemetry.addLine("GP2 DPAD RIGHT");

            myTelemetry.update();
            robot.update();
        }
    }
}
