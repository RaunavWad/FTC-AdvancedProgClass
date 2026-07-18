package org.firstinspires.ftc.teamcode.opModes;
import com.pedropathing.follower.Follower;
import com.pedropathing.localization.Pose;
import com.pedropathing.pathgen.BezierCurve;
import com.pedropathing.pathgen.BezierLine;
import com.pedropathing.pathgen.PathChain;
import com.pedropathing.util.Constants;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.pedroPathing.constants.FConstants;
import org.firstinspires.ftc.teamcode.pedroPathing.constants.LConstants;
@Autonomous(name = "Close Blue Pedro Auto", group = "Autonomous")
public class closeBluePedroAuto extends LinearOpMode {
    private Follower follower;
    private Paths paths;
    private int pathState = 0;
    private final Pose startPose =
            new Pose(21.252, 124.617, Math.toRadians(140));
    public static class Paths {
        public PathChain Preload;
        public PathChain Intake1;
        public PathChain Shoot1;
        public PathChain Intake2;
        public PathChain Shoot2;
        public PathChain Intake3;
        public PathChain Shoot3Leave;
        public Paths(Follower follower) {
            Preload = follower.pathBuilder()
                    .addPath(
                            new BezierLine(
                                    new Pose(21.252, 124.617),
                                    new Pose(57.271, 84.523)
                            )
                    )
                    .setLinearHeadingInterpolation(
                            Math.toRadians(140),
                            Math.toRadians(130)
                    )
                    .build();
            Intake1 = follower.pathBuilder()
                    .addPath(
                            new BezierLine(
                                    new Pose(57.271, 84.523),
                                    new Pose(17.056, 83.159)
                            )
                    )
                    .setLinearHeadingInterpolation(
                            Math.toRadians(130),
                            Math.toRadians(180)
                    )
                    .build();
            Shoot1 = follower.pathBuilder()
                    .addPath(
                            new BezierLine(
                                    new Pose(17.056, 83.159),
                                    new Pose(56.972, 84.561)
                            )
                    )
                    .setLinearHeadingInterpolation(
                            Math.toRadians(180),
                            Math.toRadians(130)
                    )
                    .build();
            Intake2 = follower.pathBuilder()
                    .addPath(
                            new BezierCurve(
                                    new Pose(56.972, 84.561),
                                    new Pose(50.466, 56.019),
                                    new Pose(13.458, 58.991)
                            )
                    )
                    .setLinearHeadingInterpolation(
                            Math.toRadians(130),
                            Math.toRadians(180)
                    )
                    .build();
            Shoot2 = follower.pathBuilder()
                    .addPath(
                            new BezierLine(
                                    new Pose(13.458, 58.991),
                                    new Pose(57.000, 84.533)
                            )
                    )
                    .setLinearHeadingInterpolation(
                            Math.toRadians(180),
                            Math.toRadians(130)
                    )
                    .build();
            Intake3 = follower.pathBuilder()
                    .addPath(
                            new BezierCurve(
                                    new Pose(57.000, 84.533),
                                    new Pose(59.075, 30.977),
                                    new Pose(10.832, 35.252)
                            )
                    )
                    .setLinearHeadingInterpolation(
                            Math.toRadians(130),
                            Math.toRadians(180)
                    )
                    .build();
            Shoot3Leave = follower.pathBuilder()
                    .addPath(
                            new BezierLine(
                                    new Pose(10.832, 35.252),
                                    new Pose(59.944, 115.290)
                            )
                    )
                    .setLinearHeadingInterpolation(
                            Math.toRadians(180),
                            Math.toRadians(150)
                    )
                    .build();
        }
    }
    @Override
    public void runOpMode() throws InterruptedException {
        Constants.setConstants(FConstants.class, LConstants.class);
        follower = new Follower(hardwareMap, LConstants.class, FConstants.class);
        follower.setStartingPose(startPose);
        paths = new Paths(follower);
        telemetry.addLine("Basic Pedro Linear Auto initialized");
        telemetry.addData("Starting X", startPose.getX());
        telemetry.addData("Starting Y", startPose.getY());
        telemetry.addData(
                "Starting Heading",
                Math.toDegrees(startPose.getHeading())
        );
        telemetry.update();
        waitForStart();
        if (isStopRequested()) {
            return;
        }

        follower.followPath(paths.Preload, true);
        pathState = 1;
        while (opModeIsActive()) {
            follower.update();
            autonomousPathUpdate();
            telemetry.addData("Path State", pathState);
            telemetry.addData("Follower Busy", follower.isBusy());
            telemetry.addData("X", follower.getPose().getX());
            telemetry.addData("Y", follower.getPose().getY());
            telemetry.addData(
                    "Heading Degrees",
                    Math.toDegrees(follower.getPose().getHeading())
            );
            telemetry.update();
        }
    }
    private void autonomousPathUpdate() {
        switch (pathState) {
            case 1:
                if (!follower.isBusy()) {
                    follower.followPath(paths.Intake1, true);
                    pathState = 2;
                }
                break;
            case 2:
                if (!follower.isBusy()) {
                    follower.followPath(paths.Shoot1, true);
                    pathState = 3;
                }
                break;
            case 3:
                if (!follower.isBusy()) {
                    follower.followPath(paths.Intake2, true);
                    pathState = 4;
                }
                break;
            case 4:
                if (!follower.isBusy()) {
                    follower.followPath(paths.Shoot2, true);
                    pathState = 5;
                }
                break;
            case 5:
                if (!follower.isBusy()) {
                    follower.followPath(paths.Intake3, true);
                    pathState = 6;
                }
                break;
            case 6:
                if (!follower.isBusy()) {
                    follower.followPath(paths.Shoot3Leave, true);
                    pathState = 7;
                }
                break;
            case 7:
                if (!follower.isBusy()) {
                    pathState = -1;
                }
                break;
            case -1:
                break;
        }
    }
}