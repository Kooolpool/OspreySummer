package org.firstinspires.ftc.osprey.commands.autonomous;

import com.technototes.library.command.SequentialCommandGroup;
import com.technototes.library.command.WaitCommand;
import com.technototes.path.command.RegenerativeTrajectorySequenceCommand;
import org.firstinspires.ftc.osprey.RobotConstants;
import org.firstinspires.ftc.osprey.commands.arm.BucketDumpCommand;
import org.firstinspires.ftc.osprey.commands.deposit.DepositCycleAllianceCommand;
import org.firstinspires.ftc.osprey.commands.intake.IntakeOutCommand;
import org.firstinspires.ftc.osprey.subsystems.ArmSubsystem;
import org.firstinspires.ftc.osprey.subsystems.DrivebaseSubsystem;
import org.firstinspires.ftc.osprey.subsystems.ExtensionSubsystem;
import org.firstinspires.ftc.osprey.subsystems.IntakeSubsystem;
import org.firstinspires.ftc.osprey.subsystems.LiftSubsystem;

@com.acmerobotics.dashboard.config.Config
public class AutoDepositAllianceCommand extends SequentialCommandGroup {

    public static double TIME = 1;

    public AutoDepositAllianceCommand(
        DrivebaseSubsystem drive,
        IntakeSubsystem intake,
        LiftSubsystem lift,
        ArmSubsystem deposit,
        ExtensionSubsystem extension
    ) {
        super(
            drive::relocalize,
            new RegenerativeTrajectorySequenceCommand(
                drive,
                RobotConstants.WAREHOUSE_TO_HUB,
                drive
            ).alongWith(
                deposit::slightCarry,
                new WaitCommand(0.3)
                    .andThen(new IntakeOutCommand(intake))
                    .withTimeout(TIME)
                    .andThen(new DepositCycleAllianceCommand(deposit, extension, lift))
            ),
            new BucketDumpCommand(deposit)
        );
    }
}
