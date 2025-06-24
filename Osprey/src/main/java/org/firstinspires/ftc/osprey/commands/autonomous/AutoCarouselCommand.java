package org.firstinspires.ftc.osprey.commands.autonomous;

import com.technototes.library.command.SequentialCommandGroup;
import com.technototes.path.command.TrajectorySequenceCommand;
import org.firstinspires.ftc.osprey.RobotConstants;
import org.firstinspires.ftc.osprey.commands.carousel.CarouselSpinCommand;
import org.firstinspires.ftc.osprey.commands.deposit.DepositCollectCommand;
import org.firstinspires.ftc.osprey.subsystems.ArmSubsystem;
import org.firstinspires.ftc.osprey.subsystems.CarouselSubsystem;
import org.firstinspires.ftc.osprey.subsystems.DrivebaseSubsystem;
import org.firstinspires.ftc.osprey.subsystems.ExtensionSubsystem;
import org.firstinspires.ftc.osprey.subsystems.LiftSubsystem;

public class AutoCarouselCommand extends SequentialCommandGroup {

    public AutoCarouselCommand(
        DrivebaseSubsystem drive,
        LiftSubsystem lift,
        ArmSubsystem deposit,
        ExtensionSubsystem extension,
        CarouselSubsystem carousel
    ) {
        super(
            new TrajectorySequenceCommand(drive, RobotConstants.HUB_TO_CAROUSEL).alongWith(
                new DepositCollectCommand(deposit, extension, lift)
            ),
            new CarouselSpinCommand(carousel).withTimeout(4)
        );
    }
}
