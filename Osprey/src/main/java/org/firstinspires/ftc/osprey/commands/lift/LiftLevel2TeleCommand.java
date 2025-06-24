package org.firstinspires.ftc.osprey.commands.lift;

import org.firstinspires.ftc.osprey.subsystems.LiftSubsystem;

public class LiftLevel2TeleCommand extends LiftCommand {

    public LiftLevel2TeleCommand(LiftSubsystem l) {
        super(l, LiftSubsystem.LiftConstants.TELEOP_LEVEL_2);
    }
}
