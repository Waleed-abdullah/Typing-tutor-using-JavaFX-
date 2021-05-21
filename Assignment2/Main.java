package com.Assignment2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        MotionSensor motionSensor = new MotionSensor(false, 1, "Corner", true);
        SmokeSensor smokeSensor = new SmokeSensor(false, 2, "Front", true);
        SoundSensor soundSensor = new SoundSensor(false, 3, "Center", true);

        boolean isThief = false;
        System.out.println("Has a thief entered the facility?");
        isThief = input.nextBoolean();
        System.out.println();
        motionSensor.detectEvent(isThief);

        if (isThief) {
            boolean isCaught = false;
            System.out.println();
            System.out.println("Has the thief been caught?");
            isCaught = input.nextBoolean();
            System.out.println();
            if (isCaught) {
                motionSensor.resetState();
            }
        }

        boolean isFire = false;
        System.out.println();
        System.out.println("Is there a fire?");
        isFire = input.nextBoolean();
        smokeSensor.detectEvent(isFire);
        if (isFire) {
            boolean isExtinguished = false;
            System.out.println();
            System.out.println("Has the fire been extinguished?");
            isExtinguished = input.nextBoolean();
            System.out.println();
            if (isExtinguished) {
                smokeSensor.resetState();
            }
        }

        input.nextLine();
        String Sound;
        System.out.println();
        System.out.println("Describe what has happened?\nGun Fire or Window Break");
        Sound = input.nextLine();
        System.out.println();
        if (Sound.equals("Window Break")) {
            soundSensor.windowBreaks(true);
        } else if (Sound.equals("Gun Fire")) {
            soundSensor.gunShot(true);
        }

        boolean soundAlarmState = false;
        System.out.println();
        System.out.println("Do you wish to reset the state of the sound Alarm?");
        soundAlarmState = input.nextBoolean();
        if (soundAlarmState) {
            System.out.println();
            soundSensor.resetState();
        } else
            System.out.println("The sensor was not reset");
    }
}
