package org.firstinspires.ftc.osprey.commands.vision;

import com.technototes.library.command.Command;
import org.firstinspires.ftc.osprey.subsystems.VisionSubsystem;

public class VisionBarcodeCommand implements Command {

    public VisionSubsystem subsystem;

    public VisionBarcodeCommand(VisionSubsystem s) {
        subsystem = s;
        addRequirements(subsystem);
    }

    @Override
    public void initialize() {
        subsystem.startBarcodePipeline();
    }

    @Override
    public void execute() {}

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean cancel) {
        subsystem.stopBarcodePipeline();
    }
}
