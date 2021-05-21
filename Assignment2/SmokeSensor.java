package com.Assignment2;

public class SmokeSensor extends Sensor {
    private final LightInterface emergencyLight = new Lights();
    private final AlarmInterface alarm = new Alarm();

    public SmokeSensor(boolean isOn, int sensorNumber, String location, boolean isFunctional) {
        super(isOn, sensorNumber, location, isFunctional);
    }

    public void detectEvent(boolean detect ) {
        if (detect && isFunctional()) {
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
        if (getState() && isFunctional()) {
            setState(false);
            System.out.println("Resetting the smoke sensor");
            emergencyLight.resetState();
            alarm.stopAlarm();
        }
    }
}
