package org.firstinspires.ftc.osprey.commands.extension;

import org.firstinspires.ftc.osprey.subsystems.ExtensionSubsystem;

public class ExtensionRightOutCommand extends ExtensionRightSideCommand {

    public ExtensionRightOutCommand(ExtensionSubsystem subsystem) {
        super(subsystem, ExtensionSubsystem.ExtensionConstants.OUT);
    }
}
