package project;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.FormatterClosedException;

public class FileHandling {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();
    public FileHandling() {
    }

    public void addRecords(User user) {
        try (PrintWriter output = new PrintWriter(new BufferedWriter(
                new FileWriter("records.txt", true)))) {
            output.format("%s\n%s\n", user.getUserName(), user.getPassword());
        } catch (FormatterClosedException formatterClosedException) {
            System.err.println("Error writing to file");
        } catch (IOException ioException) {
            System.err.println("Error opening file");
        }
    }

    public boolean checkUserName(User user) {

        try (BufferedReader input = new BufferedReader(new FileReader("records.txt"))) {
            String s;
            while ((s = input.readLine()) != null) {
                if (user.getUserName().equals(s)) {
                    return true;
                }
            }
        } catch (IOException ioException) {
            System.err.println("Error checking user names");
        }
        return false;
    }

    public boolean authenticate(User user) {
        try (BufferedReader input = new BufferedReader(new FileReader("records.txt"))) {
            String s;
            while ((s = input.readLine()) != null && checkUserName(user)) {
                if ((s = input.readLine()) != null && user.getPassword().equals(s)) {
                    System.out.println("Success");
                    return true;
                }
            }
        } catch (IOException ioException) {
            System.err.println("Error authenticating");
        }
        return false;
    }

    public void addResults(User user){
        try(PrintWriter printWriter = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(user.getUserName()+".txt",true)))){
            printWriter.println("Summary");
            printWriter.format("Time: %s\n",dtf.format(now));
            printWriter.format("Speed: %s\n",user.getWpm());
            printWriter.println(String.format("Accuracy: %.1f",user.getAccuracy())+"%");
            printWriter.format("Total Keystrokes: %s\n",user.getKeystroke());
            printWriter.format("Correct Keystrokes: %s\n",user.getCorrectWords());
            printWriter.format("Wrong Keystrokes: %s\n",user.getWrongWords());
            printWriter.format("_ _ _ _ _ _ _ _ _ _ _\n");
        }
        catch (IOException ioException){
            System.err.println("File not created.");
        }
    }

}

