package org.firstinspires.ftc.osprey.commands.autonomous;

import com.technototes.library.command.SequentialCommandGroup;
import com.technototes.library.command.WaitCommand;
import com.technototes.path.command.TrajectorySequenceCommand;
import org.firstinspires.ftc.osprey.RobotConstants;
import org.firstinspires.ftc.osprey.commands.intake.IntakeInCommand;
import org.firstinspires.ftc.osprey.subsystems.DrivebaseSubsystem;
import org.firstinspires.ftc.osprey.subsystems.IntakeSubsystem;

public class AutoIntakeDuckCommand extends SequentialCommandGroup {

    public AutoIntakeDuckCommand(DrivebaseSubsystem drive, IntakeSubsystem intake) {
        super(
            //drive::relocalize,
            new TrajectorySequenceCommand(drive, RobotConstants.CAROUSEL_TO_DUCK_INTAKE).alongWith(
                new IntakeInCommand(intake)
            ),
            new WaitCommand(1)
        );
    }
}
