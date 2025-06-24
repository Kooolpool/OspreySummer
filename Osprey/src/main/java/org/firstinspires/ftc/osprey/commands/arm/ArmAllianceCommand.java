package org.firstinspires.ftc.osprey.commands.arm;

import org.firstinspires.ftc.osprey.subsystems.ArmSubsystem;

public class ArmAllianceCommand extends ArmCommand {

    public ArmAllianceCommand(ArmSubsystem s) {
        super(s);
    }

    @Override
    public void execute() {
        subsystem.out();
        subsystem.carry();
    }
}
