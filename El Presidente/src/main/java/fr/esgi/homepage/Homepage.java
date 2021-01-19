package fr.esgi.homepage;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Homepage {

    public void menu() {

        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader(System.getProperty("user.dir") + "\\data\\homepage.json")) {

            Object data = parser.parse(reader);
            JSONArray fileData = (JSONArray) data;

            System.out.println(fileData);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

}
