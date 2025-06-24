package org.firstinspires.ftc.osprey.commands.lift;

import org.firstinspires.ftc.osprey.subsystems.LiftSubsystem;

public class LiftSharedCommand extends LiftCommand {

    public LiftSharedCommand(LiftSubsystem l) {
        super(l, LiftSubsystem.LiftConstants.NEUTRAL);
    }
}
