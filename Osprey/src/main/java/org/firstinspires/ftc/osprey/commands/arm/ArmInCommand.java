package org.firstinspires.ftc.osprey.commands.arm;

import org.firstinspires.ftc.osprey.subsystems.*;

public class ArmInCommand extends ArmCommand {

    public ArmInCommand(ArmSubsystem s) {
        super(s);
    }

    @Override
    public void execute() {
        subsystem.in();
        subsystem.collect();
    }

    @Override
    public boolean isFinished() {
        return getRuntime().seconds() > 0.4;
    }
}
