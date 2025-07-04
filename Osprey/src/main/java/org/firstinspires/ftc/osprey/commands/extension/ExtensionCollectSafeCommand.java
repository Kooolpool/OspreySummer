package org.firstinspires.ftc.osprey.commands.extension;

import static org.firstinspires.ftc.osprey.subsystems.ExtensionSubsystem.ExtensionConstants;

import org.firstinspires.ftc.osprey.subsystems.ExtensionSubsystem;

public class ExtensionCollectSafeCommand extends ExtensionCommand {

    public ExtensionCollectSafeCommand(ExtensionSubsystem subsystem) {
        super(subsystem, ExtensionConstants.IN, ExtensionConstants.CENTER);
    }

    @Override
    public void execute() {
        extensionSubsystem.setTurret(turretTarget);
        if (getRuntime().seconds() > 0.3) extensionSubsystem.setSlide(slideTarget);
    }

    @Override
    public boolean isFinished() {
        return getRuntime().seconds() > 0.5;
    }
}
