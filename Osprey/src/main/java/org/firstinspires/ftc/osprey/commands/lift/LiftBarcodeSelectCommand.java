package org.firstinspires.ftc.osprey.commands.lift;

import android.util.Pair;
import com.technototes.library.command.ChoiceCommand;
import org.firstinspires.ftc.osprey.subsystems.LiftSubsystem;
import org.firstinspires.ftc.osprey.subsystems.VisionSubsystem;

public class LiftBarcodeSelectCommand extends ChoiceCommand {

    public LiftBarcodeSelectCommand(LiftSubsystem lift, VisionSubsystem vision) {
        super(
            new Pair<>(vision.barcodePipeline::zero, new LiftLevel1Command(lift)),
            new Pair<>(vision.barcodePipeline::one, new LiftLevel2Command(lift)),
            new Pair<>(vision.barcodePipeline::twoOrDefault, new LiftLevel3Command(lift))
        );
    }
}
