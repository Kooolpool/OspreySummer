package org.firstinspires.ftc.osprey.commands.deposit;

import com.technototes.library.command.ParallelCommandGroup;
import org.firstinspires.ftc.osprey.commands.arm.ArmBarcodeSelectCommand;
import org.firstinspires.ftc.osprey.commands.extension.ExtensionBarcodeSelectCommand;
import org.firstinspires.ftc.osprey.commands.lift.LiftBarcodeSelectCommand;
import org.firstinspires.ftc.osprey.subsystems.ArmSubsystem;
import org.firstinspires.ftc.osprey.subsystems.ExtensionSubsystem;
import org.firstinspires.ftc.osprey.subsystems.LiftSubsystem;
import org.firstinspires.ftc.osprey.subsystems.VisionSubsystem;

public class DepositPreloadCommand extends ParallelCommandGroup {

    public DepositPreloadCommand(
        ArmSubsystem arm,
        ExtensionSubsystem extension,
        LiftSubsystem lift,
        VisionSubsystem vision
    ) {
        super(
            new LiftBarcodeSelectCommand(lift, vision).withTimeout(1),
            new ArmBarcodeSelectCommand(arm, vision),
            new ExtensionBarcodeSelectCommand(extension, vision)
        );
    }
}
