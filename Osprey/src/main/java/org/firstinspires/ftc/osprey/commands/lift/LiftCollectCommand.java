package org.firstinspires.ftc.osprey.commands.lift;

import org.firstinspires.ftc.osprey.subsystems.LiftSubsystem;

public class LiftCollectCommand extends LiftCommand {

    public LiftCollectCommand(LiftSubsystem l) {
        super(l, LiftSubsystem.LiftConstants.COLLECT);
    }
}
