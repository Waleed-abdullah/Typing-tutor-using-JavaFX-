package com.Assignment2;

public class Alarm implements AlarmInterface {
    private boolean isOn = false;

   @Override
    public void soundAlarm(){
        isOn = true;
        System.out.println("Sounding the Alarm!");
    }

    @Override
    public void stopAlarm(){
        isOn = false;
        System.out.println("The alarm has been stopped");
    }
}
