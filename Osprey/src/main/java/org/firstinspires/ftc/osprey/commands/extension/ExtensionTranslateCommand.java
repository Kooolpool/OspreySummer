package org.firstinspires.ftc.osprey.commands.extension;

import org.firstinspires.ftc.osprey.subsystems.ExtensionSubsystem;

public class ExtensionTranslateCommand extends ExtensionCommand {

    public ExtensionTranslateCommand(ExtensionSubsystem subsystem, double slide) {
        super(subsystem, slide, 0);
    }

    @Override
    public void initialize() {
        extensionSubsystem.translateSlide(slideTarget);
    }

    @Override
    public void execute() {}

    @Override
    public boolean isFinished() {
        return getRuntime().seconds() > 0.05;
    }
}
