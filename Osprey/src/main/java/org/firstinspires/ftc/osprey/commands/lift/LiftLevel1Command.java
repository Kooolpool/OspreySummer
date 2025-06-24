package org.firstinspires.ftc.osprey.commands.lift;

import org.firstinspires.ftc.osprey.subsystems.LiftSubsystem;

public class LiftLevel1Command extends LiftCommand {

    public LiftLevel1Command(LiftSubsystem l) {
        super(l, LiftSubsystem.LiftConstants.LEVEL_1);
    }
}
