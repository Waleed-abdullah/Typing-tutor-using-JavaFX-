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
        motionSensor.detectEvent(isThief);

        if (isThief) {
            boolean isCaught = false;
            System.out.println("Has the thief been caught?");
            isCaught = input.nextBoolean();
            if(isCaught) {
                motionSensor.resetState();
            }
        }

        boolean isFire = false;
        System.out.println("Is there a fire?");
        isFire = input.nextBoolean();
        smokeSensor.detectEvent(isFire);
        if (isFire) {
            boolean isExtinguished = false;
            System.out.println("Has the fire been extinguished?");
            isExtinguished = input.nextBoolean();
            if(isExtinguished) {
                smokeSensor.resetState();
            }
        }

        input.nextLine();
        String Sound;
        System.out.println("Describe what has happened?\nGun Fire or Window Break");
        Sound = input.nextLine();
        if (Sound.equals("Window Break")) {
            soundSensor.windowBreaks(true);
        }
        else if(Sound.equals("Gun Fire")){
            soundSensor.gunShot(true);
        }

        if(Sound.equals("Window Break")||Sound.equals("Gun Fire")){
            soundSensor.resetState();
        }

    }
}
