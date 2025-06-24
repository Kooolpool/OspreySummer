package org.firstinspires.ftc.osprey.commands.autonomous;

import com.technototes.library.command.SequentialCommandGroup;
import com.technototes.library.command.WaitCommand;
import com.technototes.path.command.TrajectorySequenceCommand;
import org.firstinspires.ftc.osprey.RobotConstants;
import org.firstinspires.ftc.osprey.commands.deposit.DepositCollectCommand;
import org.firstinspires.ftc.osprey.commands.intake.IntakeInCommand;
import org.firstinspires.ftc.osprey.subsystems.ArmSubsystem;
import org.firstinspires.ftc.osprey.subsystems.DrivebaseSubsystem;
import org.firstinspires.ftc.osprey.subsystems.ExtensionSubsystem;
import org.firstinspires.ftc.osprey.subsystems.IntakeSubsystem;
import org.firstinspires.ftc.osprey.subsystems.LiftSubsystem;

public class AutoIntakeWarehouseCommand extends SequentialCommandGroup {

    public AutoIntakeWarehouseCommand(
        DrivebaseSubsystem drive,
        IntakeSubsystem intake,
        LiftSubsystem lift,
        ArmSubsystem deposit,
        ExtensionSubsystem extension,
        int cycle
    ) {
        super(
            new TrajectorySequenceCommand(drive, RobotConstants.HUB_TO_WAREHOUSE, cycle)
                .alongWith(new WaitCommand(1.4).andThen(new IntakeInCommand(intake)))
                .alongWith(new DepositCollectCommand(deposit, extension, lift))
        );
    }
}
