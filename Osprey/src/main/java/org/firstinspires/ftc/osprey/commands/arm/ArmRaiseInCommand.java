package org.firstinspires.ftc.osprey.commands.arm;

import org.firstinspires.ftc.osprey.subsystems.*;

public class ArmRaiseInCommand extends ArmCommand {

    public ArmRaiseInCommand(ArmSubsystem s) {
        super(s);
    }

    @Override
    public void execute() {
        if (getRuntime().seconds() > 0.2) subsystem.fakeCarry();
        subsystem.up();
    }

    @Override
    public boolean isFinished() {
        return getRuntime().seconds() > 0.3;
    }
}
