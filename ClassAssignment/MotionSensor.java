package com.ClassAssignment;

public class MotionSensor extends Sensor{
    private Lights emergencyLight = new Lights();
    private Alarm alarm = new Alarm();
    public MotionSensor(boolean isOn, int sensorNumber, String location, boolean isFunctional) {
        super(isOn, sensorNumber, location, isFunctional);
    }

    public void detectMotion(boolean motion){
        if(motion){
            setState(true);
            emergencyLight.turnOn();
            alarm.soundAlarm();
            System.out.println("Smoke has been detected!");
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
