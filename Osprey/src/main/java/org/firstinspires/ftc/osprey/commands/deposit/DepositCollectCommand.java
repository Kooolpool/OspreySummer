package org.firstinspires.ftc.osprey.commands.deposit;

import com.technototes.library.command.ParallelCommandGroup;
import com.technototes.library.command.WaitCommand;
import org.firstinspires.ftc.osprey.commands.arm.ArmInCommand;
import org.firstinspires.ftc.osprey.commands.extension.ExtensionCollectCommand;
import org.firstinspires.ftc.osprey.commands.lift.LiftCollectCommand;
import org.firstinspires.ftc.osprey.commands.lift.LiftLevel1Command;
import org.firstinspires.ftc.osprey.subsystems.ArmSubsystem;
import org.firstinspires.ftc.osprey.subsystems.ExtensionSubsystem;
import org.firstinspires.ftc.osprey.subsystems.LiftSubsystem;

public class DepositCollectCommand extends ParallelCommandGroup {

    public DepositCollectCommand(
        ArmSubsystem arm,
        ExtensionSubsystem extension,
        LiftSubsystem lift
    ) {
        super(
            new WaitCommand(0.2).andThen(new ArmInCommand(arm)),
            new ExtensionCollectCommand(extension),
            new WaitCommand(0.2).andThen(
                new LiftLevel1Command(lift)
                    .withTimeout(0.5)
                    .alongWith(new WaitCommand(0.5))
                    .andThen(new LiftCollectCommand(lift).withTimeout(0.3))
            )
        );
    }
}
