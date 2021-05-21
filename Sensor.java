package com.Assignment2;

import java.util.Date;

public abstract class Sensor {
    private boolean isOn = false;
    private int sensorNumber;
    private String location;
    private boolean isFunctional;
    private Date dateInstalled;

    public Sensor(boolean isOn, int sensorNumber, String location, boolean isFunctional) {
        this.isOn = isOn;
        this.sensorNumber = sensorNumber;
        this.location = location;
        this.isFunctional = isFunctional;
        this.dateInstalled = new Date();
    }

    public boolean getState() {
        return isOn;
    }

    public void setState(boolean on) {
        isOn = on;
    }


    public abstract void detectEvent(boolean event);

    public abstract void resetState();

    public int getSensorNumber() {
        return sensorNumber;
    }

    public Date getDateInstalled() {
        return dateInstalled;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isFunctional() {
        return isFunctional;
    }

    public void setFunctional(boolean functional) {
        isFunctional = functional;
    }
}
