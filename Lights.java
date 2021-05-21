package com.Assignment2;

public class Lights {
    private boolean isOn = false;

    public boolean isOn() {
        return isOn;
    }

    public void turnOn() {
        isOn = true;
        System.out.println("Turning the emergency lights on!");
    }

    public void resetState(){
        isOn = false;
        System.out.println("Turning the emergency lights off");
    }

}
