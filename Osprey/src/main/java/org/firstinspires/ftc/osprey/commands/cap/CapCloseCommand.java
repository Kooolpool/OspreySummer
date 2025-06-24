package org.firstinspires.ftc.osprey.commands.cap;

import com.technototes.library.command.Command;
import org.firstinspires.ftc.osprey.subsystems.CapSubsystem;

public class CapCloseCommand implements Command {

    public CapSubsystem subsystem;

    public CapCloseCommand(CapSubsystem cap) {
        subsystem = cap;
        addRequirements(cap);
    }

    @Override
    public void execute() {
        subsystem.close();
    }
}
