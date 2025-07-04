package org.firstinspires.ftc.osprey.commands.arm;

import com.technototes.library.command.Command;
import org.firstinspires.ftc.osprey.subsystems.*;

public class BucketDumpCommand implements Command {

    public ArmSubsystem depositSubsystem;

    public BucketDumpCommand(ArmSubsystem s) {
        depositSubsystem = s;
        addRequirements(s);
    }

    @Override
    public void execute() {
        depositSubsystem.dump();
    }

    @Override
    public boolean isFinished() {
        return getRuntime().seconds() > 0.3;
    }
}
