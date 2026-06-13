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

        Gamepad gp1 = new Gamepad();
        Gamepad gp2 = new Gamepad();

        waitForStart();

        while (opModeIsActive()) {
            //--------------GP1--------------
            myTelemetry.addLine("---GP1---");

            //gp1 buttons
            if (gp1.a) myTelemetry.addLine("GP1 A");
            if (gp1.b) myTelemetry.addLine("GP1 B");
            if (gp1.x) myTelemetry.addLine("GP1 X");
            if (gp1.y) myTelemetry.addLine("GP1 Y");

            //gp1 bumpers
            if (gp1.left_bumper) myTelemetry.addLine("GP1 LB");
            if (gp1.right_bumper) myTelemetry.addLine("GP1 RB");

            //gp1 triggers
            if (gp1.left_trigger > 0.05)
                myTelemetry.addData("GP1 LT", gp1.left_trigger);
            if (gp1.right_trigger > 0.05)
                myTelemetry.addData("GP1 RT", gp1.right_trigger);

            //gp1 DPAD
            if (gp1.dpad_up) myTelemetry.addLine("GP1 DPAD UP");
            if (gp1.dpad_down) myTelemetry.addLine("GP1 DPAD DOWN");
            if (gp1.dpad_left) myTelemetry.addLine("GP1 DPAD LEFT");
            if (gp1.dpad_right) myTelemetry.addLine("GP1 DPAD RIGHT");

            myTelemetry.addLine();

            //--------------GP2--------------
            myTelemetry.addLine("---GP2---");

            //gp2 buttons
            if (gp2.a) myTelemetry.addLine("GP2 A");
            if (gp2.b) myTelemetry.addLine("GP2 B");
            if (gp2.x) myTelemetry.addLine("GP2 X");
            if (gp2.y) myTelemetry.addLine("GP2 Y");

            //gp2 bumpers
            if (gp2.left_bumper) myTelemetry.addLine("GP2 LB");
            if (gp2.right_bumper) myTelemetry.addLine("GP2 RB");

            //gp2 triggers
            if (gp2.left_trigger > 0.05)
                myTelemetry.addData("GP2 LT", gp2.left_trigger);

            if (gp2.right_trigger > 0.05)
                myTelemetry.addData("GP2 RT", gp2.right_trigger);

            //gp2 DPAD
            if (gp2.dpad_up) myTelemetry.addLine("GP2 DPAD UP");
            if (gp2.dpad_down) myTelemetry.addLine("GP2 DPAD DOWN");
            if (gp2.dpad_left) myTelemetry.addLine("GP2 DPAD LEFT");
            if (gp2.dpad_right) myTelemetry.addLine("GP2 DPAD RIGHT");

            myTelemetry.update();
            robot.update();
        }
    }
}
