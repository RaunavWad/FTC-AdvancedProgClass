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
            //gp1 telemetry
            myTelemetry.addLine("---Gamepad 1---");

            myTelemetry.addLine();

            myTelemetry.addLine("---Buttons---"); //gp1 button telemetry
            myTelemetry.addData("A", gp1.a);
            myTelemetry.addData("B", gp1.b);
            myTelemetry.addData("X", gp1.x);
            myTelemetry.addData("Y", gp1.y);
            myTelemetry.addData("LB", gp1.left_bumper);
            myTelemetry.addData("RB", gp1.right_bumper);
            myTelemetry.addData("Back", gp1.back);
            myTelemetry.addData("Start", gp1.start);

            myTelemetry.addLine();

            myTelemetry.addLine("---Triggers---"); //gp1 trigger telemetry
            myTelemetry.addData("Left Trigger", gp1.left_trigger);
            myTelemetry.addData("Right Trigger", gp1.right_trigger);

            myTelemetry.addLine();

            myTelemetry.addLine("---Joysticks---"); //gp1 joystick telemetry
            myTelemetry.addData("Left Stick X", gp1.left_stick_x);
            myTelemetry.addData("Left Stick Y", gp1.left_stick_y);
            myTelemetry.addData("Right Stick X", gp1.right_stick_x);
            myTelemetry.addData("Right Stick Y", gp1.right_stick_y);

            myTelemetry.addLine();

            myTelemetry.addLine("---DPAD---"); //gp1 DPAD telemetry
            myTelemetry.addData("Up", gp1.dpad_up);
            myTelemetry.addData("Down", gp1.dpad_down);
            myTelemetry.addData("Left", gp1.dpad_left);
            myTelemetry.addData("Right", gp1.dpad_right);

            myTelemetry.addLine();
            myTelemetry.addLine();

            //gp2 telemetry
            myTelemetry.addLine("---Gamepad 2---");


            myTelemetry.addLine("---Buttons---"); //gp2 button telemetry
            myTelemetry.addData("A", gp2.a);
            myTelemetry.addData("B", gp2.b);
            myTelemetry.addData("X", gp2.x);
            myTelemetry.addData("Y", gp2.y);
            myTelemetry.addData("LB", gp2.left_bumper);
            myTelemetry.addData("RB", gp2.right_bumper);

            myTelemetry.addLine();

            myTelemetry.addLine("---Triggers---"); //gp2 trigger telemetry
            myTelemetry.addData("Left Trigger", gp2.left_trigger);
            myTelemetry.addData("Right Trigger", gp2.right_trigger);

            myTelemetry.addLine();

            myTelemetry.addLine("---Joysticks---"); //gp2 joystick telemetry
            myTelemetry.addData("Left Stick X", gp2.left_stick_x);
            myTelemetry.addData("Left Stick Y", gp2.left_stick_y);
            myTelemetry.addData("Right Stick X", gp2.right_stick_x);
            myTelemetry.addData("Right Stick Y", gp2.right_stick_y);

            myTelemetry.addLine();

            myTelemetry.addLine("---DPad---"); //gp2 DPAD telemetry
            myTelemetry.addData("Up", gp2.dpad_up);
            myTelemetry.addData("Down", gp2.dpad_down);
            myTelemetry.addData("Left", gp2.dpad_left);
            myTelemetry.addData("Right", gp2.dpad_right);

            myTelemetry.update();
            robot.update();

        }
    }
}
