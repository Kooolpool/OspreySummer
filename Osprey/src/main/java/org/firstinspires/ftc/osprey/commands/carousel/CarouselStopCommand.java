package org.firstinspires.ftc.osprey.commands.carousel;

import com.technototes.library.command.Command;
import org.firstinspires.ftc.osprey.subsystems.CarouselSubsystem;

public class CarouselStopCommand implements Command {

    public CarouselSubsystem subsystem;

    public CarouselStopCommand(CarouselSubsystem s) {
        subsystem = s;
        addRequirements(s);
    }

    @Override
    public void execute() {
        subsystem.stop();
    }
}
