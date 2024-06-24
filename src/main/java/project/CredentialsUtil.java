package project;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class CredentialsUtil {
    private static final String FILE_PATH = "src/main/java/project/credentials.txt";

    public static String getCredentials() {
        StringBuilder credentials = new StringBuilder();
        File file = new File(FILE_PATH);
        try (BufferedReader get = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = get.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String email = parts[0];
                    String password = parts[1];
                    credentials.append(email).append(":").append(password).append("\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return credentials.toString();
    }

    public static void postCredentials(String email, String password) {
        try (BufferedWriter post = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            post.write("\n" + email + ":" + password);
            post.newLine();
            System.out.println("New account created.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
