package project;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import org.json.*;

public class JsonUtil {

    private static final String USERS_FILE = "users.json";

    public static void addUser(String email, String password) {
        JSONArray usersArray = readUsers();
        JSONObject newUser = new JSONObject();
        newUser.put("email", email);
        newUser.put("password", password);
        usersArray.put(newUser);

        try (FileWriter file = new FileWriter(USERS_FILE)) {
            file.write(usersArray.toString(4)); // 4 is the number of spaces for indentation
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONArray readUsers() {
        try {
            InputStream inputStream = Files.newInputStream(Paths.get(USERS_FILE));
            Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8.name());
            String jsonText = scanner.useDelimiter("\\A").next();
            scanner.close();
            return new JSONArray(jsonText);
        } catch (Exception e) {
            // Return an empty JSONArray if the file doesn't exist or there's an error reading it
            return new JSONArray();
        }
    }

}
