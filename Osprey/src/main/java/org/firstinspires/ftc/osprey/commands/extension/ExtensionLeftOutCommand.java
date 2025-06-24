package org.firstinspires.ftc.osprey.commands.extension;

import org.firstinspires.ftc.osprey.subsystems.ExtensionSubsystem;

public class ExtensionLeftOutCommand extends ExtensionLeftSideCommand {

    public ExtensionLeftOutCommand(ExtensionSubsystem subsystem) {
        super(subsystem, ExtensionSubsystem.ExtensionConstants.OUT);
    }
}
