
/**
 * Player class represents the player who plays this game.
 * @author Sen
 * @version 1.0
 */
public class Player {
    private int score;
    private int money;

    /**
     * Default constructor of Player class.
     */
    public Player() {
        setScore(200);
        setMoney(500);
    }

    /**
     * Convert int type to string type
     * @return string type for money
     */
    public String moneyToString() {
        return Integer.toString(money);
    }

    /**
     * Convert int type to string type
     * @return string type for score
     */
    public String scoreToString() {
        return Integer.toString(score);
    }

    /**
     * get score
     * @return get score
     */
    public int getScore() {
        return score;
    }

    /**
     * set score
     * @param score set score to the parameter value
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * get money
     * @return get player's money
     */
    public int getMoney() {
        return money;
    }

    /**
     * set money
     * @param money set money to the parameter value
     */
    public void setMoney(int money) {
        this.money = money;
    }

    /**
     * update player's money after building a new tower.
     * @param towerType according to the towerType to subtract the total money
     */
    public void minusCost(String towerType) {
        if (towerType.equals("AdvancedTower")) {
            money = money - 100;
        } else {
            money = money - 60;
        }
    }
}
