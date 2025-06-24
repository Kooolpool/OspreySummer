package org.firstinspires.ftc.osprey.commands.arm;

import org.firstinspires.ftc.osprey.subsystems.ArmSubsystem;
import org.firstinspires.ftc.osprey.subsystems.VisionSubsystem;

public class ArmBarcodeSelectCommand extends ArmCommand {

    public VisionSubsystem visionSubsystem;

    public ArmBarcodeSelectCommand(ArmSubsystem s, VisionSubsystem v) {
        super(s);
        visionSubsystem = v;
    }

    @Override
    public void execute() {
        subsystem.carry();
        if (visionSubsystem.barcodePipeline.zero()) subsystem.down();
        else subsystem.out();
    }
}
