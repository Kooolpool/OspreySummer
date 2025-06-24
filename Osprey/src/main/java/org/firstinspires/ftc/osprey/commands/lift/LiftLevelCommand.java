package org.firstinspires.ftc.osprey.commands.lift;

import static org.firstinspires.ftc.osprey.RobotState.AllianceHubStrategy.HIGH;
import static org.firstinspires.ftc.osprey.RobotState.AllianceHubStrategy.MID;
import static org.firstinspires.ftc.osprey.RobotState.getAllianceStrategy;

import android.util.Pair;
import com.technototes.library.command.ChoiceCommand;
import org.firstinspires.ftc.osprey.subsystems.LiftSubsystem;

public class LiftLevelCommand extends ChoiceCommand {

    public LiftLevelCommand(LiftSubsystem ls) {
        super(
            new Pair<>(() -> getAllianceStrategy() == HIGH, new LiftLevel3Command(ls)),
            new Pair<>(() -> getAllianceStrategy() == MID, new LiftLevel2TeleCommand(ls))
        );
    }
}
