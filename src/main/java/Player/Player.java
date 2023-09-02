package Player;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final String username;
    private int score;
    private List<String> usedPlayerCities;
    private String status;

    public Player(String username) {
        this.username = username;
        this.score = 0;
    }

    public void increaseScore() {
        this.score++;
    }

    public String getUsername() {
        return username;
    }

    public int getScore() {
        return score;
    }

    public void savePlayerCity(String playerCity) {
        if (usedPlayerCities == null)
            usedPlayerCities = new ArrayList<>();

        usedPlayerCities.add(playerCity);
    }

    public List<String> getUsedPlayerCities() {
        return usedPlayerCities;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
