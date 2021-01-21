package fr.esgi.homepage;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Homepage {

    public JsonConfig getMenu() {
        Gson gson = new Gson();

        try (Reader reader = new FileReader(System.getProperty("user.dir") + "\\data\\homepage.json")) {

            JsonConfig jsonConfig = gson.fromJson(reader, JsonConfig.class);

            return jsonConfig;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

    public void printMenu() {

        JsonConfig jsonConfig = getMenu();

        if (jsonConfig == null) {
            //Piocher une erreur dans les exceptions

            return;
        }

        System.out.println(getMenu().homepage.get("title") + "\n"
                        + getMenu().homepage.get("1") + "\n"
                        + getMenu().homepage.get("2") + "\n"
                        + getMenu().homepage.get("3") + "\n"
                        + getMenu().homepage.get("4") + "\n"
                        + getMenu().homepage.get("5") + "\n");

    }

}
