package project;

import java.io.*;

public class CredentialsUtil {
    private static final String FILE_PATH = "credentials.txt"; // Path to your file

    public static void main(String[] args) {
        readCredentialsFromFile();
    }

    public static void readCredentialsFromFile() {
        try (BufferedReader get = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = get.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String email = parts[0];
                    String password = parts[1];

                    System.out.println("Email: " + email + ", Password: " + password);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addCredentialsToFile(String email, String password) {
        try (BufferedWriter post = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            post.write(email + ":" + password);
            post.newLine();
            System.out.println("Credentials added successfully: " + email + ":" + password);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
