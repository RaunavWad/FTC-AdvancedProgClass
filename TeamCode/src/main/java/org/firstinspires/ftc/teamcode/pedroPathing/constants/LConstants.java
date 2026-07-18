package org.firstinspires.ftc.teamcode.pedroPathing.constants;

import com.pedropathing.localization.*;
import com.pedropathing.localization.constants.*;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;

//USES PALINDROMES BOT
public class LConstants {
    static {
        TwoWheelConstants.forwardTicksToInches = 0.001989436789;
        TwoWheelConstants.strafeTicksToInches = 0.001989436789;
        TwoWheelConstants.forwardY = 6;
        TwoWheelConstants.strafeX = -3;
        TwoWheelConstants.forwardEncoder_HardwareMapName = "RBM";
        TwoWheelConstants.strafeEncoder_HardwareMapName = "LFM";
        TwoWheelConstants.forwardEncoderDirection = Encoder.REVERSE;
        TwoWheelConstants.strafeEncoderDirection = Encoder.REVERSE;
        TwoWheelConstants.IMU_HardwareMapName = "imu";
        TwoWheelConstants.IMU_Orientation = new RevHubOrientationOnRobot(RevHubOrientationOnRobot.LogoFacingDirection.UP, RevHubOrientationOnRobot.UsbFacingDirection.LEFT);
    }
}