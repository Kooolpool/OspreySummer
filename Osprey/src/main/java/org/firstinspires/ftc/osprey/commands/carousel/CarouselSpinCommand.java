package org.firstinspires.ftc.osprey.commands.carousel;

import com.technototes.library.command.Command;
import com.technototes.library.util.Alliance;
import org.firstinspires.ftc.osprey.RobotConstants;
import org.firstinspires.ftc.osprey.subsystems.CarouselSubsystem;

public class CarouselSpinCommand implements Command {

    CarouselSubsystem subsystem;

    public CarouselSpinCommand(CarouselSubsystem s) {
        subsystem = s;
        addRequirements(s);
    }

    @Override
    public void execute() {
        if (RobotConstants.getAlliance() == Alliance.RED) subsystem.left();
        else subsystem.right();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean cancel) {
        subsystem.stop();
    }
}
