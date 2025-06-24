package org.firstinspires.ftc.osprey.commands.autonomous;

import com.technototes.library.command.SequentialCommandGroup;
import com.technototes.library.command.WaitCommand;
import com.technototes.path.command.TrajectorySequenceCommand;
import org.firstinspires.ftc.osprey.RobotConstants;
import org.firstinspires.ftc.osprey.commands.arm.BucketDumpCommand;
import org.firstinspires.ftc.osprey.commands.deposit.DepositAllianceCommand;
import org.firstinspires.ftc.osprey.commands.intake.IntakeOutCommand;
import org.firstinspires.ftc.osprey.subsystems.ArmSubsystem;
import org.firstinspires.ftc.osprey.subsystems.DrivebaseSubsystem;
import org.firstinspires.ftc.osprey.subsystems.ExtensionSubsystem;
import org.firstinspires.ftc.osprey.subsystems.IntakeSubsystem;
import org.firstinspires.ftc.osprey.subsystems.LiftSubsystem;

public class AutoDepositDuckCommand extends SequentialCommandGroup {

    public AutoDepositDuckCommand(
        DrivebaseSubsystem drive,
        ArmSubsystem depot,
        ExtensionSubsystem extension,
        LiftSubsystem lift,
        IntakeSubsystem intake
    ) {
        super(
            new TrajectorySequenceCommand(drive, RobotConstants.DUCK_INTAKE_TO_HUB).alongWith(
                new WaitCommand(0.3).andThen(new IntakeOutCommand(intake)).withTimeout(0.6),
                depot::slightCarry,
                new WaitCommand(0.3).andThen(new DepositAllianceCommand(depot, extension, lift))
            ),
            new BucketDumpCommand(depot).sleep(0.3)
        );
    }
}
