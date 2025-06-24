package org.firstinspires.ftc.osprey.opmodes.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.technototes.library.command.CommandScheduler;
import com.technototes.library.logger.Loggable;
import com.technototes.library.structure.CommandOpMode;
import com.technototes.library.util.Alliance;
import org.firstinspires.ftc.osprey.Hardware;
import org.firstinspires.ftc.osprey.Robot;
import org.firstinspires.ftc.osprey.RobotConstants;
import org.firstinspires.ftc.osprey.commands.autonomous.AutoCycleCommand;
import org.firstinspires.ftc.osprey.commands.vision.VisionBarcodeCommand;

public abstract class AutoCycleBase extends CommandOpMode implements Loggable {

    public Robot robot;
    public Hardware hardware;

    @Override
    public void uponInit() {
        RobotConstants.updateAlliance(Alliance.get(getClass()));
        hardware = new Hardware();
        robot = new Robot(hardware);
        CommandScheduler.scheduleInit(new VisionBarcodeCommand(robot.visionSubsystem));
        CommandScheduler.scheduleOnceForState(
            new AutoCycleCommand(
                robot.drivebaseSubsystem,
                robot.intakeSubsystem,
                robot.liftSubsystem,
                robot.armSubsystem,
                robot.extensionSubsystem,
                robot.visionSubsystem
            ),
            OpModeState.RUN
        );
    }

    @Override
    public void uponStart() {
        if (Robot.SubsystemConstants.CAP_ENABLED) robot.capSubsystem.up();
    }

    @Override
    public void end() {}

    @Autonomous(name = "\uD83D\uDD35 ♻️ Blue Cycle")
    @Alliance.Blue
    public static class CycleBlueAuto extends AutoCycleBase {}

    @Autonomous(name = "\uD83D\uDFE5 ♻️ Red Cycle")
    @Alliance.Red
    public static class CycleRedAuto extends AutoCycleBase {}
}
