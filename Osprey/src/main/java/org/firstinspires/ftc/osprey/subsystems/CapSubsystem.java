package org.firstinspires.ftc.osprey.subsystems;

import static org.firstinspires.ftc.osprey.subsystems.CapSubsystem.CapConstants.*;

import com.acmerobotics.dashboard.config.Config;
import com.technototes.library.command.CommandScheduler;
import com.technototes.library.hardware.servo.Servo;
import com.technototes.library.hardware.servo.ServoProfiler;
import com.technototes.library.subsystem.Subsystem;
import java.util.function.Supplier;

public class CapSubsystem implements Subsystem, Supplier<String> {

    @Config
    public static class CapConstants {

        public static double TURRET_INIT = 0.8, TURRET_PICKUP = 0.1, TURRET_CARRY =
            0.8, TURRET_CAP = 0.5;
        public static double CLAW_OPEN = 0.1, CLAW_CLOSE = 0.53;
        public static double ARM_UP = 1, ARM_CAP = 0.85, ARM_INIT = 0.4, ARM_DOWN = 0.05;
        public static ServoProfiler.Constraints ARM_CONSTRAINTS = new ServoProfiler.Constraints(
            5,
            5,
            5
        );
        public static ServoProfiler.Constraints TURRET_CONSTRAINTS = new ServoProfiler.Constraints(
            3,
            2,
            2
        );
    }

    public Servo armLServo;
    public Servo armRServo;
    public Servo clawServo;

    public Servo turretServo;

    public ServoProfiler armProfilerL;
    public ServoProfiler armProfilerR;
    public ServoProfiler turretProfiler;

    public CapSubsystem(Servo armL, Servo armR, Servo claw, Servo turret) {
        CommandScheduler.register(this);
        armLServo = armL;
        armRServo = armR;
        clawServo = claw;
        turretServo = turret;
        armProfilerL = new ServoProfiler(armLServo)
            .setServoRange(0.4)
            .setConstraints(ARM_CONSTRAINTS)
            .setTargetPosition(ARM_INIT);
        armProfilerR = new ServoProfiler(armRServo)
            .setServoRange(0.4)
            .setConstraints(ARM_CONSTRAINTS)
            .setTargetPosition(ARM_INIT);
        turretProfiler = new ServoProfiler(turretServo)
            .setConstraints(TURRET_CONSTRAINTS)
            .setTargetPosition(TURRET_INIT);
    }

    public void open() {
        clawServo.setPosition(CLAW_OPEN);
    }

    public void close() {
        clawServo.setPosition(CLAW_CLOSE);
    }

    public void up() {
        armProfilerL.setTargetPosition(ARM_UP);
        armProfilerR.setTargetPosition(ARM_UP);
        turretProfiler.setTargetPosition(TURRET_CARRY);
        clawServo.setPosition(CLAW_CLOSE);
    }

    public void raise() {
        armProfilerL.setTargetPosition(ARM_CAP);
        armProfilerR.setTargetPosition(ARM_CAP);
    }

    public void raise2() {
        turretProfiler.setTargetPosition(TURRET_CAP);
    }

    public void down() {
        armProfilerL.setTargetPosition(ARM_DOWN);
        armProfilerR.setTargetPosition(ARM_DOWN);
        turretProfiler.setTargetPosition(TURRET_PICKUP);
    }

    public void translateArm(double translation) {
        armProfilerL.translateTargetPosition(translation);
        armProfilerR.translateTargetPosition(translation);
    }

    public void translateTurret(double translation) {
        turretProfiler.translateTargetPosition(translation);
    }

    @Override
    public void periodic() {
        turretProfiler.update();
        armProfilerL.update();
        armProfilerR.update();
    }

    @Override
    public String get() {
        return (
            "CLAW: " +
            clawServo.getPosition() +
            ", ARML: " +
            armProfilerL.getTargetPosition() +
            ", ARMR: " +
            armProfilerR.getTargetPosition() +
            ", TURRET: " +
            turretProfiler.getTargetPosition()
        );
    }
}
