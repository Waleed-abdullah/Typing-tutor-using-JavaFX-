package com.Assignment2;

public class Lights implements LightInterface{
    private boolean isOn = false;

    public boolean isOn() {
        return isOn;
    }

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Turning the emergency lights on!");
    }

    @Override
    public void resetState(){
        isOn = false;
        System.out.println("Turning the emergency lights off");
    }

}
