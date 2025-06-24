package org.firstinspires.ftc.osprey.commands.extension;

import static org.firstinspires.ftc.osprey.RobotConstants.getAlliance;
import static org.firstinspires.ftc.osprey.RobotState.SharedHubStrategy.OWN;
import static org.firstinspires.ftc.osprey.RobotState.SharedHubStrategy.STEAL;
import static org.firstinspires.ftc.osprey.RobotState.getSharedStrategy;
import static org.firstinspires.ftc.osprey.subsystems.ExtensionSubsystem.ExtensionConstants.LEFT;
import static org.firstinspires.ftc.osprey.subsystems.ExtensionSubsystem.ExtensionConstants.RIGHT;
import static org.firstinspires.ftc.osprey.subsystems.ExtensionSubsystem.ExtensionConstants.SHARED;
import static org.firstinspires.ftc.osprey.subsystems.ExtensionSubsystem.ExtensionConstants.STEAL_SHARED;

import android.util.Pair;
import com.technototes.library.command.ChoiceCommand;
import org.firstinspires.ftc.osprey.subsystems.ExtensionSubsystem;

public class ExtensionSideCommand extends ChoiceCommand {

    public ExtensionSideCommand(ExtensionSubsystem subsystem) {
        super(
            new Pair<>(
                () -> getSharedStrategy() == OWN,
                new ExtensionOutCommand(subsystem, SHARED, getAlliance().selectOf(RIGHT, LEFT))
            ),
            new Pair<>(
                () -> getSharedStrategy() == STEAL,
                new ExtensionOutCommand(
                    subsystem,
                    STEAL_SHARED,
                    getAlliance().selectOf(LEFT, RIGHT)
                )
            )
        );
    }
}
