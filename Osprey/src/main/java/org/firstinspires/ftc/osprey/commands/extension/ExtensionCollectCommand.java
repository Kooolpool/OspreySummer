package org.firstinspires.ftc.osprey.commands.extension;

import static org.firstinspires.ftc.osprey.subsystems.ExtensionSubsystem.ExtensionConstants;

import org.firstinspires.ftc.osprey.subsystems.ExtensionSubsystem;

public class ExtensionCollectCommand extends ExtensionCommand {

    public ExtensionCollectCommand(ExtensionSubsystem subsystem) {
        super(subsystem, ExtensionConstants.IN, ExtensionConstants.CENTER);
    }

    @Override
    public boolean isFinished() {
        return getRuntime().seconds() > 0.7;
    }
}
