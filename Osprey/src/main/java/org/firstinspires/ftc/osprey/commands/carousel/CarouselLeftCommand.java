package org.firstinspires.ftc.osprey.commands.carousel;

import static org.firstinspires.ftc.osprey.subsystems.CarouselSubsystem.CarouselConstants.SPIN_OFFSET;

import com.technototes.library.command.Command;
import org.firstinspires.ftc.osprey.subsystems.CarouselSubsystem;

public class CarouselLeftCommand implements Command {

    CarouselSubsystem subsystem;

    public CarouselLeftCommand(CarouselSubsystem s) {
        subsystem = s;
        addRequirements(s);
    }

    @Override
    public void execute() {
        subsystem.left(getRuntime().seconds() / SPIN_OFFSET);
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
