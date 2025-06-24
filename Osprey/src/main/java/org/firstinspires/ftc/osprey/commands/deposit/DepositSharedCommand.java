package org.firstinspires.ftc.osprey.commands.deposit;

import com.technototes.library.command.ParallelCommandGroup;
import org.firstinspires.ftc.osprey.commands.arm.ArmSharedCommand;
import org.firstinspires.ftc.osprey.commands.extension.ExtensionSideCommand;
import org.firstinspires.ftc.osprey.commands.lift.LiftSharedCommand;
import org.firstinspires.ftc.osprey.subsystems.ArmSubsystem;
import org.firstinspires.ftc.osprey.subsystems.ExtensionSubsystem;
import org.firstinspires.ftc.osprey.subsystems.LiftSubsystem;

public class DepositSharedCommand extends ParallelCommandGroup {

    public DepositSharedCommand(
        ArmSubsystem arm,
        ExtensionSubsystem extension,
        LiftSubsystem lift
    ) {
        super(
            new LiftSharedCommand(lift),
            new ExtensionSideCommand(extension),
            new ArmSharedCommand(arm)
        );
    }
}
