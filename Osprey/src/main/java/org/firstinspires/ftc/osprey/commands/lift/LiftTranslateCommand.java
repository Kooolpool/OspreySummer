package org.firstinspires.ftc.osprey.commands.lift;

import org.firstinspires.ftc.osprey.subsystems.LiftSubsystem;

public class LiftTranslateCommand extends LiftCommand {

    public LiftTranslateCommand(LiftSubsystem ls, double amt) {
        super(ls, amt);
    }

    @Override
    public void initialize() {
        liftSys.setLiftPosition(liftSys.get() + doubleSupplier.getAsDouble());
    }

    @Override
    public void execute() {}

    @Override
    public boolean isFinished() {
        return super.isFinished() && getRuntime().seconds() > 0.1;
    }
}
