package project;

public class User  {
    private String userName;
    private String password;
    private int keystroke;
    private int correctWords;
    private int wrongWords;
    private double accuracy;
    private int wpm;

    public User() {

    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public int getKeystroke() {
        return keystroke;
    }

    public void setKeystroke(int keystroke) {
        this.keystroke = keystroke;
    }

    public int getCorrectWords() {
        return correctWords;
    }

    public void setCorrectWords(int correctWords) {
        this.correctWords = correctWords;
    }

    public int getWrongWords() {
        return wrongWords;
    }

    public void setWrongWords(int wrongWords) {
        this.wrongWords = wrongWords;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }

    public int getWpm() {
        return wpm;
    }

    public void setWpm(int wpm) {
        this.wpm = wpm;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
