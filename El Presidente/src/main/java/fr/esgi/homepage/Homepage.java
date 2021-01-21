package fr.esgi.homepage;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Homepage {

    public void menu() {

        Gson gson = new Gson();

        try (Reader reader = new FileReader(System.getProperty("user.dir") + "\\data\\homepage.json")) {

            JsonConfig string = gson.fromJson(reader, JsonConfig.class);
            System.out.println(string.homepage.get("title"));
            System.out.println(string.difficulty.get("easy"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
