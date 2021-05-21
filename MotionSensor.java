package com.Assignment2;

public class MotionSensor extends Sensor{
    private final Lights emergencyLight = new Lights();
    private final Alarm alarm = new Alarm();
    public MotionSensor(boolean isOn, int sensorNumber, String location, boolean isFunctional) {
        super(isOn, sensorNumber, location, isFunctional);
    }
    @Override
    public void detectEvent(boolean motion){
        if(motion){
            setState(true);
            emergencyLight.turnOn();
            alarm.soundAlarm();
            lockDoors();
            callPolice();
        }
    }

    private void callPolice() {
        System.out.println("Calling the police!");
    }

    private void lockDoors(){
        System.out.println("locking the doors.");
    }

    private void unlockDoors(){
        System.out.println("Unlocking the doors");
    }

    @Override
    public void resetState() {
        if (getState()) {
                setState(false);
            System.out.println("Resetting the motionSensor.");
                emergencyLight.resetState();
                alarm.stopAlarm();
                unlockDoors();
        }
    }


}