package org.firstinspires.ftc.osprey.commands.deposit;

import com.technototes.library.command.ParallelCommandGroup;
import com.technototes.library.command.WaitCommand;
import org.firstinspires.ftc.osprey.commands.arm.ArmAllianceCommand;
import org.firstinspires.ftc.osprey.commands.extension.ExtensionOutCommand;
import org.firstinspires.ftc.osprey.commands.lift.LiftLevel3Command;
import org.firstinspires.ftc.osprey.subsystems.ArmSubsystem;
import org.firstinspires.ftc.osprey.subsystems.ExtensionSubsystem;
import org.firstinspires.ftc.osprey.subsystems.LiftSubsystem;

public class DepositAllianceCommand extends ParallelCommandGroup {

    public DepositAllianceCommand(
        ArmSubsystem arm,
        ExtensionSubsystem extension,
        LiftSubsystem lift
    ) {
        super(
            new LiftLevel3Command(lift).withTimeout(1),
            new WaitCommand(0).andThen(new ExtensionOutCommand(extension)),
            new ArmAllianceCommand(arm)
        );
    }
}
