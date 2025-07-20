// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.util.sendable.SendableRegistry;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj.util.Color;

/**
 * The methods in this class are called automatically corresponding to each mode, as described in
 * the TimedRobot documentation. If you change the name of this class or the package after creating
 * this project, you must also update the manifest file in the resource directory.
 */
public class Robot extends TimedRobot {
    /** The LED strip object which we will apply operations to */
    private final AddressableLED ledStrip;

    /** The LED Strip buffer that contains every individual LED light in our strip */
    private final AddressableLEDBuffer ledStripBuffer;

    /** Called once at the beginning of the robot program. */
    public Robot() {
        // Uses PWM Port
        ledStrip = new AddressableLED(0);

        // Create the buffer so we can apply data to the ledStrip
        ledStripBuffer = new AddressableLEDBuffer(30);

        // Set the length of the LED Strip (computationally expensive, so we only do it in the init function)
        // AddressableLEDBuffer#getLength (what we did above) returns the length number that we put in
        // Using that call here means that we know the length of the buffer is equal to the ledStrip object's length
        ledStrip.setLength(ledStripBuffer.getLength());

        // Create an LED pattern that sets the entire strip to solid red
        LEDPattern red = LEDPattern.solid(Color.kRed);

        // Apply the LED pattern to the data buffer
        red.applyTo(ledStripBuffer);

        // Set the data
        // This will now use the LEDPattern that we applied to the buffer, which in this case is red
        ledStrip.setData(ledStripBuffer);

        // Starts the LED strip meaning that every tick (time the periodic function runs) it will update the LED strip with the new color
        ledStrip.start();
    }

    /** This function is run once each time the robot enters autonomous mode. */
    @Override
    public void autonomousInit() {}

    /** This function is called periodically during autonomous. */
    @Override
    public void autonomousPeriodic() {}

    /** This function is called once each time the robot enters teleoperated mode. */
    @Override
    public void teleopInit() {}

    /** This function is called periodically during teleoperated mode. */
    @Override
    public void teleopPeriodic() {}

    /** This function is called once each time the robot enters test mode. */
    @Override
    public void testInit() {}

    /** This function is called periodically during test mode. */
    @Override
    public void testPeriodic() {}
}
