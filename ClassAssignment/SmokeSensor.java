package com.ClassAssignment;

public class SmokeSensor extends Sensor {
    private Lights emergencyLight = new Lights();
    private Alarm alarm = new Alarm();

    public SmokeSensor(boolean isOn, int sensorNumber, String location, boolean isFunctional) {
        super(isOn, sensorNumber, location, isFunctional);
    }

    public void detectSmoke(boolean detect) {
        if (detect) {
            setState(true);
            emergencyLight.turnOn();
            alarm.soundAlarm();
            System.out.println("Smoke has been detected!");
            callFireBrigade();
        }
    }

    private void callFireBrigade() {
        System.out.println("Calling the Fire Brigade!!!");
    }


    @Override
    public void resetState() {
        if (getState()) {
            setState(false);
            System.out.println("Resetting the smoke sensor");
            emergencyLight.resetState();
            alarm.stopAlarm();
        }
    }
}
