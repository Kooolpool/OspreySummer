package org.firstinspires.ftc.osprey.commands.deposit;

import com.technototes.library.command.ParallelCommandGroup;
import org.firstinspires.ftc.osprey.commands.arm.ArmAllianceCommand;
import org.firstinspires.ftc.osprey.commands.extension.ExtensionOutCommand;
import org.firstinspires.ftc.osprey.commands.lift.LiftLevel3Command;
import org.firstinspires.ftc.osprey.subsystems.ArmSubsystem;
import org.firstinspires.ftc.osprey.subsystems.ExtensionSubsystem;
import org.firstinspires.ftc.osprey.subsystems.LiftSubsystem;

public class DepositCycleAllianceCommand extends ParallelCommandGroup {

    public DepositCycleAllianceCommand(
        ArmSubsystem arm,
        ExtensionSubsystem extension,
        LiftSubsystem lift
    ) {
        super(
            new LiftLevel3Command(lift).withTimeout(1),
            //new WaitCommand(0).andThen(new ExtensionOutCommand(extension, RobotConstants.getAlliance().selectOf(ExtensionSubsystem.ExtensionConstants.AUTO_LEFT, ExtensionSubsystem.ExtensionConstants.AUTO_RIGHT))),
            new ExtensionOutCommand(extension),
            new ArmAllianceCommand(arm)
        );
    }
}
