package org.firstinspires.ftc.osprey.commands.arm;

import com.technototes.library.command.Command;
import org.firstinspires.ftc.osprey.subsystems.*;

public class BucketCarryCommand implements Command {

    public ArmSubsystem depositSubsystem;

    public BucketCarryCommand(ArmSubsystem s) {
        depositSubsystem = s;
        addRequirements(s);
    }

    @Override
    public void execute() {
        depositSubsystem.setDump(ArmSubsystem.ArmConstants.CARRY);
    }
}
