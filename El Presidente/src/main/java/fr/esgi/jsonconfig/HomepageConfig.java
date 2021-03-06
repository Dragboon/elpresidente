package fr.esgi.jsonconfig;

import java.util.Map;

public class HomepageConfig {
    private Map<String, String> title;
    private Map<Integer, String> homepage;
    private Map<String, Double[]> difficulty;
    private String username;

    public Map<Integer, String> getHomepage() {
        return homepage;
    }

    public Map<String, Double[]> getDifficulty() {
        return difficulty;
    }

    public Map<String, String> getTitle() {
        return title;
    }

    public String getUsername() {
        return username;
    }
}
