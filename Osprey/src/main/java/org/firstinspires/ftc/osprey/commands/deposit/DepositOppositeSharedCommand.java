package org.firstinspires.ftc.osprey.commands.deposit;

import static org.firstinspires.ftc.osprey.subsystems.ExtensionSubsystem.ExtensionConstants.OUT;

import com.technototes.library.command.ParallelCommandGroup;
import com.technototes.library.util.Alliance;
import org.firstinspires.ftc.osprey.RobotConstants;
import org.firstinspires.ftc.osprey.commands.arm.ArmAllianceCommand;
import org.firstinspires.ftc.osprey.commands.extension.ExtensionLeftSideCommand;
import org.firstinspires.ftc.osprey.commands.extension.ExtensionRightSideCommand;
import org.firstinspires.ftc.osprey.commands.lift.LiftSharedCommand;
import org.firstinspires.ftc.osprey.subsystems.ArmSubsystem;
import org.firstinspires.ftc.osprey.subsystems.ExtensionSubsystem;
import org.firstinspires.ftc.osprey.subsystems.LiftSubsystem;

public class DepositOppositeSharedCommand extends ParallelCommandGroup {

    public DepositOppositeSharedCommand(
        ArmSubsystem arm,
        ExtensionSubsystem extension,
        LiftSubsystem lift
    ) {
        super(
            new LiftSharedCommand(lift),
            Alliance.Selector.selectOf(
                RobotConstants.getAlliance(),
                new ExtensionLeftSideCommand(extension, OUT),
                new ExtensionRightSideCommand(extension, OUT)
            ),
            new ArmAllianceCommand(arm)
        );
    }
}
