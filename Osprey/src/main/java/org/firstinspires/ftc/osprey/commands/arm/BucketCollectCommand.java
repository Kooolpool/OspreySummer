package org.firstinspires.ftc.osprey.commands.arm;

import com.technototes.library.command.Command;
import org.firstinspires.ftc.osprey.subsystems.*;

public class BucketCollectCommand implements Command {

    public ArmSubsystem depositSubsystem;

    public BucketCollectCommand(ArmSubsystem s) {
        depositSubsystem = s;
        addRequirements(s);
    }

    @Override
    public void execute() {
        depositSubsystem.setDump(ArmSubsystem.ArmConstants.COLLECT);
    }

    @Override
    public boolean isFinished() {
        return getRuntime().seconds() > 0.5;
    }
}
