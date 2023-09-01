package Player;

public class Player {
    private final String username;
    private int score;

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
}
