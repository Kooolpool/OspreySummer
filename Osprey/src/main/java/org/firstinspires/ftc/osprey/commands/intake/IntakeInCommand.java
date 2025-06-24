package org.firstinspires.ftc.osprey.commands.intake;

import com.technototes.library.command.Command;
import org.firstinspires.ftc.osprey.subsystems.IntakeSubsystem;

public class IntakeInCommand implements Command {

    IntakeSubsystem subsystem;

    public IntakeInCommand(IntakeSubsystem s) {
        subsystem = s;
        addRequirements(s);
    }

    @Override
    public void execute() {
        subsystem.in();
    }
}
