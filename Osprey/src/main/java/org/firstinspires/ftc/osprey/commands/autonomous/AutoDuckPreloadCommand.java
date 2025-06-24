package org.firstinspires.ftc.osprey.commands.autonomous;

import com.technototes.library.command.SequentialCommandGroup;
import com.technototes.path.command.TrajectorySequenceCommand;
import org.firstinspires.ftc.osprey.RobotConstants;
import org.firstinspires.ftc.osprey.commands.arm.BucketDumpCommand;
import org.firstinspires.ftc.osprey.commands.deposit.DepositPreloadCommand;
import org.firstinspires.ftc.osprey.subsystems.ArmSubsystem;
import org.firstinspires.ftc.osprey.subsystems.DrivebaseSubsystem;
import org.firstinspires.ftc.osprey.subsystems.ExtensionSubsystem;
import org.firstinspires.ftc.osprey.subsystems.LiftSubsystem;
import org.firstinspires.ftc.osprey.subsystems.VisionSubsystem;

public class AutoDuckPreloadCommand extends SequentialCommandGroup {

    public AutoDuckPreloadCommand(
        DrivebaseSubsystem drive,
        ArmSubsystem depot,
        ExtensionSubsystem extension,
        LiftSubsystem lift,
        VisionSubsystem vision
    ) {
        super(
            new TrajectorySequenceCommand(drive, RobotConstants.DUCK_DEPOSIT_PRELOAD).alongWith(
                new DepositPreloadCommand(depot, extension, lift, vision)
            ),
            new BucketDumpCommand(depot)
        );
    }
}
