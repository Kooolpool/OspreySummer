package org.firstinspires.ftc.osprey.commands.intake;

import com.technototes.library.command.Command;
import org.firstinspires.ftc.osprey.subsystems.IntakeSubsystem;

public class IntakeStopCommand implements Command {

    IntakeSubsystem subsystem;

    public IntakeStopCommand(IntakeSubsystem s) {
        subsystem = s;
        addRequirements(s);
    }

    @Override
    public void execute() {
        subsystem.stop();
    }
}
