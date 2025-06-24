package org.firstinspires.ftc.osprey.commands.autonomous;

import com.technototes.library.command.CommandScheduler;
import com.technototes.library.command.SequentialCommandGroup;
import org.firstinspires.ftc.osprey.RobotConstants;
import org.firstinspires.ftc.osprey.subsystems.ArmSubsystem;
import org.firstinspires.ftc.osprey.subsystems.CarouselSubsystem;
import org.firstinspires.ftc.osprey.subsystems.DrivebaseSubsystem;
import org.firstinspires.ftc.osprey.subsystems.ExtensionSubsystem;
import org.firstinspires.ftc.osprey.subsystems.IntakeSubsystem;
import org.firstinspires.ftc.osprey.subsystems.LiftSubsystem;
import org.firstinspires.ftc.osprey.subsystems.VisionSubsystem;

public class AutoDuckCommand extends SequentialCommandGroup {

    public AutoDuckCommand(
        DrivebaseSubsystem drive,
        IntakeSubsystem intake,
        LiftSubsystem lift,
        ArmSubsystem deposit,
        ExtensionSubsystem extension,
        VisionSubsystem vision,
        CarouselSubsystem carousel
    ) {
        super(
            () -> drive.setPoseEstimate(RobotConstants.DUCK_START_SELECT.get()),
            () ->
                drive.distanceSensorLocalizer.setGyroOffset(
                    -RobotConstants.DUCK_START_SELECT.get().getHeading()
                ),
            //drive::relocalize,
            new AutoDuckPreloadCommand(drive, deposit, extension, lift, vision),
            new AutoCarouselCommand(drive, lift, deposit, extension, carousel),
            new AutoIntakeDuckCommand(drive, intake),
            new AutoDepositDuckCommand(drive, deposit, extension, lift, intake),
            new AutoParkBarrierCommand(drive, lift, deposit, extension),
            CommandScheduler::terminateOpMode
        );
    }
}
