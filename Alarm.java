package com.Assignment2;

public class Alarm {
    private boolean isOn = false;

    public void soundAlarm(){
        isOn = true;
        System.out.println("Sounding the Alarm!");
    }

    public void stopAlarm(){
        isOn = false;
        System.out.println("The alarm has been stopped");
    }
}
