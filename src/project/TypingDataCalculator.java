package project;

public class TypingDataCalculator {
    //words per min
    private int wpm;
    private double accuracy;
    private int wrongKeyStrokes;
    private int totalKeyStrokes;
    private int correctKeyStrokes;
    //time taken in seconds

    private double timeTaken;
    public TypingDataCalculator(int totalKeyStrokes, int wrongKeyStrokes, int timeTaken) {
        this.wrongKeyStrokes = wrongKeyStrokes;
        this.timeTaken = timeTaken;
        this.totalKeyStrokes = totalKeyStrokes;
        correctKeyStrokes = totalKeyStrokes - wrongKeyStrokes;
    }

    public int calculateWPM() {
        double timeTakenInMin = timeTaken / 60;//converting in minutes

        //formula for calculating wpm
        wpm = (int) ((totalKeyStrokes / 5) / timeTakenInMin);
        return wpm;
    }

    public double calculateAccuracy(){
       //formula to calculate accuracy
        accuracy = ( (double) correctKeyStrokes / (double) totalKeyStrokes) * 100;
        return accuracy;
    }

    public int getWrongKeyStrokes() {
        return wrongKeyStrokes;
    }

    public int getTotalKeyStrokes() {
        return totalKeyStrokes;
    }

    public int getCorrectKeyStrokes() {
        return correctKeyStrokes;
    }
}
