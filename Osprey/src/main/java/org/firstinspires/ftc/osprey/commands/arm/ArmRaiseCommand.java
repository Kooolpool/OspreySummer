package org.firstinspires.ftc.osprey.commands.arm;

import org.firstinspires.ftc.osprey.subsystems.*;

public class ArmRaiseCommand extends ArmCommand {

    public ArmRaiseCommand(ArmSubsystem s) {
        super(s);
    }

    @Override
    public void execute() {
        subsystem.carry();
        subsystem.up();
    }
}
