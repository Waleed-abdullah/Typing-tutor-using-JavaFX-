package com.Assignment2;

public class SoundSensor extends Sensor {
    private final Lights emergencyLight = new Lights();
    private final Alarm alarm = new Alarm();

    public SoundSensor(boolean isOn, int sensorNumber, String location, boolean isFunctional) {
        super(isOn, sensorNumber, location, isFunctional);
    }


    public void windowBreaks(boolean sound) {
        detectEvent(sound);
    }

    public void gunShot(boolean sound){
        detectEvent(sound);
    }

    @Override
    public void detectEvent(boolean sound) {
        if (sound) {
            setState(true);
            emergencyLight.turnOn();
            alarm.soundAlarm();
            callPolice();
        }
    }

    private void callPolice() {
        System.out.println("Calling the police");
    }

    @Override
    public void resetState() {
        if(getState()){
            setState(false);
            alarm.stopAlarm();
            emergencyLight.resetState();
        }
    }
}
