package project;

import java.io.*;
import java.util.Scanner;

public class CredentialsUtil {
    private static final String FILE_PATH = "credentials.txt";

    public static void main(String[] args) {
        try {
            File myObj = new File("filename.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static String getCredentials() {
        StringBuilder credentials = new StringBuilder();
        try (BufferedReader get = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = get.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String email = parts[0];
                    String password = parts[1];
                    credentials.append("Email: ").append(email).append(", Password: ").append(password).append("\n");
                    //System.out.println("Email: " + email + ", Password: " + password);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void PostCredentials(String email, String password) {
        try (BufferedWriter post = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            post.write(email + ":" + password);
            post.newLine();
            System.out.println("Credentials added successfully: " + email + ":" + password);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
