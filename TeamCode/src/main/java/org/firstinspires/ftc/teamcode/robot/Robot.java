package org.firstinspires.ftc.teamcode.robot;

import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.utils.myTelemetry;
import java.util.List;

public class Robot {
    private static ElapsedTime elapsedTime;
    public List<LynxModule> hubs;
    DcMotor leftFront, rightFront, backLeft, backRight;

    public double loopTime;
    public float Hz;

    public Robot (HardwareMap hardwareMap) {
        elapsedTime = new ElapsedTime();
        elapsedTime.reset();

        leftFront = hardwareMap.get(DcMotor.class, "lf");
        rightFront = hardwareMap.get(DcMotor.class, "rf");
        backLeft = hardwareMap.get(DcMotor.class, "bl");
        backRight = hardwareMap.get(DcMotor.class, "br");

        hubs = hardwareMap.getAll(LynxModule.class);

        for (LynxModule hub : hubs) {
            hub.setBulkCachingMode(LynxModule.BulkCachingMode.MANUAL);
        }
    }

    public void update () {

        for(LynxModule hub : hubs){
            hub.clearBulkCache();
        }

        loopTime = elapsedTime.milliseconds();
        Hz = (float)(1000/loopTime);

        myTelemetry.addData("Loop Time", loopTime);
        myTelemetry.addData("Hz", Hz);
        myTelemetry.update();

        elapsedTime.reset();
    }
}
